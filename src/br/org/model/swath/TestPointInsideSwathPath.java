package br.org.model.swath;

import javax.swing.JOptionPane;

import br.org.controller.SatelliteTrack;

public class TestPointInsideSwathPath {

	private double latitudeValue;
	private double longitudeValue;
	private SatelliteTrack track;
	
	double latPointA;
	double lonPointA;
	
	double latPointB;
	double lonPointB;
	
	double latPointC;
	double lonPointC;
	
	double latPointD;
	double lonPointD;
	
	
	public TestPointInsideSwathPath(double latitudeValue, double longitudeValue, SatelliteTrack track) {
		super();
		
		this.latitudeValue = latitudeValue ;
		this.longitudeValue = longitudeValue;
		this.track = track;

		initializePolygonPoints();
		if(testPointAgainstPolygonCoordenates()){
			JOptionPane.showMessageDialog(null, "Coordenada dentro do poligono");
		} else {
			JOptionPane.showMessageDialog(null, "Nenhum algoritmo implementado ainda para encontrar a latitude e longitude especificadas", "Atenção", JOptionPane.INFORMATION_MESSAGE);

			//JOptionPane.showMessageDialog(null, "Coordenada fora do poligono");
		}
		
	}
	
	private boolean testPointAgainstPolygonCoordenates() {
		// TODO implementar algoritmo que encontra a coordenada latitude e longitude procurada
		boolean inside = false;
		
		System.out.println("latitude: " +latitudeValue);
		System.out.println("longitude: " +longitudeValue);
		
		return inside;
		
	}

	private void initializePolygonPoints() {
		

		latPointA = track.getLatitudeFirstLastRightLeft().get(0);
		lonPointA = track.getLongitudeFirstLastRightLeft().get(0);
		System.out.println("lat a: " +latPointA);
		System.out.println("lon a: " +lonPointA);

		latPointB = track.getLatitudeFirstLastRightLeft().get(1);
		lonPointB = track.getLongitudeFirstLastRightLeft().get(1);
		System.out.println("lat b: " +latPointB);
		System.out.println("lon b: " +lonPointB);

		latPointC = track.getLatitudeFirstLastRightLeft().get(3);
		lonPointC = track.getLongitudeFirstLastRightLeft().get(3);
		System.out.println("lat c: " +latPointC);
		System.out.println("lon c: " +lonPointC);

		latPointD = track.getLatitudeFirstLastRightLeft().get(2);
		lonPointD = track.getLongitudeFirstLastRightLeft().get(2);
		System.out.println("lat d: " +latPointD);
		System.out.println("lon d: " +lonPointD);
		
		
	}
	
	
}
