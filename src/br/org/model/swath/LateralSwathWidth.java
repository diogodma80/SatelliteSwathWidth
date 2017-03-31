package br.org.model.swath;

public class LateralSwathWidth {

	// valores de entrada
	private double boresightAngle;
	private double apertureAngle;
	private double altitudeInMeters;

	// valores para cálculo
	private double angleToRight;
	private double angleToLeft;

	// valores de resposta
	private double boresightDistance;
	private double lateralDistanceToRight;
	private double lateralDistanceToLeft;

	/**
	 * classe que calcula a distância dos pontos laterais ao trajeto do satélite
	 * 
	 * @param boresightAngle
	 * ângulo de direcionamento da visão do sensor
	 * 
	 * @param apertureAngle
	 * ângulo de abertura do sensor
	 * 
	 * @param altitudeInMeters
	 * altitude da plataforma em metros
	 */

	public LateralSwathWidth(double boresightAngle, double apertureAngle,
			double altitudeInMeters) {
		this.boresightAngle = boresightAngle;
		this.apertureAngle = apertureAngle;
		this.altitudeInMeters = altitudeInMeters;
		this.setBoresightDistance();
		this.setRigthAndLeftLateralDistances();
	}

	/**
	 * cálculo da distância do boresight em relação ao centro do trajeto do
	 * satélite
	 */
	private void setBoresightDistance() {
		boresightDistance = new CalculaSwathWidth(boresightAngle, altitudeInMeters).getSwathPath();
	}

	/**
	 * cálculo da distâncias das laterais da cobertura em relação ao centro do
	 * trajeto do satélite
	 */
	private void setRigthAndLeftLateralDistances() {

		this.angleToRight = this.boresightAngle + (this.apertureAngle / 2);
		this.angleToLeft = this.boresightAngle - (this.apertureAngle / 2);

		lateralDistanceToRight = new CalculaSwathWidth(angleToRight, altitudeInMeters).getSwathPath();
		lateralDistanceToLeft = new CalculaSwathWidth(angleToLeft, altitudeInMeters).getSwathPath();
	}

	/**
	 * @return lateralDistanceToRight
	 * distância em metros do ponto lateral à direita do boresight, com origem no ponto
	 * nadir
	 */
	public double getLateralDistanceToRight() {
		return lateralDistanceToRight;
	}

	/**
	 * @return lateralDistanceToLeft
	 * distância em metros do ponto lateral à esquerda do boresight, com origem no ponto
	 * nadir
	 */
	public double getLateralDistanceToLeft() {
		return lateralDistanceToLeft;
	}

	/**
	 * @return boresightDistance
	 * distância em metros do ponto lateral boresight em relação ao nadir
	 */
	public double getBoresightDistance() {
		return boresightDistance;
	}
}
