package lab2.geoPosition;

public class RunningApp {

	public static void main(String[] args) {
		
		//creating running route objects
		GeoRoute binnenalster = RouteData.createAlsterRoute1();
		GeoRoute aussenalster = RouteData.createAlsterRoute2();
		GeoRoute citypark = RouteData.createAlsterRoute3();
		
		//printing stuff like there is no tomorrow
		System.out.printf("Route\t\t   Length km\n");
		System.out.println(binnenalster);
		System.out.println(aussenalster);
		System.out.println(citypark);
		
	}
}
