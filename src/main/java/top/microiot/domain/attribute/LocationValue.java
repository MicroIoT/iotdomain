package top.microiot.domain.attribute;

public class LocationValue extends DataValue {
	private double longitude;
	private double latitude;
	
	public LocationValue() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LocationValue(String value) {
		super();
		String[] location = value.split(LocationType.SPLIT);
		this.longitude = Double.parseDouble(location[0]);
		this.latitude = Double.parseDouble(location[1]);
	}
	
	@Override
	public String getString() {
		return String.valueOf("[" + this.longitude) + LocationType.SPLIT + " " + String.valueOf(this.latitude + "]");
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

}
