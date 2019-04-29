package lab2.geoPosition;
import java.util.ArrayList;
import lab1.geoPosition.*;

public class GeoRoute implements Distance, Comparable<GeoRoute> {
	String name;
	ArrayList<GeoPosition> waypoints = new ArrayList<GeoPosition>();
	
	public GeoRoute(String name, ArrayList<GeoPosition> waypoints) {
		super();
		this.name = name;
		this.waypoints = waypoints;
	}
	public GeoRoute(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void addWaypoint(GeoPosition waypoint){
		waypoints.add(waypoint);
	}
	
	public void removeWaypoint(int index){
		waypoints.remove(index);	
	}
	
	public int getNumberWaypoints(){
		return waypoints.size();
	}
	
	public GeoPosition getWayPoint(int index){
		return waypoints.get(index);
	}
	
	public GeoPosition[] getWaypoints(){
		return this.waypoints.toArray(new GeoPosition[this.getNumberWaypoints()]);
	}
	
	public double getDistance() {
		double routeDistance = 0;
		for (int i = 0; i < (this.getNumberWaypoints() - 1); i++){
			routeDistance += GeoPosition.localDistanceInKm(this.getWayPoint(i), this.getWayPoint(i + 1));
		}
		return routeDistance;
	}
	
	
	@Override
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
		return name + "(" + getDistance() + ")";
	}
	

}
