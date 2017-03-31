package br.org.tests;

import br.org.model.lambda.CalculaLambdaAhead;
import br.org.model.swath.CalculaAnguloC;
import br.org.model.swath.CalculaHipotenusaP;
import br.org.model.swath.ProximoPhiLambda;

public class TestCalculaLambdaAhead {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ProximoPhiLambda ahead = new ProximoPhiLambda(188, 20000, 279922.9515, -55944.6261);
		CalculaHipotenusaP p = new CalculaHipotenusaP(ahead);
		CalculaAnguloC c = new CalculaAnguloC(p);
		
		CalculaLambdaAhead lambdaAhead = new CalculaLambdaAhead(c, ahead, p, -15.5003, -47.5282);
		System.out.printf("lamdbaAhead: %4f", lambdaAhead.getLambda());

	}

}
