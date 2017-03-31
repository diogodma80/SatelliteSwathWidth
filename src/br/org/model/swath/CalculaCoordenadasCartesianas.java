package br.org.model.swath;

public class CalculaCoordenadasCartesianas {

	/**
	 * inclina��o do sensor em rela��o ao eixo da Terra
	 */
	private double sensorHeading;

	/**
	 * dist�ncia em metros do ponto mirado pelo sensor em rela��o a um ponto em
	 * nadir
	 */
	private double boresightDistance;

	/**
	 * dist�ncia em metros do pr�ximo ponto ao longo do trajeto do
	 * sensor/sat�lite
	 */
	private double nextPointAheadDistance;

	/**
	 * dist�ncia limite em metros � direita da cobertura do sensor em rela��o a
	 * um ponto em nadir
	 */
	private double lateralDistanceToRight;

	/**
	 * dist�ncia limite em metros � esquerda da cobertura do sensor em rela��o a
	 * um ponto em nadir
	 */
	private double lateralDistanceToLeft;

	/**
	 * dist�ncia do ponto lateral (x)right referente ao ponto (x, y)boresight
	 */
	private double xRightFromCenter;

	/**
	 * dist�ncia do ponto lateral (y)right referente ao ponto (x, y)boresight
	 */
	private double yRightFromCenter;

	/**
	 * dist�ncia do ponto lateral (x)left referente ao ponto (x, y)boresight
	 */
	private double xLeftFromCenter;

	/**
	 * dist�ncia do ponto lateral (y)left referente ao ponto (x, y)boresight
	 */
	private double yLeftFromCenter;

	/**
	 * dist�ncia (x)right perpendicular ao ponto de visao do sat�lite
	 */
	private double xRight;

	/**
	 * dist�ncia (y)right perpendicular ao ponto de visao do sat�lite
	 */
	private double yRight;

	/**
	 * dist�ncia (x)left perpendicular ao ponto de visao do sat�lite
	 */
	private double xLeft;

	/**
	 * dist�ncia (y)left perpendicular ao ponto de visao do sat�lite
	 */
	private double yLeft;

	/**
	 * pr�xima coordenada (x)ahead ao longo do trajeto
	 */
	private double coordXProx;

	/**
	 * pr�xima coordenada (y)ahead ao longo do trajeto
	 */
	private double coordYProx;

	/**
	 * 
	 */
	private double boresightCenterX;

	/**
	 * 
	 */
	private double boresightCenterY;

	/**
	 * Todo sat�lite tem uma determinada inclina��o em sua �rbita e esta classe
	 * calcula as coordenadas cartesianas laterais � esta trajet�ria inclinada
	 * do sat�lite.
	 * 
	 * @param sensorHeading
	 *            �ngulo de inclina��o do sensor
	 * @param boresightDistance
	 *            dist�ncia em metros do ponto mirado pelo sensor em rela��o a
	 *            um ponto em nadir
	 * @param nextPointAheadDistance
	 *            dist�ncia em metros do pr�ximo ponto ao longo do trajeto do
	 *            sensor/sat�lite
	 * @param lateralDistanceToRight
	 *            dist�ncia limite em metros � direita da cobertura do sensor em
	 *            rela��o a um ponto em nadir
	 * @param lateralDistanceToLeft
	 *            dist�ncia limite em metros � esquerda da cobertura do sensor
	 *            em rela��o a um ponto em nadir
	 */
	public CalculaCoordenadasCartesianas(double sensorHeading,
			double boresightDistance, double nextPointAheadDistance,
			double lateralDistanceToRight, double lateralDistanceToLeft) {

		this.sensorHeading = sensorHeading;
		this.boresightDistance = boresightDistance;
		this.nextPointAheadDistance = nextPointAheadDistance;
		this.lateralDistanceToRight = lateralDistanceToRight;
		this.lateralDistanceToLeft = lateralDistanceToLeft;
		
		/**
		 * este m�todo chama todos os setters desta classe
		 */
		this.setAllXsAndYs();

	}

	/**
	 * setters
	 */
	private void setAllXsAndYs() {
		this.setBoresightCenterX();
		this.setBoresightCenterY();

		this.setxRight();
		this.setyRight();
		this.setxLeft();
		this.setyLeft();

		/**
		 * chama os setters para determinar os pontos (x, y)right e (x, y)left
		 * com base no ponto do boresight.
		 */
		this.setXRightFromCenter();
		this.setYRightFromCenter();
		this.setXLeftFromCenter();
		this.setYLeftFromCenter();

		this.setCoordX();
		this.setCoordY();
	}

