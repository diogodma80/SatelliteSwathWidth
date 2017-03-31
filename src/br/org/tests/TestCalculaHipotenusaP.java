package br.org.tests;

import br.org.model.swath.CalculaCoordenadasCartesianas;
import br.org.model.swath.CalculaHipotenusaP;

public class TestCalculaHipotenusaP {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		CalculaCoordenadasCartesianas coordenadas = new CalculaCoordenadasCartesianas(188, 111899.2351, 20000, 279922.9515, -55944.6261);
		CalculaHipotenusaP p = new CalculaHipotenusaP(coordenadas);

//		Verificando os valores recebidos na classe CalculaHipotenusaP
//		System.out.printf("centerX: %4f\n", p.getCenterX());
//		System.out.printf("centerY: %4f\n", p.getCenterY());		
//		System.out.printf("xRight: %4f\n", p.getXRight());
//		System.out.printf("yRight: %4f\n", p.getYRight());
//		System.out.printf("xLeft: %4f\n", p.getXLeft());
//		System.out.printf("yLeft: %4f\n", p.getYLeft());		
//		System.out.printf("xRightFromBoresight: %4f\n", p.getxRightFromBoresight());
//		System.out.printf("yRightFromBoresight: %4f\n", p.getyRightFromBoresight());
//		System.out.printf("xLeftFromBoresight: %4f\n", p.getxLeftFromBoresight());
//		System.out.printf("yLeftFromBoresight: %4f\n", p.getyLeftFromBoresight());		
//		System.out.printf("xAhead: %4f\n", p.getxAhead());
//		System.out.printf("yAhead: %4f\n", p.getyAhead());
		
		
		System.out.printf("hip nadir até lado extremo direito: %4f\n", p.getHipotenusaRight());
		System.out.printf("hip nadir até lado extremo esquerdo: %4f\n", p.getHipotenusaLeft());		
		System.out.printf("hip nadir até centro boresight: %4f\n", p.getHipotenusaCenter());
		System.out.printf("hip nadir até proximo ponto na trajetória: %4f\n", p.getLineAhead());
		System.out.printf("hip centro boresight até extremo lateral direito: %4f\n", p.getHipotenusaRightFromBoresightPoint());
		System.out.printf("hip centro boresight até extremo lateral esquerdo: %4f\n", p.getHipotenusaLeftFromBoresightPoint());
	}

}
