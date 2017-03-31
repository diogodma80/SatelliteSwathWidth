package br.org.model.swath;


public class ProximoPhiLambda extends CalculaCoordenadasCartesianas{

	/**
	 * Esta classe far� o c�lculo da proxima posi��o do sat�lite
	 * com base no seu trajeto e no swath width que ele projeta no solo.
	 * a super class recebe a inclina��o -90 graus, portanto o ponto 
	 * adiante ao longo do trajeto do sat�lite deve ser o ponto �
	 * direita
	 * � passado a inclina��o -90 pois esta representa a faixa
	 * perpendicular ao trajeto do satelite.
	 * @param inclinacao
	 * @param pathDistance
	 * @param lateral2 
	 * @param lateral1 
	 */
	public ProximoPhiLambda(double inclinacao, double pathDistance, double lateral1, double lateral2) {
		super(inclinacao, 0, pathDistance, lateral1, lateral2);
	}


}
