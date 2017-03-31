package br.org.tests;

import br.org.model.swath.CalculaCoordenadasCartesianas;

public class TestCalculaProximaCoordenada {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CalculaCoordenadasCartesianas proxima = new CalculaCoordenadasCartesianas(188, 0, 20000, 83920.05858322943, 27971.689189379693);
		System.out.printf("x = %.4f\ty = %.4f", proxima.getCoordX(), proxima.getCoordY());

	}

}
