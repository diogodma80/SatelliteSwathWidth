package br.org.calc.area;

import java.util.List;

import br.org.calc.vicenty.Ellipsoid;
import br.org.calc.vicenty.GeodeticCalculator;
import br.org.calc.vicenty.GeodeticCurve;
import br.org.calc.vicenty.GlobalCoordinates;

public class CalculaAreaVicenty {

	private double latFirstRight;
	private double latFirstLeft;
	private double latLastRight;
	private double latLastLeft;
	private double lonFirstRight;
	private double lonFirstLeft;
	private double lonLastRight;
	private double lonLastLeft;

	GeodeticCalculator geoCalc;
	Ellipsoid reference;

	GlobalCoordinates coordOne;
	GlobalCoordinates coordTwo;
	GeodeticCurve geoCurve;

	public CalculaAreaVicenty(List<Double> x, List<Double> y) {

		this.latFirstRight = x.get(0);
		this.latFirstLeft = x.get(1);
		this.latLastRight = x.get(2);
		this.latLastLeft = x.get(3);

		this.lonFirstRight = y.get(0);
		this.lonFirstLeft = y.get(1);
		this.lonLastRight = y.get(2);
		this.lonLastLeft = y.get(3);

		// instantiate the calculator
		geoCalc = new GeodeticCalculator();

		// selects a reference elllipsoid
		reference = Ellipsoid.WGS84;

	}

	private double calcDistanciaH() {

		// set first coordinate
		coordOne = new GlobalCoordinates(latFirstRight, lonFirstRight);

		// set second coordinate
		coordTwo = new GlobalCoordinates(latFirstLeft, lonFirstLeft);
		
		// calculate the geodetic curve
		geoCurve = geoCalc.calculateGeodeticCurve(reference, coordOne,
				coordTwo);

		double ellipseKilometers = geoCurve.getEllipsoidalDistance() / 1000.0;
		
		return ellipseKilometers;

		//double ellipseMiles = ellipseKilometers * 0.621371192;
	}

	private double calcDistanciaV() {
		
		// set Lincoln Memorial coordinates
		coordOne = new GlobalCoordinates(latFirstRight, lonFirstRight);

		// set Eiffel Tower coordinates
		coordTwo = new GlobalCoordinates(latLastRight, lonLastRight);
		
		// calculate the geodetic curve
		geoCurve = geoCalc.calculateGeodeticCurve(reference, coordOne,
				coordTwo);

		double ellipseKilometers = geoCurve.getEllipsoidalDistance() / 1000.0;
		
		return ellipseKilometers;

		//double ellipseMiles = ellipseKilometers * 0.621371192;
	}
	
	public double getArea(){
		
		return (calcDistanciaH() * calcDistanciaV());
	}

}
