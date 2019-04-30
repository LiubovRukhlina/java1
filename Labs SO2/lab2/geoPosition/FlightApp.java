package lab2.geoPosition;

import java.util.ArrayList;
import java.util.Collections;

public class FlightApp {

	public static void main(String[] args) {
		
		//object containing the flight routes
		ArrayList<GeoRoute> flights = RouteData.createFlightRoutes();
		
		//sorting & printing
		Collections.sort(flights);
		for (GeoRoute flight: flights) {
			System.out.println (flight);
		}
	}	
}
