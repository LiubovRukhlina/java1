package lab2.geoPosition;
import java.util.ArrayList;
import lab1.geoPosition.GeoPosition;

public class GeoRoute implements Distance, Comparable<GeoRoute> {
	
	//identifying variables
	private String name;
	private ArrayList<GeoPosition> waypoints = new ArrayList<GeoPosition>();
	
	//constructors
	public GeoRoute(String name, ArrayList<GeoPosition> waypoints) {
		super();
		this.name = name;
		this.waypoints = waypoints;
	}
	
	public GeoRoute(String name) {
		this.name = name;
	}
	
	//getters and setters
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	//edit waypoint list
	public void addWaypoint(GeoPosition waypoint){
		waypoints.add(waypoint);
	}
	
	public void removeWaypoint(int index){
		if (index < this.getNumberWaypoints())
			this.waypoints.remove(index);
	}
	
	// get waypoint info
	public int getNumberWaypoints(){
		return waypoints.size();
	}
	
	public GeoPosition getWaypoint(int index){
		if (index < this.getNumberWaypoints())
			return this.waypoints.get(index);
		return null;
	}
	
	public GeoPosition[] getWaypoints(){
		return this.waypoints.toArray(new GeoPosition[this.getNumberWaypoints()]);
	}
	
	//distance calculation
	public double getDistance() {
		double routeDistance = 0;
		for (int i = 0; i < (this.getNumberWaypoints() - 1); i++){
			routeDistance += GeoPosition.distanceInKm(this.getWaypoint(i), this.getWaypoint(i + 1));
		}
		return routeDistance;
	}
	
	
	public int compareTo (GeoRoute other) {
		if (getDistance() < other.getDistance()) {
			return -1;
		} else if (getDistance() > other.getDistance()) {
			return 1;
		} else {
			return 0;
		}
	}
	
	@Override
	public String toString() {
		return String.format("%s (%.1f km)", name, getDistance());
	}
}
