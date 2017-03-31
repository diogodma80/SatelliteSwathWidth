package br.org.tests;

import br.org.model.swath.CalculaAnguloC;
import br.org.model.swath.CalculaCoordenadasCartesianas;
import br.org.model.swath.CalculaHipotenusaP;
import br.org.model.swath.CalculaSwathWidth;

public class TestCalculaAnguloC {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		CalculaCoordenadasCartesianas coordenadas = new CalculaCoordenadasCartesianas(188, 111899.2351, 20000, 279922.9515, -55944.6261);
		CalculaHipotenusaP p = new CalculaHipotenusaP(coordenadas);
		CalculaAnguloC c = new CalculaAnguloC(p);
		
		
		
		System.out.printf("c right %4f\n", c.getCRight());
		System.out.printf("c left %4f\n", c.getCLeft());
		System.out.printf("c center %4f\n", c.getCCenter());
		System.out.printf("c right from boresight %4f\n", c.getCRightFromBoresight());
		System.out.printf("c left from boreight %4f\n", c.getCLeftFromBoresight());
		System.out.printf("c ahead %4f\n", c.getCAhead()); 

	}

}
