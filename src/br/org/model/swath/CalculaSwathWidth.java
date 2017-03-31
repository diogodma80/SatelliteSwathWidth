package br.org.model.swath;

public class CalculaSwathWidth {
	private double a;
	private double swathWidth;
	
	private double s;
	private double altitude;
	
	private final double earthRadius = 6378137;
	
	/**
	 * classe recebe a altura e o angulo boresight s para calcular
	 * o swath width do sensor, que é a projeção do sensor no solo
	 * @param s
	 * @param altura
	 */
	public CalculaSwathWidth(double s, double altitude) {
		super();
		this.s = s;
		this.altitude = altitude;
	}
	
	/**
	 * 
	 * @param s
	 */
	public void setS(double s) {
		this.s = s;
	}
	
	/**
	 * 
	 * @param altitude
	 */
	public void setAltitude(double altitude) {
		this.altitude = altitude;
	}
	
	/**
	 * parâmetro necessário para o cálculo do swathWidth
	 * @return a
	 */
	public double getA() {
		a = Math.toDegrees(Math.sin(Math.toRadians(s)));
		a = a * (earthRadius + altitude);
		a = a / earthRadius;
		a = Math.toDegrees(Math.asin(Math.toRadians(a)));
		a = a - s;	
		return a;
	} 
	
	/**
	 * largura calculada com base no ângulo e altura definido
	 * @return swathWidth
	 */
	public double getSwathPath() {
		swathWidth = ((getA()/(2 * Math.PI)) * earthRadius);
		return swathWidth;
	}

}
