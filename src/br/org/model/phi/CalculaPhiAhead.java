package br.org.model.phi;

import br.org.model.swath.CalculaAnguloC;
import br.org.model.swath.CalculaHipotenusaP;
import br.org.model.swath.ProximoPhiLambda;

public class CalculaPhiAhead {

	private CalculaAnguloC c;
	private ProximoPhiLambda proximaCoordenada;
	private CalculaHipotenusaP p;
	private double latitude;
	private double phi;

	public CalculaPhiAhead(CalculaAnguloC c,
			ProximoPhiLambda proximaCoordenada, CalculaHipotenusaP p,
			double latitude) {
		this.c = c;
		this.proximaCoordenada = proximaCoordenada;
		this.p = p;
		this.latitude = latitude;
		setPhi(c, proximaCoordenada, p, latitude);
	}

	private void setPhi(CalculaAnguloC c, ProximoPhiLambda proximaCoordenada,
			CalculaHipotenusaP p, double latitude) {

		double cosC = Math.cos(Math.toRadians(c.getCAhead()));
		double senPhi = Math.sin(Math.toRadians(latitude));
		double senC = Math.sin(Math.toRadians(c.getCAhead()));
		double cosPhi = Math.cos(Math.toRadians(latitude));

		phi = Math.toDegrees(Math.asin((cosC * senPhi + (proximaCoordenada.getCoordY() * senC * (cosPhi / p.getLineAhead()))))); //estava x e funcionava
	}

	public double getPhi() {
		return phi;
	}
}
