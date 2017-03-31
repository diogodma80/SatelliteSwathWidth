package br.org.tests;

import java.io.ObjectInputStream.GetField;

import br.org.model.swath.LateralSwathWidth;

public class TestCalculaLateralSwathWidth {

	/**
	 * Teste da classe LateralSwathWidth. Com esta class é possível informar o
	 * angulo boresight e o angulo de aperture do sensor e assim obter o
	 * comprimento a partir do nadir para os ponto onde este três angulo incidem
	 * no solo
	 * @param args
	 */
	public static void main(String[] args) {
		LateralSwathWidth lateralSwathWidth = new LateralSwathWidth(1.0, 3.0, 703000);

		double boresightDistance = lateralSwathWidth.getBoresightDistance();
		double lateralDistanceToRight = lateralSwathWidth.getLateralDistanceToRight();
		double lateralDistanceToLeft = lateralSwathWidth.getLateralDistanceToLeft();

		System.out.printf("boresightDistance: %.4f\n", boresightDistance);
		System.out.printf("lateralDistanceToRight: %.4f\n", lateralDistanceToRight);
		System.out.printf("lateralDistanceToLeft: %.4f\n", lateralDistanceToLeft);

	}

}
