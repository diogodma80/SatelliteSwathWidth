package br.org.tests;

import br.org.model.phi.CalculaPhiAhead;
import br.org.model.swath.CalculaAnguloC;
import br.org.model.swath.CalculaCoordenadasCartesianas;
import br.org.model.swath.CalculaHipotenusaP;
import br.org.model.swath.ProximoPhiLambda;

public class TestCalculaPhiAhead {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ProximoPhiLambda ahead = new ProximoPhiLambda(188, 20000, 279922.9515, -55944.6261);
		CalculaHipotenusaP p = new CalculaHipotenusaP(ahead);
		CalculaAnguloC c = new CalculaAnguloC(p);
		
		CalculaPhiAhead phiAhead = new CalculaPhiAhead(c, ahead, p, -15.5003);
		System.out.printf("phiAhead: %4f", phiAhead.getPhi());
		
		
	}

}
