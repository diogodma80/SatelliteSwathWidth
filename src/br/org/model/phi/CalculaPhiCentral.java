package br.org.model.phi;

import br.org.model.swath.CalculaAnguloC;
import br.org.model.swath.CalculaCoordenadasCartesianas;
import br.org.model.swath.CalculaHipotenusaP;

public class CalculaPhiCentral {

	private CalculaAnguloC c;
	private CalculaCoordenadasCartesianas coordenada;
	private CalculaHipotenusaP p;
	private double latitude;

	private double phiCentral;

	public CalculaPhiCentral(CalculaAnguloC c,
			CalculaCoordenadasCartesianas coordenada, CalculaHipotenusaP p,
			double latitude) {

		this.c = c;
		this.coordenada = coordenada;
		this.p = p;
		this.latitude = latitude;

	}

	public double getPhiCentral() {

		double cosC = Math.cos(Math.toRadians(this.c.getCCenter()));
		double senPhi = Math.sin(Math.toRadians(this.latitude));
		double senC = Math.sin(Math.toRadians(this.c.getCCenter()));
		double cosPhi = Math.cos(Math.toRadians(this.latitude));

		phiCentral = Math.toDegrees(Math.asin((cosC * senPhi + (this.coordenada.getBoresightCenterY() * senC * (cosPhi / this.p.getHipotenusaCenter())))));
		return phiCentral;
	}

	/**
	 * Embora fa�a mais sentido utilizar getCRightFromBoresight e
	 * getHipotenusaRightFromBoresightPoint neste m�todo os testes com as
	 * coordenadasd geradas para ambos os casos mostraram diferen�as m�nimas na
	 * gera��o das coordenadas lat-lon mesmo quando os valores retornados por
	 * estes m�todos eram razoavelmente grandes
	 */
	// public double getPhiCentral() {
	//
	// double cosC = Math.cos(Math.toRadians(this.c.getCRightFromBoresight()));
	// double senPhi = Math.sin(Math.toRadians(this.latitude));
	// double senC = Math.sin(Math.toRadians(this.c.getCRightFromBoresight()));
	// double cosPhi = Math.cos(Math.toRadians(this.latitude));
	//
	// phiCentral = Math.toDegrees(Math.asin((cosC * senPhi + (this.coordenada
	// .getBoresightCenterY() * senC * (cosPhi / this.p
	// .getHipotenusaRightFromBoresightPoint())))));
	// return phiCentral;
	// }

}