	/**
	 * C�lculo das coordenada cartesiana x do boresight utilizando a dist�ncia
	 * (distance) a partir de um ponto em nadir at� o ponto do boresight
	 */
	private void setBoresightCenterX() {
		boresightCenterX = Math.cos(Math.toRadians(sensorHeading - 180))
				* (-boresightDistance);

	}

	/**
	 * 
	 * @return boresightCenterX
	 */
	public double getBoresightCenterX() {
		return boresightCenterX;
	}

	/**
	 * C�lculo das coordenada cartesiana y do boresight utilizando a dist�ncia
	 * (distance) a partir de um ponto em nadir at� o ponto do boresight
	 */
	private void setBoresightCenterY() {
		boresightCenterY = -Math.sin(Math.toRadians(sensorHeading - 180))
				* (-boresightDistance);
	}

	/**
	 * 
	 * @return boresightCenterY
	 */
	public double getBoresightCenterY() {
		// this.setBoresightCenterY();
		return boresightCenterY;
	}

	/**
	 * C�lculo da distancia em x utilizando a dist�ncia lateralDistanceToRight a partir de
	 * um ponto em nadir at� o ponto lateral direito
	 */
	public void setxRight() {
		this.xRight = Math.cos(Math.toRadians(sensorHeading - 180))
				* (-lateralDistanceToRight);
	}

	/**
	 * 
	 * @return xRight
	 */
	public double getxRight() {
		return this.xRight;
	}

	/**
	 * C�lculo da distancia em y utilizando a dist�ncia lateralDistanceToRight a partir de
	 * um ponto em nadir at� o ponto lateral direito
	 */
	public void setyRight() {
		this.yRight = -Math.sin(Math.toRadians(sensorHeading - 180))
				* (-lateralDistanceToRight);
	}

	/**
	 * 
	 * @return yRight
	 */
	public double getyRight() {
		return this.yRight;
	}

	public void setxLeft() {

		this.xLeft = Math.cos(Math.toRadians(sensorHeading - 180))
				* (lateralDistanceToLeft);
	}

	/**
	 * 
	 * @return xLeft
	 */
	public double getxLeft() {
		return this.xLeft;
	}

	public void setyLeft() {

		this.yLeft = -Math.sin(Math.toRadians(sensorHeading - 180))
				* (lateralDistanceToLeft);
	}

	/**
	 * 
	 * @return yLeft
	 */
	public double getyLeft() {
		return this.yLeft;
	}

	public void setXRightFromCenter() {
		this.xRightFromCenter = Math.cos(Math.toRadians(sensorHeading - 180))
				* (-(lateralDistanceToRight - boresightDistance));
	}

	/**
	 * 
	 * @return xRightFromCenter
	 */
	public double getXRightFromCenter() {
		return xRightFromCenter;
	}

	public void setYRightFromCenter() {
		this.yRightFromCenter = -Math.sin(Math.toRadians(sensorHeading - 180))
				* (-(lateralDistanceToRight - boresightDistance));
	}

	/**
	 * 
	 * @return yRightFromCenter
	 */
	public double getYRightFromCenter() {
		return yRightFromCenter;
	}

	public void setXLeftFromCenter() {
		this.xLeftFromCenter = Math.cos(Math.toRadians(sensorHeading - 180)) * (boresightDistance - lateralDistanceToLeft);
	}

	/**
	 * 
	 * @return xLeftFromCenter
	 */
	public double getXLeftFromCenter() {
		return xLeftFromCenter;
	}

	public void setYLeftFromCenter() {
		this.yLeftFromCenter = -Math.sin(Math.toRadians(sensorHeading - 180))
				* (boresightDistance - lateralDistanceToLeft);
	}

	/**
	 * 
	 * @return yLeftFromCenter
	 */
	public double getYLeftFromCenter() {
		return yLeftFromCenter;
	}

	/**
	 * valor alterado de 180 para 90
	 */
	private void setCoordX() {
		this.coordXProx = Math.sin(Math.toRadians(sensorHeading + 360)) * (nextPointAheadDistance);
		//this.coordXProx = -Math.sin(Math.toRadians(sensorHeading + 90 -180)) * (nextPointAheadDistance);
	}

	/**
	 * 
	 * @return coordXProx
	 */
	public double getCoordX() {
		return coordXProx;
	}

	/**
	 * valor alterado de 180 para 90
	 */
	private void setCoordY() {
		this.coordYProx = Math.cos(Math.toRadians(sensorHeading + 360)) * (nextPointAheadDistance);
		//this.coordYProx = Math.cos(Math.toRadians(sensorHeading + 90 - 180)) * (nextPointAheadDistance);
	}

	/**
	 * 
	 * @return coordYProx
	 */
	public double getCoordY() {
		return coordYProx;
	}
}
