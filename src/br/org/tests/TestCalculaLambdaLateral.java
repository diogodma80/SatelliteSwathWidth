package br.org.tests;

import br.org.model.lambda.CalculaLambdaCentral;
import br.org.model.lambda.CalculaLambdaLateral;
import br.org.model.phi.CalculaPhiCentral;
import br.org.model.phi.CalculaPhiLateral;
import br.org.model.swath.CalculaAnguloC;
import br.org.model.swath.CalculaCoordenadasCartesianas;
import br.org.model.swath.CalculaHipotenusaP;
import br.org.model.swath.CalculaSwathWidth;

public class TestCalculaLambdaLateral {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		CalculaCoordenadasCartesianas coordenadas = new CalculaCoordenadasCartesianas(188, 111899.2351, 20000, 279922.9515, -55944.6261);
		CalculaHipotenusaP p = new CalculaHipotenusaP(coordenadas);
		CalculaAnguloC c = new CalculaAnguloC(p);
		CalculaPhiCentral phiCentral = new CalculaPhiCentral(c, coordenadas, p, -15.5003);
		CalculaLambdaCentral lambdaCentral = new CalculaLambdaCentral(c, coordenadas, p, -15.5003, -47.5282);
		
		CalculaLambdaLateral lambdaLateral = new CalculaLambdaLateral(c, coordenadas, p, phiCentral.getPhiCentral(), lambdaCentral.getLambdaCentral(), -47.5282);
		

		System.out.printf("TESTE lambda lateral direito: %.8f\n", lambdaLateral.getLambdaLateralDireito());
		System.out.printf("TESTE lambda lateral esquerdo: %.8f\n", lambdaLateral.getLambdaLateralEsquerdo());
		
	}

}
