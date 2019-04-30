package lab2.geoPosition;

public class GeoTrack extends GeoRoute {
	
	private int day, month, year;
	
	private String date = String.format("%4d. %2d. %2d", day, month, year);

	//constructor
	public GeoTrack(String name, String date) {
		super(name);
		this.date = date;
	}

	//getter and setter
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
