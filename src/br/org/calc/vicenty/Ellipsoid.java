package br.org.calc.vicenty;

import java.io.Serializable;


public class Ellipsoid implements Serializable

{

	private final double mSemiMajorAxis;

	private final double mSemiMinorAxis;

	private final double mFlattening;

	private final double mInverseFlattening;

	private Ellipsoid(double semiMajor, double semiMinor, double flattening,

	double inverseFlattening)

	{

		mSemiMajorAxis = semiMajor;

		mSemiMinorAxis = semiMinor;

		mFlattening = flattening;

		mInverseFlattening = inverseFlattening;

	}

	static public final Ellipsoid WGS84 = fromAAndInverseF(6378137.0,

	298.257223563);

	static public final Ellipsoid GRS80 = fromAAndInverseF(6378137.0,

	298.257222101);

	static public final Ellipsoid GRS67 = fromAAndInverseF(6378160.0, 298.25);

	static public final Ellipsoid ANS = fromAAndInverseF(6378160.0, 298.25);

	static public final Ellipsoid Clarke1880 = fromAAndInverseF(6378249.145,

	293.465);

	static public Ellipsoid fromAAndInverseF(double semiMajor,

        double inverseFlattening)

        {

        double f = 1.0 / inverseFlattening;

        double b = (1.0 - f) * semiMajor;

        return new Ellipsoid(semiMajor, b, f, inverseFlattening);

        }

	public double getSemiMajorAxis()

	{

		return mSemiMajorAxis;

	}

	public double getSemiMinorAxis()

	{

		return mSemiMinorAxis;

	}

	public double getFlattening()

	{

		return mFlattening;

	}

	public double getInverseFlattening()

	{

		return mInverseFlattening;

	}

}
