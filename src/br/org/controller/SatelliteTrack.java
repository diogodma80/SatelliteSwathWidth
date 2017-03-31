package br.org.controller;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import br.org.app.view.SwathWidthTable;
import br.org.model.lambda.CalculaLambdaAhead;
import br.org.model.lambda.CalculaLambdaCentral;
import br.org.model.lambda.CalculaLambdaLateral;
import br.org.model.phi.CalculaPhiAhead;
import br.org.model.phi.CalculaPhiCentral;
import br.org.model.phi.CalculaPhiLateral;
import br.org.model.swath.CalculaAnguloC;
import br.org.model.swath.CalculaCoordenadasCartesianas;
import br.org.model.swath.CalculaHipotenusaP;
import br.org.model.swath.ProximoPhiLambda;

/**
 * 
 * @author diogo
 *
 */

public class SatelliteTrack {

	/**
	 * parametros de entrada para a classe
	 * 
	 */
	private double subSatellitePoints;
	private double sensorHeading;
	private double latitude;
	private double longitude;
	private double boresightDistance;
	private double nextPointAheadDistance;
	private double apertureAngle;
	private double altitudeInMeters;
	private double boresightAngle;
	private double lateralDistanceToRight;
	private double lateralDistanceToLeft;

	/**
	 * latitudeCentral e longitudeCentral sao as coordenadas latitude e
	 * longitude do ponto onde se encontra o boresight do sensor
	 */
	private double latitudeCenter;
	private double longitudeCenter;

	private CalculaCoordenadasCartesianas lateralCoordenates;
	private List<CalculaCoordenadasCartesianas> coordenateList;


	private List<Double> latitudeLimitRight;
	private List<Double> longitudeLimitRight;
	private List<Double> latitudeLimitLeft;
	private List<Double> longitudeLimitLeft;
	private List<Double> latitudeNextPathAhead;
	private List<Double> longitudeNextPathAhead;
	private List<Double> latitudeSensorCenter;
	private List<Double> longitudeSensorCenter;
	
	private List<Double> latitudeFirstLastRightLeft;
	private List<Double> longitudeFirstLastRightLeft;

	Formatter text = null;
	Formatter polygonCoord = null;
	
	private String precisao = "%.4f";

	/**
	 * 
	 * @param subSatellitePoints quantidade de pontos ao longo do trajeto do sensor/satelite
	 * @param sensorHeading inclinacao do sensor em relacao ao eixo da Terra
	 * @param latitude latitude inicial conhecida do sensor
	 * @param longitude longitude inicial conhecida do sensor
	 * @param boresightDistance distancia em metros do ponto mirado pelo sensor em relacao a um ponto em nadir
	 * @param nextPointAheadDistance distancia em metros do proximo ponto ao longo do trajeto do sensor/satelite
	 * @param apertureAngle angulo de abertura do sensor
	 * @param altitudeInMeters altitude em metros
	 * @param boresightAngle angulo boresight e direcionamento do sensor
	 * @param lateralDistanceToRight distancia limite em metros a direita da cobertura do sensor em relacao a um ponto em nadir
	 * @param lateralDistanceToLeft distancia limite em metros a esquerda da cobertura do sensor em relacao a um ponto em nadir
	 */
	public SatelliteTrack(double subSatellitePoints, double sensorHeading,
			double latitude, double longitude, double boresightDistance,
			double nextPointAheadDistance, double apertureAngle,
			double altitudeInMeters, double boresightAngle,
			double lateralDistanceToRight, double lateralDistanceToLeft) {

		this.subSatellitePoints = subSatellitePoints;
		this.sensorHeading = sensorHeading;
		this.latitude = latitude;
		this.longitude = longitude;
		this.boresightDistance = boresightDistance;
		this.nextPointAheadDistance = nextPointAheadDistance;
		this.apertureAngle = apertureAngle;
		this.altitudeInMeters = altitudeInMeters;
		this.boresightAngle = boresightAngle;
		this.lateralDistanceToRight = lateralDistanceToRight;
		this.lateralDistanceToLeft = lateralDistanceToLeft;

		this.latitudeLimitRight = new ArrayList<Double>();
		this.longitudeLimitRight = new ArrayList<Double>();
		this.latitudeLimitLeft = new ArrayList<Double>();
		this.longitudeLimitLeft = new ArrayList<Double>();
		this.latitudeNextPathAhead = new ArrayList<Double>();
		this.longitudeNextPathAhead = new ArrayList<Double>();
		this.latitudeSensorCenter = new ArrayList<Double>();
		this.longitudeSensorCenter = new ArrayList<Double>();

		this.latitudeNextPathAhead.add(this.latitude);
		this.longitudeNextPathAhead.add(this.longitude);
		
		this.latitudeFirstLastRightLeft = new ArrayList<Double>();
		this.longitudeFirstLastRightLeft = new ArrayList<Double>();

		/**
		 * as coordenada aqui sao distancias nos quadrantes x e y para
		 * boresightDistance e lateralDistanceToRight e lateralDistanceToLeft
		 */
		lateralCoordenates = new CalculaCoordenadasCartesianas(sensorHeading,
				boresightDistance, nextPointAheadDistance,
				lateralDistanceToRight, lateralDistanceToLeft);

		coordenateList = new ArrayList<CalculaCoordenadasCartesianas>();

		coordenateList.add(lateralCoordenates);
	}

