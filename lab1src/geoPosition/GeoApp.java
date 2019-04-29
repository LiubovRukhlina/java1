package geoPosition;

import java.lang.Math;

public class GeoApp {

	public static void main(String[] args) {
		GeoPosition haw = new GeoPosition(53.557078, 10.023109);
		GeoPosition eiffelTower = new GeoPosition(48.858363, 2.294481);
		GeoPosition palmaDeMallorca = new GeoPosition(39.562553, 2.661947);	
		GeoPosition lasVegas = new GeoPosition(36.156214, -115.148736);
		GeoPosition copacabana = new GeoPosition(-22.971177, -43.182543);
		GeoPosition waikikiBeach = new GeoPosition(21.281004, -157.837456);
		GeoPosition surfersParadise = new GeoPosition(-28.002695, 153.431781);
		GeoPosition northPole = new GeoPosition (90.00000, 0.000000);
		GeoPosition equator = new GeoPosition (00.000000, 10.023109);
		GeoPosition southPole = new GeoPosition (-90.00000, 0.000000);

		//Store the location names in an array
		final String[] places = { "HAW", "Eiffel Tower", "Palma De Mall.", "Las Vegas", "Copacabana", "Waikiki Beach", "Surfer's Para.", "North Pole", "Equator\t", "South Pole" }; 
		
		//Assigning the GeoPosition values of each location into an array
		final GeoPosition[] GeoPositions = {haw,  eiffelTower, palmaDeMallorca, lasVegas, copacabana, waikikiBeach, surfersParadise, northPole, equator, southPole};
		
		System.out.println("Location\t Latitude\t Longitude\t Distance in Km\t Distance in Km\t Deviation Percentage");
		System.out.println("\t\t\t\t\t\t   (accurate)\t     (local)");
		
		//For-loop to print the location, latitude, longitude, distance in Km, local distance and deviation percentage between the two computations
		for (int i = 0; i < 10; i++) {
			System.out.println(String.format("%-16s %-15f %-15f %-20s %-14s %-14s", places[i], GeoPositions[i].getLatitude(), GeoPositions[i].getLongitude(), 
					String.format("%.02f" , GeoPosition.distanceInKm(haw, GeoPositions[i])), String.format("%.02f" , GeoPosition.localDistanceInKm(haw, GeoPositions[i])), 
					String.format("%.02f" , Math.abs((GeoPosition.localDistanceInKm(haw, GeoPositions[i]) - haw.distanceInKm(GeoPositions[i])) / GeoPosition.distanceInKm(haw, GeoPositions[i]) * 100)  ) + "%"));
		}
	}
}
