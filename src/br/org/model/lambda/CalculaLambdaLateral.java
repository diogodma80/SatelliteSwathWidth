package br.org.model.lambda;

import br.org.model.swath.CalculaAnguloC;
import br.org.model.swath.CalculaCoordenadasCartesianas;
import br.org.model.swath.CalculaHipotenusaP;




public class CalculaLambdaLateral {
	private CalculaAnguloC c;
	private CalculaCoordenadasCartesianas coordenada;
	private CalculaHipotenusaP p;
	private double phi;
	private double lambda;
	private double lambdaLateralDireito;
	private double lambdaLateralEsquerdo;
	private double longitude;
	
	double senC;
	double cosPhi;
	double cosC;
	double senPhi;

	public CalculaLambdaLateral() {
		super();
	}

	public CalculaLambdaLateral(CalculaAnguloC c,
			CalculaCoordenadasCartesianas coordenada, CalculaHipotenusaP p,
			double phi, double lambda, double longitude) {
		super();
		this.setC(c);
		this.setCoordenada(coordenada);
		this.setP(p);
		this.setPhi(phi);
		this.setLambda(lambda);
		this.longitude = longitude;
	}

	public void setC(CalculaAnguloC c) {
		this.c = c;
	}

	public void setCoordenada(CalculaCoordenadasCartesianas coordenada){
		this.coordenada = coordenada;
	}
	
	public CalculaCoordenadasCartesianas getCoordenada() {
		return coordenada;
	}

	public CalculaHipotenusaP getP() {
		return p;
	}

	public void setP(CalculaHipotenusaP p) {
		this.p = p;
	}

	public double getPhi() {
		return phi;
	}

	public void setPhi(double phi) {
		this.phi = phi;
	}

	public double getLambda() {
		return lambda;
	}

	public void setLambda(double lambda) {
		this.lambda = lambda;
	}
	
	/**
	 * sets the util variables used on getPhiLateralDireito() and getPhiLateralEsquerdo() methods
	 * @param c
	 * @param phi
	 */
	private void setUtilVariables(double c, double phi){
		
		this.senC = Math.sin(Math.toRadians(c));
		this.cosPhi = Math.cos(Math.toRadians(phi));
		this.cosC = Math.cos(Math.toRadians(c));
		this.senPhi = Math.sin(Math.toRadians(phi));
	}

	public double getLambdaLateralDireito() {
		
		//calls setUtilVariables passing it the "cRight" and phi variables
		this.setUtilVariables(this.c.getCRightFromBoresight(), this.getPhi());
		
		//lambdaLateralDireito = this.getLambda() + Math.toDegrees(Math.atan(((this.coordenada.getXRightFromCenter() * this.senC) / ((this.p.getHipotenusaRight() * this.cosPhi * this.cosC) - (this.coordenada.getYRightFromCenter() * this.senPhi * this.senC)))));
		lambdaLateralDireito = this.getLambda() + Math.toDegrees(Math.atan(((this.coordenada.getXRightFromCenter() * this.senC) / ((this.p.getHipotenusaRightFromBoresightPoint() * this.cosPhi * this.cosC) - (this.coordenada.getYRightFromCenter() * this.senPhi * this.senC)))));
		return lambdaLateralDireito;
	}
	
	public double getLambdaLateralEsquerdo() {

		//calls setUtilVariables passing it the "cRight" and phi variables
		this.setUtilVariables(this.c.getCLeftFromBoresight(), this.getPhi());
		
		//lambdaLateralEsquerdo = this.getLambda() + Math.toDegrees(Math.atan(((this.coordenada.getXLeftFromCenter() * this.senC) / ((this.p.getHipotenusaLeft() * this.cosPhi * this.cosC) - (this.coordenada.getYLeftFromCenter() * this.senPhi * this.senC)))));
		lambdaLateralEsquerdo = this.getLambda() + Math.toDegrees(Math.atan(((this.coordenada.getXLeftFromCenter() * this.senC) / ((this.p.getHipotenusaLeftFromBoresightPoint() * this.cosPhi * this.cosC) - (this.coordenada.getYLeftFromCenter() * this.senPhi * this.senC)))));
		
		//teste para o caso de n�o haver distancia e o resultado � que tanto o trajeto do satelite quanto a lateral2 s�o  coincidentes
		if(Double.isNaN(lambdaLateralEsquerdo)){
			lambdaLateralEsquerdo = this.longitude;
		}
		return lambdaLateralEsquerdo;
	}
}
