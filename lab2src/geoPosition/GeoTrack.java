package lab2.geoPosition;

public class GeoTrack extends GeoRoute{
	String date = String.format("%2d. %2d. %4d", d, m, y);

	public GeoTrack(String name, String date) {
		super(name);
		this.date = date;
	}
	
}