	/**
	 * metodo que constroi o trajeto do satelite e grava os dados gerados no
	 * arquivo
	 */
	public void getTrack() {
		
		extractToTextFile();


		for (int x = 0; x < subSatellitePoints; x++) {

			CalculaHipotenusaP p = new CalculaHipotenusaP(lateralCoordenates);
			CalculaAnguloC c = new CalculaAnguloC(p);

			/**
			 * agora e necessario descobrir as coordenadas dos ponto centro
			 * lateral e passa-lo como sendo o a referencia para o calculo dos
			 * pontos laterais. Estas coordenadas devem ser os parametros
			 * 'latitude' e 'longitude' dos objetos CalculaLambdaLateral e
			 * CalculaPhiLateral
			 */

			// /////LAMBDA E PHI CENTRAL QUE REPRESENTA O CENTRO DA VISAO DO SENSOR////////
			CalculaPhiCentral phiCentral = new CalculaPhiCentral(c,
					lateralCoordenates, p, latitude);
			latitudeCenter = phiCentral.getPhiCentral();

			CalculaLambdaCentral lambdaCentral = new CalculaLambdaCentral(c, lateralCoordenates, p, latitude, longitude);
			longitudeCenter = lambdaCentral.getLambdaCentral();
			// /////LAMBDA E PHI CENTRAL QUE REPRESENTA O CENTRO DA VISAO DO SENSOR////////

			CalculaPhiLateral phiLateral = new CalculaPhiLateral(c, lateralCoordenates, p, latitudeCenter, latitude);
			CalculaLambdaLateral lambdaLateral = new CalculaLambdaLateral(c, lateralCoordenates, p, latitudeCenter, longitudeCenter, longitude);
			
			addLatLonToLists(phiCentral, lambdaCentral, phiLateral, lambdaLateral);
			
			//adiciona a primeira e a ultima coordenada no array
			if(x == 0 || x == (subSatellitePoints -1)){
				addFirstAndLastCoordenatesToList(phiLateral, lambdaLateral);
			}
					
			text.format(
					"%8d\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\n",
					x, 
					String.format(precisao, latitudeNextPathAhead.get(x)).replace(",", "."),
					String.format(precisao, longitudeNextPathAhead.get(x)).replace(",", "."), 
					String.format(precisao, latitudeLimitRight.get(x)).replace(",", "."),
					String.format(precisao, longitudeLimitRight.get(x)).replace(",", "."), 
					String.format(precisao, latitudeLimitLeft.get(x)).replace(",", "."),
					String.format(precisao, longitudeLimitLeft.get(x)).replace(",", "."), 
					String.format(precisao, latitudeSensorCenter.get(x)).replace(",", "."),
					String.format(precisao, longitudeSensorCenter.get(x)).replace(",", "."));
			
			
			nextPosition();

		}
		
		//TODO implementar aqui a chamada a um mÈtodo que calcula os pontos entre as laterais da cobertura
		//TODO ser· necess·rio obter os pontos limites da cobertura (os mesmos usados para fazer um poligono no stk
		//TODO ao obter estes pontos deve-se definir o espaÁamento de atÈ 2000 metros e a direÁ„o angular do pontos no inicio e no fim do trajeto
		
		extractPolygonCoordToText();
		
		text.close();
		polygonCoord.close();

		showTable();

	}
	
