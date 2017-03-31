package br.org.model.swath;

public class CalculaCoordenadasCartesianas {

	/**
	 * inclinação do sensor em relação ao eixo da Terra
	 */
	private double sensorHeading;

	/**
	 * distância em metros do ponto mirado pelo sensor em relação a um ponto em
	 * nadir
	 */
	private double boresightDistance;

	/**
	 * distância em metros do próximo ponto ao longo do trajeto do
	 * sensor/satélite
	 */
	private double nextPointAheadDistance;

	/**
	 * distância limite em metros à direita da cobertura do sensor em relação a
	 * um ponto em nadir
	 */
	private double lateralDistanceToRight;

	/**
	 * distância limite em metros à esquerda da cobertura do sensor em relação a
	 * um ponto em nadir
	 */
	private double lateralDistanceToLeft;

	/**
	 * distância do ponto lateral (x)right referente ao ponto (x, y)boresight
	 */
	private double xRightFromCenter;

	/**
	 * distância do ponto lateral (y)right referente ao ponto (x, y)boresight
	 */
	private double yRightFromCenter;

	/**
	 * distância do ponto lateral (x)left referente ao ponto (x, y)boresight
	 */
	private double xLeftFromCenter;

	/**
	 * distância do ponto lateral (y)left referente ao ponto (x, y)boresight
	 */
	private double yLeftFromCenter;

	/**
	 * distância (x)right perpendicular ao ponto de visao do satélite
	 */
	private double xRight;

	/**
	 * distância (y)right perpendicular ao ponto de visao do satélite
	 */
	private double yRight;

	/**
	 * distância (x)left perpendicular ao ponto de visao do satélite
	 */
	private double xLeft;

	/**
	 * distância (y)left perpendicular ao ponto de visao do satélite
	 */
	private double yLeft;

	/**
	 * próxima coordenada (x)ahead ao longo do trajeto
	 */
	private double coordXProx;

	/**
	 * próxima coordenada (y)ahead ao longo do trajeto
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
	 * Todo satélite tem uma determinada inclinação em sua órbita e esta classe
	 * calcula as coordenadas cartesianas laterais à esta trajetória inclinada
	 * do satélite.
	 * 
	 * @param sensorHeading
	 *            ângulo de inclinação do sensor
	 * @param boresightDistance
	 *            distância em metros do ponto mirado pelo sensor em relação a
	 *            um ponto em nadir
	 * @param nextPointAheadDistance
	 *            distância em metros do próximo ponto ao longo do trajeto do
	 *            sensor/satélite
	 * @param lateralDistanceToRight
	 *            distância limite em metros à direita da cobertura do sensor em
	 *            relação a um ponto em nadir
	 * @param lateralDistanceToLeft
	 *            distância limite em metros à esquerda da cobertura do sensor
	 *            em relação a um ponto em nadir
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
		 * este método chama todos os setters desta classe
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
	 * Cálculo das coordenada cartesiana x do boresight utilizando a distância
	 * (distance) a partir de um ponto em nadir até o ponto do boresight
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
	 * Cálculo das coordenada cartesiana y do boresight utilizando a distância
	 * (distance) a partir de um ponto em nadir até o ponto do boresight
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
	 * Cálculo da distancia em x utilizando a distância lateralDistanceToRight a partir de
	 * um ponto em nadir até o ponto lateral direito
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
	 * Cálculo da distancia em y utilizando a distância lateralDistanceToRight a partir de
	 * um ponto em nadir até o ponto lateral direito
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
