package br.org.model.swath;

public class LateralSwathWidth {

	// valores de entrada
	private double boresightAngle;
	private double apertureAngle;
	private double altitudeInMeters;

	// valores para c�lculo
	private double angleToRight;
	private double angleToLeft;

	// valores de resposta
	private double boresightDistance;
	private double lateralDistanceToRight;
	private double lateralDistanceToLeft;

	/**
	 * classe que calcula a dist�ncia dos pontos laterais ao trajeto do sat�lite
	 * 
	 * @param boresightAngle
	 * �ngulo de direcionamento da vis�o do sensor
	 * 
	 * @param apertureAngle
	 * �ngulo de abertura do sensor
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
	 * c�lculo da dist�ncia do boresight em rela��o ao centro do trajeto do
	 * sat�lite
	 */
	private void setBoresightDistance() {
		boresightDistance = new CalculaSwathWidth(boresightAngle, altitudeInMeters).getSwathPath();
	}

	/**
	 * c�lculo da dist�ncias das laterais da cobertura em rela��o ao centro do
	 * trajeto do sat�lite
	 */
	private void setRigthAndLeftLateralDistances() {

		this.angleToRight = this.boresightAngle + (this.apertureAngle / 2);
		this.angleToLeft = this.boresightAngle - (this.apertureAngle / 2);

		lateralDistanceToRight = new CalculaSwathWidth(angleToRight, altitudeInMeters).getSwathPath();
		lateralDistanceToLeft = new CalculaSwathWidth(angleToLeft, altitudeInMeters).getSwathPath();
	}

	/**
	 * @return lateralDistanceToRight
	 * dist�ncia em metros do ponto lateral � direita do boresight, com origem no ponto
	 * nadir
	 */
	public double getLateralDistanceToRight() {
		return lateralDistanceToRight;
	}

	/**
	 * @return lateralDistanceToLeft
	 * dist�ncia em metros do ponto lateral � esquerda do boresight, com origem no ponto
	 * nadir
	 */
	public double getLateralDistanceToLeft() {
		return lateralDistanceToLeft;
	}

	/**
	 * @return boresightDistance
	 * dist�ncia em metros do ponto lateral boresight em rela��o ao nadir
	 */
	public double getBoresightDistance() {
		return boresightDistance;
	}
}
