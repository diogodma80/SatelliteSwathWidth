package br.org.model.phi;

import br.org.model.swath.CalculaAnguloC;
import br.org.model.swath.CalculaCoordenadasCartesianas;
import br.org.model.swath.CalculaHipotenusaP;

public class CalculaPhiLateral {

	private CalculaAnguloC c;
	private CalculaCoordenadasCartesianas coordenada;
	private CalculaHipotenusaP p;
	private double phi;
	private double latitude;
	private double phiLateralDireito;
	private double phiLateralEsquerdo;
	
	double cosC;
	double senPhi;
	double senC;
	double cosPhi;


	public CalculaPhiLateral() {
		super();
	}
	
	public CalculaPhiLateral(CalculaAnguloC c,
			CalculaCoordenadasCartesianas coordenada, CalculaHipotenusaP p,
			double phi, double latitude) {
		super();
		this.setC(c);
		this.setCoordenada(coordenada);
		this.setP(p);
		this.setPhi(phi);
		this.latitude = latitude;
	}

	public void setC(CalculaAnguloC c) {
		this.c = c;
	}

	public CalculaCoordenadasCartesianas getCoordenada() {
		return coordenada;
	}

	public void setCoordenada(CalculaCoordenadasCartesianas coordenada) {
		this.coordenada = coordenada;
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
	
	/**
	 * sets the util variables used on getPhiLateralDireito() and getPhiLateralEsquerdo() methods
	 * @param c
	 * @param phi
	 */
	private void setUtilVariables(double c, double phi){
		
		this.cosC = Math.cos(Math.toRadians(c));
		this.senPhi = Math.sin(Math.toRadians(phi));
		this.senC = Math.sin(Math.toRadians(c));
		this.cosPhi = Math.cos(Math.toRadians(phi));
	}

	public double getPhiLateralDireito() {
		
		//calls setUtilVariables passing it the "cRight" and phi variables
		setUtilVariables(this.c.getCRightFromBoresight(), this.getPhi());
		
		//phiLateralDireito = Math.toDegrees(Math.asin((this.cosC * this.senPhi + (this.coordenada.getYRightFromCenter() * this.senC * (this.cosPhi / this.p.getHipotenusaRight())))));
		phiLateralDireito = Math.toDegrees(Math.asin((this.cosC * this.senPhi + (this.coordenada.getYRightFromCenter() * this.senC * (this.cosPhi / this.p.getHipotenusaRightFromBoresightPoint())))));
		return phiLateralDireito;
	}

	public double getPhiLateralEsquerdo() {
		
		//calls setUtilVariables passing it the "cLeft" and phi variables
		setUtilVariables(this.c.getCLeftFromBoresight(), this.getPhi());
		
		//phiLateralEsquerdo = Math.toDegrees(Math.asin((this.cosC * this.senPhi + (this.coordenada.getYLeftFromCenter() * this.senC * (this.cosPhi / this.p.getHipotenusaLeft())))));
		phiLateralEsquerdo = Math.toDegrees(Math.asin((this.cosC * this.senPhi + (this.coordenada.getYLeftFromCenter() * this.senC * (this.cosPhi / this.p.getHipotenusaLeftFromBoresightPoint())))));
		if(Double.isNaN(phiLateralEsquerdo)){
			phiLateralEsquerdo = this.latitude;
		}
		return phiLateralEsquerdo;
	}
}
