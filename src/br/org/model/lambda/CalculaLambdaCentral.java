package br.org.model.lambda;

import br.org.model.swath.CalculaAnguloC;
import br.org.model.swath.CalculaCoordenadasCartesianas;
import br.org.model.swath.CalculaHipotenusaP;

public class CalculaLambdaCentral {

	private CalculaAnguloC c;
	private CalculaCoordenadasCartesianas coordenada;
	private CalculaHipotenusaP p;
	private double latitude;
	private double longitude;

	private double lambdaCentral;

	public CalculaLambdaCentral(CalculaAnguloC c,
			CalculaCoordenadasCartesianas coordenada, CalculaHipotenusaP p,
			double latitude, double longitude) {

		this.c = c;
		this.coordenada = coordenada;
		this.p = p;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public double getLambdaCentral() {

		double senC = Math.sin(Math.toRadians(this.c.getCCenter()));
		double cosPhi = Math.cos(Math.toRadians(this.latitude));
		double cosC = Math.cos(Math.toRadians(this.c.getCCenter()));
		double senPhi = Math.sin(Math.toRadians(this.latitude));

		lambdaCentral = this.longitude + Math.toDegrees(Math.atan(((this.coordenada.getBoresightCenterX() * senC) / ((this.p.getHipotenusaCenter() * cosPhi * cosC) - (this.coordenada.getBoresightCenterY() * senPhi * senC)))));
		return lambdaCentral;
	}

	/**
	 * Embora fa�a mais sentido utilizar getCRightFromBoresight e
	 * getHipotenusaRightFromBoresightPoint neste m�todo os testes com as
	 * coordenadasd geradas para ambos os casos mostraram diferen�as m�nimas na
	 * gera��o das coordenadas lat-lon mesmo quando os valores retornados por
	 * estes m�todos eram razoavelmente grandes
	 */
	// public double getLambdaCentral() {
	//
	// double senC = Math.sin(Math.toRadians(this.c.getCRightFromBoresight()));
	// double cosPhi = Math.cos(Math.toRadians(this.latitude));
	// double cosC = Math.cos(Math.toRadians(this.c.getCRightFromBoresight()));
	// double senPhi = Math.sin(Math.toRadians(this.latitude));
	//
	// lambdaCentral = this.longitude +
	// Math.toDegrees(Math.atan(((this.coordenada.getBoresightCenterX() * senC)
	// / ((this.p.getHipotenusaRightFromBoresightPoint() * cosPhi * cosC) -
	// (this.coordenada.getBoresightCenterY() * senPhi * senC)))));
	// return lambdaCentral;
	// }

}
