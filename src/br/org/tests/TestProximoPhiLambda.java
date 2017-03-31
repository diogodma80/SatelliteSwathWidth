package br.org.tests;

import br.org.model.swath.ProximoPhiLambda;

public class TestProximoPhiLambda {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ProximoPhiLambda ahead = new ProximoPhiLambda(188, 20000, 279922.9515, -55944.6261);
			
		System.out.printf("coordenada x right %4f\n", ahead.getCoordX());
		System.out.printf("coordenada y right %4f\n", ahead.getCoordY());

	}

}
