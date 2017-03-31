package br.org.tests;

import br.org.model.phi.CalculaPhiCentral;
import br.org.model.swath.CalculaAnguloC;
import br.org.model.swath.CalculaCoordenadasCartesianas;
import br.org.model.swath.CalculaHipotenusaP;

public class TestCalculaPhiCentral {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CalculaCoordenadasCartesianas coordenadas = new CalculaCoordenadasCartesianas(188, 111899.2351, 20000, 279922.9515, -55944.6261);
		CalculaHipotenusaP p = new CalculaHipotenusaP(coordenadas);
		CalculaAnguloC c = new CalculaAnguloC(p);
		
		//-15.5003 � a latitude informada no inicio da simula��o
		CalculaPhiCentral phiCentral = new CalculaPhiCentral(c, coordenadas, p, -15.5003);
		System.out.printf("phiCentral: %4f", phiCentral.getPhiCentral());
	}

}
