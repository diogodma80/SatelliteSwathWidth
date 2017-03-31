package br.org.tests;

import br.org.model.lambda.CalculaLambdaCentral;
import br.org.model.swath.CalculaAnguloC;
import br.org.model.swath.CalculaCoordenadasCartesianas;
import br.org.model.swath.CalculaHipotenusaP;

public class TestCalculaLambdaCentral {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CalculaCoordenadasCartesianas coordenadas = new CalculaCoordenadasCartesianas(188, 111899.2351, 20000, 279922.9515, -55944.6261);
		CalculaHipotenusaP p = new CalculaHipotenusaP(coordenadas);
		CalculaAnguloC c = new CalculaAnguloC(p);
		
		//-15.5003 e -47.5282 s�o a latitude e longitude informadas no inicio da simula��o
		CalculaLambdaCentral lambdaCentral = new CalculaLambdaCentral(c, coordenadas, p, -15.5003, -47.5282);
		
		System.out.printf("lambdaCentreal %4f\n", lambdaCentral.getLambdaCentral());
	}

}