	/**
	 * extrai os dados gerados para um arquivo de texto
	 */
	private void extractToTextFile() {
		if(text == null){
			try {
				text = new Formatter("C:\\SatelliteSwathWidth\\latlon.txt");
			} catch (FileNotFoundException e1) {
				JOptionPane.showMessageDialog(null, "Error when creating text file", "Error", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
			
		}

		text.format("Swath width:\t%.4f meters\n" 
				+ "Altitude:\t%.0f meters\n"
				+ "Sub satellite points:\t%.0f points\n"
				+ "Boresight:\t%.4f degrees\n" 
				+ "Aperture:\t%.4f degrees\n"
				+ "Heading:\t%.2f degrees\n" 
				+ "Initial latitude:\t%.4f\n"
				+ "Initial longitude:\t%.4f\n"
				+ "Path distance:\t%.0f meters\n", 
				boresightDistance,
				altitudeInMeters, 
				subSatellitePoints, 
				boresightAngle,
				apertureAngle, 
				sensorHeading, 
				latitude, 
				longitude,
				nextPointAheadDistance);
		text.format("__________________________________________________________________________________________________________________________________________\n");
		text.format("%8s\t%8s\t%8s\t%8s\t%8s\t%8s\t%8s\t%8s\t%8s\n",
				"SubPoint", "Gtrack lat", "Gtrack lon", "latRight", "lonRight",
				"latLeft", "lonLeft", "latCentral", "lonCentral");
	}
	
	/**
	 * cria o arquivo .COB e formata o texto da maneira exigida pelo Aerograf PDA
	 */
	private void extractPolygonCoordToText(){
		String fileName = (String) JOptionPane.showInputDialog(null, "Input .cob file name", ".cob file name", 0, null, null, null);
		if(polygonCoord == null){
			try {
				polygonCoord = new Formatter("C:\\SatelliteSwathWidth\\"+fileName+".COB");
			} catch (FileNotFoundException e1) {
				JOptionPane.showMessageDialog(null, "Erro ao criar arquivo  polygonCoord.txt", "Erro", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
			
		}
		
		polygonCoord.format("%s\n%s\n%s %.0f\n", "1", "1", "5000", ((subSatellitePoints * 2) + 1));
		
		ArrayList<Double> arrayLat = new ArrayList<Double>();
		ArrayList<Double> arrayLon = new ArrayList<Double>();

	/**
	 * insere as coordenadas no array em sentido hor√°rio
	 */
		
		for (int x = 0; x < subSatellitePoints; x++) {
			//continua com as coordenadas a esquerda, da ultima ate a primeira
			arrayLat.add(latitudeLimitLeft.get(x));
			arrayLon.add(longitudeLimitLeft.get(x));
		}

		for (int x = (int) (subSatellitePoints - 1); x >= 0; x--) {
			//inicia com as coordenadas a direita, da primeira ate a ultima
			arrayLat.add(latitudeLimitRight.get(x));
			arrayLon.add(longitudeLimitRight.get(x));
		}

		for(int x = 0; x <= arrayLat.size()-1; x++){
			
			polygonCoord.format("%s\t%s\t%s\n", (String.format("%.6f", arrayLat.get(x)).replace(",",".")), 
					(String.format("%.6f", arrayLon.get(x)).replace(",", ".")), 
					(String.format("%.6f", 0.000000).replace(",","."))
					);
			
		}
		polygonCoord.format("%s\t%s\t%s\n", (String.format("%.6f", arrayLat.get(0)).replace(",",".")), 
					(String.format("%.6f", arrayLon.get(0)).replace(",", ".")), 
					(String.format("%.6f", 0.000000).replace(",","."))
					);
		
		polygonCoord.format("%s %s " , "0", "0");
	}

	/**
	 * armazena a primeira e a ultima coordenada calculada
	 * @param phiLateral
	 * @param lambdaLateral
	 */
	private void addFirstAndLastCoordenatesToList(CalculaPhiLateral phiLateral,
			CalculaLambdaLateral lambdaLateral) {
		
		latitudeFirstLastRightLeft.add(phiLateral.getPhiLateralDireito());
		latitudeFirstLastRightLeft.add(phiLateral.getPhiLateralEsquerdo());
		longitudeFirstLastRightLeft.add(lambdaLateral.getLambdaLateralDireito());
		longitudeFirstLastRightLeft.add(lambdaLateral.getLambdaLateralEsquerdo());
	}

	/**
	 * @param phiCentral
	 * @param lambdaCentral
	 * @param phiLateral
	 * @param lambdaLateral
	 */
	private void addLatLonToLists(CalculaPhiCentral phiCentral,
			CalculaLambdaCentral lambdaCentral, CalculaPhiLateral phiLateral,
			CalculaLambdaLateral lambdaLateral) {
		latitudeLimitRight.add(phiLateral.getPhiLateralDireito());
		longitudeLimitRight.add(lambdaLateral.getLambdaLateralDireito());

		latitudeLimitLeft.add(phiLateral.getPhiLateralEsquerdo());
		longitudeLimitLeft.add(lambdaLateral.getLambdaLateralEsquerdo());

		latitudeSensorCenter.add(phiCentral.getPhiCentral());
		longitudeSensorCenter.add(lambdaCentral.getLambdaCentral());
	}

	/**
	 * implementar um JFrame que mostra uma tabela com os dados que sao
	 * inseridos no arquivo
	 */
	private void showTable() {
		SwathWidthTable swathTableData = new SwathWidthTable(
				latitudeNextPathAhead, longitudeNextPathAhead,
				latitudeLimitRight, longitudeLimitRight, latitudeLimitLeft,
				longitudeLimitLeft, subSatellitePoints, latitudeSensorCenter,
				longitudeSensorCenter);
		swathTableData.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		swathTableData.setVisible(true);
		swathTableData.setSize(1200, 600);
		swathTableData.setResizable(true);

	}

	/**
	 * metodo que atualiza a posicao do satelite em seu trajeto. apos atualizar
	 * a posicao do satelite o metodo getTrack calcula novamente as posicoes
	 * (lat, lon) laterais ao longo do trajeto
	 */
	private void nextPosition() {

		ProximoPhiLambda proximaCoordenada = new ProximoPhiLambda(
				sensorHeading, nextPointAheadDistance, lateralDistanceToRight, lateralDistanceToLeft);
		CalculaHipotenusaP p = new CalculaHipotenusaP(proximaCoordenada);
		// System.out.println(p.getLineAhead());
		CalculaAnguloC c = new CalculaAnguloC(p.getLineAhead());
		// System.out.println(c.getCAhead());
		CalculaPhiAhead phiAhead = new CalculaPhiAhead(c, proximaCoordenada, p, latitude);
		CalculaLambdaAhead lambdaAhead = new CalculaLambdaAhead(c, proximaCoordenada, p, latitude, longitude);

		latitude = phiAhead.getPhi();
		latitudeNextPathAhead.add(latitude);

		longitude = lambdaAhead.getLambda();
		longitudeNextPathAhead.add(longitude);

	}

	/**
	 * ordem da latitude firstRight, firstLeft, lastRight, lastLeft
	 * @return
	 */
	public List<Double> getLatitudeFirstLastRightLeft() {
		if(!latitudeFirstLastRightLeft.isEmpty()){
			return latitudeFirstLastRightLeft;
		} else {
			return null;
		}
		
	}

	/**
	 * ordem da longitude firstRight, firstLeft, lastRight, lastLeft
	 * @return
	 */
	public List<Double> getLongitudeFirstLastRightLeft() {
		if(!longitudeFirstLastRightLeft.isEmpty()){
			return longitudeFirstLastRightLeft;
		} else {
			return null;
		}
		
	}
}
