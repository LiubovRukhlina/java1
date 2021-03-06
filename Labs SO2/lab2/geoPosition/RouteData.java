package lab2.geoPosition;
import lab1.geoPosition.GeoPosition;
import java.util.ArrayList;


import java.util.Arrays;

public class RouteData {
	public static GeoRoute createAlsterRoute1() {
		GeoRoute route = new GeoRoute("Binnenalster");

		route.addWaypoint(new GeoPosition(53.556350, 10.021552));	// HAW
		route.addWaypoint(new GeoPosition(53.561181, 10.013452));	// Alster (Lohm�hlenstra�e)
		route.addWaypoint(new GeoPosition(53.557744, 10.004890));	// Alstertwiete
		route.addWaypoint(new GeoPosition(53.559162, 9.995711));	// Kennedybr�cke
		route.addWaypoint(new GeoPosition(53.554451, 9.990964));	// Jungfernstieg
		route.addWaypoint(new GeoPosition(53.552061, 9.994515));	// Ballindamm
		route.addWaypoint(new GeoPosition(53.557744, 10.004890));	// Alstertwiete
		route.addWaypoint(new GeoPosition(53.561154, 10.013484));	// Alster (Lohm�hlenstra�e)
		route.addWaypoint(new GeoPosition(53.556356, 10.021508));	// HAW
		return route;
	}

	public static GeoRoute createAlsterRoute2() {
		GeoRoute route = new GeoRoute("Au�enalster");

		route.addWaypoint(new GeoPosition(53.556254, 10.021650));	// HAW
		route.addWaypoint(new GeoPosition(53.561192, 10.013245));	// Alster (Lohm�hlenstra�e)
		route.addWaypoint(new GeoPosition(53.564232, 10.016791));	// Schwanenwik
		route.addWaypoint(new GeoPosition(53.579689, 10.008131));	// Gellertstra�e
		route.addWaypoint(new GeoPosition(53.579299, 9.998435));	// Eichenpark
		route.addWaypoint(new GeoPosition(53.567317, 10.001325));	// Alsterufer
		route.addWaypoint(new GeoPosition(53.558917, 9.995749));	// Kennedybr�cke
		route.addWaypoint(new GeoPosition(53.557652, 10.005126));	// Alstertwiete
		route.addWaypoint(new GeoPosition(53.561183, 10.013398));	// Alster (Lohm�hlenstra�e)
		route.addWaypoint(new GeoPosition(53.556464, 10.021379));	// HAW		
		return route;
	}
	
	public static GeoRoute createAlsterRoute3() {
		GeoRoute route = new GeoRoute("City Park");

		route.addWaypoint(new GeoPosition(53.598483, 10.004651));	// Olhsdorfer Str
		route.addWaypoint(new GeoPosition(53.599559, 10.010200));	// Point2
		route.addWaypoint(new GeoPosition(53.600301, 10.021668));	// Point3
		route.addWaypoint(new GeoPosition(53.600046, 10.029722));	// Point4
		route.addWaypoint(new GeoPosition(53.593581, 10.031945));	// Point5
		route.addWaypoint(new GeoPosition(53.590977, 10.028855));	// Point6
		route.addWaypoint(new GeoPosition(53.592110, 10.013985));	// Point7
		route.addWaypoint(new GeoPosition(53.593562, 10.010874));	// Point7
		route.addWaypoint(new GeoPosition(53.592957, 10.005070));	// Point8
		route.addWaypoint(new GeoPosition(53.598070, 10.004126));	// Point9
		return route;
	}
	public static ArrayList<GeoRoute> createFlightRoutes() {
		GeoPosition hamburg = new GeoPosition(53.633060, 9.993501);		// Hamburg
		
		GeoRoute billund = new GeoRoute("Kiel -> Billund");
		billund.addWaypoint(hamburg);
		billund.addWaypoint(new GeoPosition(54.379486, 10.144082));		// Kiel
		billund.addWaypoint(new GeoPosition(55.740806, 9.152466));		// Billund

		GeoRoute london = new GeoRoute("London");
		london.addWaypoint(hamburg);
		london.addWaypoint(new GeoPosition(51.470754, -0.457657));		// London
		
		GeoRoute lyon = new GeoRoute("Amsterdam -> Lyon");
		lyon.addWaypoint(hamburg);
		lyon.addWaypoint(new GeoPosition(52.310480, 4.767684));			// Amsterdam
		lyon.addWaypoint(new GeoPosition(45.720407, 5.081052));			// Lyon
		
		GeoRoute rom = new GeoRoute("M�nchen -> Rom");
		rom.addWaypoint(hamburg);
		rom.addWaypoint(new GeoPosition(48.353634, 11.774738));			// M�nchen
		rom.addWaypoint(new GeoPosition(41.799804, 12.245763));			// Rom
		
		GeoRoute saltLake = new GeoRoute("Salt Lake City");
		saltLake.addWaypoint(hamburg);
		saltLake.addWaypoint(new GeoPosition(40.786723, -111.982586));	// Salt Lake City
		
		return new ArrayList<GeoRoute>(Arrays.asList(lyon, saltLake, rom, billund, london));		
	}
}
