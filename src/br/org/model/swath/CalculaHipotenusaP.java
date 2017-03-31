package br.org.model.swath;

public class CalculaHipotenusaP {
	private double xRight;
	private double yRight;
	private double xLeft;
	private double yLeft;
	private double centerX;
	private double centerY;
	private double xRightFromBoresight;
	private double yRightFromBoresight;
	private double xLeftFromBoresight;
	private double yLeftFromBoresight;
	private double xAhead;
	private double yAhead;
	
	public CalculaHipotenusaP(){
		
	}
	
	/**
	 * Como o satélite apresenta uma certa inclinação em sua órbita,
	 * e o swath width deste satélite é perpendicular à esta inclinação
	 * é necessário calcular o comprimento deste. Este comprimento 
	 * é representado pela hipotenusa entre as coordenadas do heading
	 * e as coordenadas laterais do swath width
	 * @param c
	 */
	public CalculaHipotenusaP(CalculaCoordenadasCartesianas c){
		
		this.callGetters(c);
	}

	private void callGetters(CalculaCoordenadasCartesianas c) {
		
		centerX = c.getBoresightCenterX();
		centerY = c.getBoresightCenterY();

		xRight = c.getxRight();
		yRight = c.getyRight();
		xLeft = c.getxLeft();
		yLeft = c.getyLeft();
		
		xRightFromBoresight = c.getXRightFromCenter();
		yRightFromBoresight = c.getYRightFromCenter();
		xLeftFromBoresight = c.getXLeftFromCenter();
		yLeftFromBoresight = c.getYLeftFromCenter();

		xAhead = c.getCoordX();
		yAhead = c.getCoordY();	
	}

	/**
	 * RIGHT
	 */
	
	public double getXRight() {
		return xRight;
	}

	public void setXRight(double x) {
		this.xRight = x;
	}

	public double getYRight() {
		return yRight;
	}

	public void setYRight(double y) {
		this.yRight = y;
	}
	
	
	/**
	 * LEFT
	 */
	
	public double getXLeft() {
		return xLeft;
	}

	public void setXLeft(double x) {
		this.xLeft = x;
	}

	public double getYLeft() {
		return yLeft;
	}

	public void setYLeft(double y) {
		this.yLeft = y;
	}
	
	
	/**
	 * AHEAD
	 */
	
	public double getxAhead() {
		return xAhead;
	}

	public void setxAhead(double xAhead) {
		this.xAhead = xAhead;
	}

	public double getyAhead() {
		return yAhead;
	}

	public void setyAhead(double yAhead) {
		this.yAhead = yAhead;
	}
	
	
	/**
	 * CENTER
	 */
	
	public double getCenterX(){
		return centerX;
	}
	
	public void setCenterX(double x){
		this.centerX = x;
	}
	
	public double getCenterY(){
		return centerY;
	}
	
	public void setCenterY(double y){
		this.centerY = y;
	}
	
	/**
	 * RIGHT FROM BORESIGHT
	 */
	
	public double getxRightFromBoresight() {
		return xRightFromBoresight;
	}

	public void setxRightFromBoresight(double xRightFromBoresight) {
		this.xRightFromBoresight = xRightFromBoresight;
	}

	public double getyRightFromBoresight() {
		return yRightFromBoresight;
	}

	public void setyRightFromBoresight(double yRightFromBoresight) {
		this.yRightFromBoresight = yRightFromBoresight;
	}

	/**
	 * LEFT FROM BORESIGHT
	 */
	
	public double getxLeftFromBoresight() {
		return xLeftFromBoresight;
	}

	public void setxLeftFromBoresight(double xLeftFromBoresight) {
		this.xLeftFromBoresight = xLeftFromBoresight;
	}

	public double getyLeftFromBoresight() {
		return yLeftFromBoresight;
	}

	public void setyLeftFromBoresight(double yLeftFromBoresight) {
		this.yLeftFromBoresight = yLeftFromBoresight;
	}

	/**
	 * HIPOTENUSA
	 */
	
	public double getHipotenusaRight() {
		return (Math.pow((Math.pow(this.getXRight(), 2)) + (Math.pow(this.getYRight(), 2)), 0.5));
	}
	
	public double getHipotenusaLeft() {
		return (Math.pow((Math.pow(this.getXLeft(), 2)) + (Math.pow(this.getYLeft(), 2)), 0.5));
	}
	
	public double getHipotenusaCenter(){
		return Math.pow((Math.pow(this.getCenterX(), 2)) + (Math.pow(this.getCenterY(), 2)), 0.5);
	}

	public double getLineAhead() {
		return Math.pow((Math.pow(this.getxAhead(), 2)) + (Math.pow(this.getyAhead(), 2)), 0.5);
	}

	public double getHipotenusaRightFromBoresightPoint(){
		return (Math.pow((Math.pow(this.getxRightFromBoresight(), 2)) + (Math.pow(this.getyRightFromBoresight(), 2)), 0.5));
	}
	
	public double getHipotenusaLeftFromBoresightPoint(){
		return (Math.pow((Math.pow(this.getxLeftFromBoresight(), 2)) + (Math.pow(this.getyLeftFromBoresight(), 2)), 0.5));
	}
	

}
