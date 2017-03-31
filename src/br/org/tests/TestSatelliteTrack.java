package br.org.tests;

import br.org.controller.SatelliteTrack;


public class TestSatelliteTrack {
/**
 * Este teste verifica se a classe SatelliteTrack cria o arquivos com os dados segundo os valores da modelagem
 * @param args
 */
	
	public static void main(String[] args){

		/**
		 * 
		 * @param subSatellitePoints
		 * @param sensorHeading
		 * @param latitude
		 * @param longitude
		 * @param boresightDistance
		 * @param nextPointAheadDistance
		 * @param apertureAngle
		 * @param altitudeInMeters
		 * @param boresightAngle que contem os bot�es do aplicativo
import java.awt.*;
		 * @param lateralDistanceToRight
		 * @param lateralDistanceToLeft
		 */
		SatelliteTrack track;

//		track = new SatelliteTrack(20, 188, -15.5003, -47.5282, 111899.2351, 20000, 3.0 /*aperture*/, 703000, 1.0 /*boresight*/, 279922.9515, -55944.6261);		
//		track.getTrack();
	
		track = new SatelliteTrack(20, 188, -15.5003, -47.5282, 55944.62607, 20000, 0.5 /*aperture*/, 703000, 0.5 /*boresight*/, 83920.05858, 27971.68919);		
		track.getTrack();
		
//		track = new SatelliteTrack(4, 188, -15.5003, -47.5282, 55944.62607, 20000, 1.0 /*aperture*/, 703000, 0.5 /*boresight*/, 111899.2351, 0);		
//		track.getTrack();
	}
}
