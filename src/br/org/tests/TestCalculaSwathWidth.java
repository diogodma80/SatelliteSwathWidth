package br.org.tests;

import br.org.model.swath.CalculaSwathWidth;

public class TestCalculaSwathWidth {

	/**
	 * teste da classe CalculaSwathWidth. Esta classe deve retornar o
	 * comprimento dado um ângulo que pode ser tanto o boresight quanto os
	 * limites laterais da cobertura pelo sensor
	 * @param args
	 */
	public static void main(String[] args) {

		CalculaSwathWidth swath1;

		System.out.printf("Teste1 angulo boresight1\n");
		swath1 = new CalculaSwathWidth(1.0, 703000);
		System.out.printf("Teste1 swath: %.4f\n", swath1.getSwathPath());
		
		System.out.printf("Teste2 angulo à direita2.5\n");
		swath1 = new CalculaSwathWidth(2.5, 703000);
		System.out.printf("Teste1 swath: %.4f\n", swath1.getSwathPath());

		System.out.printf("Teste2 angulo à esquerda -0,5\n");
		swath1 = new CalculaSwathWidth(-0.5, 703000);
		System.out.printf("Teste1 swath: %.4f\n", swath1.getSwathPath());

	}

}