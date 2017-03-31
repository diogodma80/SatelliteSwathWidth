package br.org.model.lambda;


import br.org.model.swath.CalculaAnguloC;
import br.org.model.swath.CalculaHipotenusaP;
import br.org.model.swath.ProximoPhiLambda;

public class CalculaLambdaAhead {

	private CalculaAnguloC c;
	private ProximoPhiLambda proximmaCoordenada;
	private CalculaHipotenusaP p;
	double latitude;
	double longitude;
	private double lambda;

	public CalculaLambdaAhead(CalculaAnguloC c,
			ProximoPhiLambda proximaCoordenada, CalculaHipotenusaP p,
			double latitude, double longitude) {
		this.c = c;
		this.proximmaCoordenada = proximaCoordenada;
		this.p = p;
		this.latitude = latitude;
		this.longitude = longitude;

		// TODO constructors should not call setter methods
		setLambda(c, proximaCoordenada, p, latitude, longitude);
	}

	private void setLambda(CalculaAnguloC c,
			ProximoPhiLambda proximaCoordenada, CalculaHipotenusaP p,
			double latitude, double longitude) {
		double senC = Math.sin(Math.toRadians(c.getCAhead()));
		double cosPhi = Math.cos(Math.toRadians(latitude));
		double cosC = Math.cos(Math.toRadians(c.getCAhead()));
		double senPhi = Math.sin(Math.toRadians(latitude));

		lambda = longitude + Math.toDegrees(Math.atan(((proximmaCoordenada.getCoordX() * senC) / ((p.getLineAhead() * cosPhi * cosC) - (proximmaCoordenada.getCoordY() * senPhi * senC)))));
	}

	public double getLambda() {
		return lambda;
	}

}
