package br.org.calc.vicenty;

public class GeodeticCalculator

{

	private final double TwoPi = 2.0 * Math.PI;

	public GeodeticCurve calculateGeodeticCurve(Ellipsoid ellipsoid,

	GlobalCoordinates start, GlobalCoordinates end)

	{

		// get constants

		double a = ellipsoid.getSemiMajorAxis();

		double b = ellipsoid.getSemiMinorAxis();

		double f = ellipsoid.getFlattening();

		// get parameters as radians

		double phi1 = Angle.toRadians(start.getLatitude());

		double lambda1 = Angle.toRadians(start.getLongitude());

		double phi2 = Angle.toRadians(end.getLatitude());

		double lambda2 = Angle.toRadians(end.getLongitude());

		// calculations

		double a2 = a * a;

		double b2 = b * b;

		double a2b2b2 = (a2 - b2) / b2;

		double omega = lambda2 - lambda1;

		double tanphi1 = Math.tan(phi1);

		double tanU1 = (1.0 - f) * tanphi1;

		double U1 = Math.atan(tanU1);

		double sinU1 = Math.sin(U1);

		double cosU1 = Math.cos(U1);

		double tanphi2 = Math.tan(phi2);

		double tanU2 = (1.0 - f) * tanphi2;

		double U2 = Math.atan(tanU2);

		double sinU2 = Math.sin(U2);

		double cosU2 = Math.cos(U2);

		double sinU1sinU2 = sinU1 * sinU2;

		double cosU1sinU2 = cosU1 * sinU2;

		double sinU1cosU2 = sinU1 * cosU2;

		double cosU1cosU2 = cosU1 * cosU2;

		// eq. 13

		double lambda = omega;

		// intermediates we�ll need to compute �s�

		double A = 0.0;

		double B = 0.0;

		double sigma = 0.0;

		double deltasigma = 0.0;

		double lambda0;

		boolean converged = false;

		for (int i = 0; i < 10; i++)

		{

			lambda0 = lambda;

			double sinlambda = Math.sin(lambda);

			double coslambda = Math.cos(lambda);

			// eq. 14

			double sin2sigma = (cosU2 * sinlambda * cosU2 * sinlambda)

			+ (cosU1sinU2 - sinU1cosU2 * coslambda)

			* (cosU1sinU2 - sinU1cosU2 * coslambda);

			double sinsigma = Math.sqrt(sin2sigma);

			// eq. 15

			double cossigma = sinU1sinU2 + (cosU1cosU2 * coslambda);

			// eq. 16

			sigma = Math.atan2(sinsigma, cossigma);

			// eq. 17 Careful! sin2sigma might be almost 0!

			double sinalpha = (sin2sigma == 0) ? 0.0

			: cosU1cosU2 * sinlambda / sinsigma;

			double alpha = Math.asin(sinalpha);

			double cosalpha = Math.cos(alpha);

			double cos2alpha = cosalpha * cosalpha;

			// eq. 18 Careful! cos2alpha might be almost 0!

			double cos2sigmam = cos2alpha == 0.0 ? 0.0

			: cossigma - 2 * sinU1sinU2 / cos2alpha;

			double u2 = cos2alpha * a2b2b2;

			double cos2sigmam2 = cos2sigmam * cos2sigmam;

			// eq. 3

			A = 1.0 + u2 / 16384 * (4096 + u2 * (-768 + u2 * (320 - 175 * u2)));

			// eq. 4

			B = u2 / 1024 * (256 + u2 * (-128 + u2 * (74 - 47 * u2)));

			// eq. 6

			deltasigma = B * sinsigma * (cos2sigmam + B / 4

			* (cossigma * (-1 + 2 * cos2sigmam2) - B / 6 * cos2sigmam

			* (-3 + 4 * sin2sigma) * (-3 + 4 * cos2sigmam2)));

			// eq. 10

			double C = f / 16 * cos2alpha * (4 + f * (4 - 3 * cos2alpha));

			// eq. 11 (modified)

			lambda = omega + (1 - C) * f * sinalpha

			* (sigma + C * sinsigma * (cos2sigmam + C * cossigma * (-1 + 2 *

			cos2sigmam2)));

			// see how much improvement we got

			double change = Math.abs((lambda - lambda0) / lambda);

			if ((i > 1) && (change < 0.0000000000001))

			{

				converged = true;

				break;

			}

		}

		// eq. 19

		double s = b * A * (sigma - deltasigma);

		double alpha1;

		double alpha2;

		// didn�t converge? must be N/S

		if (!converged)

		{

			if (phi1 > phi2)

			{

				alpha1 = 180.0;

				alpha2 = 0.0;

			}

			else if (phi1 < phi2)

			{

				alpha1 = 0.0;

				alpha2 = 180.0;

			}

			else

			{

				alpha1 = Double.NaN;

				alpha2 = Double.NaN;

			}

		}

		// else, it converged, so do the math

		else

		{

			double radians;

			// eq. 20

			radians = Math.atan2(cosU2 * Math.sin(lambda),

			(cosU1sinU2 - sinU1cosU2 * Math.cos(lambda)));

			if (radians < 0.0)
				radians += TwoPi;

			alpha1 = Angle.toDegrees(radians);

			// eq. 21

			radians = Math.atan2(cosU1 * Math.sin(lambda),

			(-sinU1cosU2 + cosU1sinU2 * Math.cos(lambda))) + Math.PI;

			if (radians < 0.0)
				radians += TwoPi;

			alpha2 = Angle.toDegrees(radians);

		}

		if (alpha1 >= 360.0)
			alpha1 -= 360.0;

		if (alpha2 >= 360.0)
			alpha2 -= 360.0;

		return new GeodeticCurve(s, alpha1, alpha2);

	}
}
