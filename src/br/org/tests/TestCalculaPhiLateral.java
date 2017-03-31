package br.org.tests;

import br.org.model.phi.CalculaPhiCentral;
import br.org.model.phi.CalculaPhiLateral;
import br.org.model.swath.CalculaAnguloC;
import br.org.model.swath.CalculaCoordenadasCartesianas;
import br.org.model.swath.CalculaHipotenusaP;
import br.org.model.swath.CalculaSwathWidth;

public class TestCalculaPhiLateral {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
				
		CalculaCoordenadasCartesianas coordenadas = new CalculaCoordenadasCartesianas(188, 111899.2351, 20000, 279922.9515, -55944.6261);
		CalculaHipotenusaP p = new CalculaHipotenusaP(coordenadas);
		CalculaAnguloC c = new CalculaAnguloC(p);
		CalculaPhiCentral phiCentral = new CalculaPhiCentral(c, coordenadas, p, -15.5003);
		
			
		CalculaPhiLateral phiLateral = new CalculaPhiLateral(c, coordenadas, p, phiCentral.getPhiCentral(), -15.5003);
		System.out.printf("TESTE Phi lateral direito: %.8f\n", phiLateral.getPhiLateralDireito());
		System.out.printf("TESTE Phi lateral esquerdo: %.8f\n", phiLateral.getPhiLateralEsquerdo());

		
		

	}

}
