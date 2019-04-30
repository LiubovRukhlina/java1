package lab1.geoPosition;

import java.lang.Math;

public class GeoPosition {
	
	private double latitude = 0;
	private double longitude = 0;
	
	public GeoPosition(double latitude, double longitude) {
		this.latitude = latitude; 
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}
	
	public boolean isNorthernHemisphere() {
		if (latitude > 0) {
			return true;
		} else {
		return false;
		}
	}
	
	public boolean isSouthernHemisphere() {
		if (latitude < 0) {
			return true;
		} else {
		return false;
		}
	}

	public static double localDistanceInKm(GeoPosition a, GeoPosition b) {
		//Determine the local distance between two coordinates 
		double localDistanceInKm;
		double deltaX = 111.3 * Math.cos((a.latitude * Math.PI / 180 + b.latitude * Math.PI / 180) / 2) * Math.abs(a.longitude - b.longitude);
		double deltaY = 111.3 * Math.abs(a.latitude - b.latitude);
		localDistanceInKm = Math.sqrt (deltaX * deltaX + deltaY * deltaY);
		return localDistanceInKm;
	}
	
	public static double distanceInKm(GeoPosition a, GeoPosition b) {
		//Determine the distance between two coordinates
		double distanceInKm;
		double latitude1 = (a.latitude * Math.PI) / 180;
		double longitude1 = (a.longitude * Math.PI) / 180;
		double latitude2 = (b.latitude * Math.PI) / 180;
		double longitude2 = (b.longitude * Math.PI) / 180;
		distanceInKm = 6378.388 * Math.acos(Math.sin(latitude1) * Math.sin(latitude2) + Math.cos(latitude1) * Math.cos(latitude2) * Math.cos(longitude2 - longitude1));
		return distanceInKm;
	}
	
	public double distanceInKm(GeoPosition other) {
		//Determine the distance between two coordinates
		double distanceInKm;
		double latitude1 = this.latitude;
		double longitude1 = this.longitude;
		double latitude2 = other.latitude;
		double longitude2 = other.longitude;
		distanceInKm = 6378.388 * Math.acos(Math.sin(Math.toRadians(latitude1)) * Math.sin(Math.toRadians(latitude2)) + Math.cos(Math.toRadians(latitude1)) * Math.cos(Math.toRadians(latitude2)) * Math.cos(Math.toRadians(longitude2) - Math.toRadians(longitude1)));
		return distanceInKm;
	}

	@Override
	public String toString() {
		return "(" + latitude + ", " + longitude + ")";
	}	

}
