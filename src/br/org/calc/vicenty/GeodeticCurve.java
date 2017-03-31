package br.org.calc.vicenty;

import java.io.Serializable;

public class GeodeticCurve implements Serializable

{

	private final double mEllipsoidalDistance;

	private final double mAzimuth;

	private final double mReverseAzimuth;

	public GeodeticCurve(double ellipsoidalDistance, double azimuth,

	double reverseAzimuth)

	{

		mEllipsoidalDistance = ellipsoidalDistance;

		mAzimuth = azimuth;

		mReverseAzimuth = reverseAzimuth;

	}

	public double getEllipsoidalDistance()

	{

		return mEllipsoidalDistance;

	}

	public double getAzimuth()

	{

		return mAzimuth;

	}

	public double getReverseAzimuth()

	{

		return mReverseAzimuth;

	}

}
