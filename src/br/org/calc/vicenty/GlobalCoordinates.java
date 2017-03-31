package br.org.calc.vicenty;

import java.io.Serializable;


public class GlobalCoordinates implements Comparable<GlobalCoordinates>, Serializable

{

	private double mLatitude;

	private double mLongitude;

	public GlobalCoordinates(double latitude, double longitude)

	{

		mLatitude = latitude;

		mLongitude = longitude;

	}

	public double getLatitude()

	{

		return mLatitude;

	}

	public void setLatitude(double latitude)

	{

		mLatitude = latitude;

	}

	public double getLongitude()

	{

		return mLongitude;

	}

	public void setLongitude(double longitude)

	{

		mLongitude = longitude;

	}

	@Override
	public int compareTo(GlobalCoordinates arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

}
