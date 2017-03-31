package br.org.model.swath;

public class CalculaAnguloC {
	private double c;
	private double pAhead;
	private double pRight;
	private double pLeft;
	private double pCenter;
	private double pRightFromBoresight;
	private double pLeftFromBoresight;
	private static final double raioDaTerra = 6378137;
	
	public CalculaAnguloC(double lineAhead) {
		this.pAhead = lineAhead;
	}

	public CalculaAnguloC(CalculaHipotenusaP hip) {
		
		callGettersToHip(hip);
	}

	private void callGettersToHip(CalculaHipotenusaP hip) {
		this.pAhead = hip.getLineAhead();
		this.pRight = hip.getHipotenusaRight();
		this.pLeft = hip.getHipotenusaLeft();
		this.pCenter = hip.getHipotenusaCenter();	
		this.pRightFromBoresight = hip.getHipotenusaRightFromBoresightPoint();
		this.pLeftFromBoresight = hip.getHipotenusaLeftFromBoresightPoint();
		
	}

	public double getCRight() {

		c = (this.pRight / raioDaTerra) * (180 / Math.PI);
		return c;
	}

	public double getCLeft() {

		c = (this.pLeft / raioDaTerra) * (180 / Math.PI);
		return c;
	}
	
	public double getCCenter() {

		c = (this.pCenter / raioDaTerra) * (180 / Math.PI);
		return c;
	}

	public double getCAhead() {
		c = (this.pAhead / raioDaTerra) * (180 / Math.PI);
		return c;
	}
	
	public double getCRightFromBoresight(){
		
		c = (this.pRightFromBoresight / raioDaTerra) * (180 / Math.PI);
		return c;
	}
	
	public double getCLeftFromBoresight(){
		
		c = (this.pLeftFromBoresight / raioDaTerra) * (180 / Math.PI);
		return c;
	}
}
