package br.org.tests;

import br.org.model.swath.CalculaCoordenadasCartesianas;
import br.org.model.swath.CalculaSwathWidth;

public class TestCalculaCoordenadasCartesianas {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		/**
		 * @param sensorHeading
		 * @param boresightDistance
		 * @param nextPointAheadDistance
		 * @param lateralDistanceToRight
		 * @param lateralDistanceToLeft
		 */
		
		CalculaCoordenadasCartesianas coordenadas = new CalculaCoordenadasCartesianas(188, 111899.2351, 20000, 279922.9515, -55944.6261);
		System.out.printf("centro da visão do sensor - boresight x  %4f\n", coordenadas.getBoresightCenterX());
		System.out.printf("centro da visão do sensor - boresight y  %4f\n", coordenadas.getBoresightCenterY());
		System.out.printf("coordenada x right %4f\n", coordenadas.getxRight());
		System.out.printf("coordenada y right %4f\n", coordenadas.getyRight());
		System.out.printf("coordenada x left %4f\n", coordenadas.getxLeft());
		System.out.printf("coordenada y left %4f\n", coordenadas.getyLeft());
		System.out.printf("coordenada x right from center %4f\n", coordenadas.getXRightFromCenter());
		System.out.printf("coordenada y right from center %4f\n", coordenadas.getYRightFromCenter());
		System.out.printf("coordenada x left from center %4f\n", coordenadas.getXLeftFromCenter());
		System.out.printf("coordenada y left from center %4f\n", coordenadas.getYLeftFromCenter());
		System.out.printf("coordenada x prox %4f\n", coordenadas.getCoordX());
		System.out.printf("coordenada y prox %4f\n", coordenadas.getCoordY());
		System.out.println();


		
	}

}
