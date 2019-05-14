package top.microiot.domain.attribute;

import top.microiot.exception.ValueException;

public class LocationType extends DataType {
	public static final String SPLIT = ",";

	public LocationType() {
		super(Type.Location);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isValid(AttValueInfo value) {
		if(value.getValue() == null)
			return false;
		String[] location = value.getValue().split(SPLIT);
		if(location.length != 2)
			return false;
		try{
			double longitude = Double.parseDouble(location[0]);
			if(longitude >180 || longitude < -180)
				return false;
			double latitude = Double.parseDouble(location[1]);
			if(latitude >90 || latitude < -90)
				return false;
			return true;
		}catch(NumberFormatException e){
			return false;
		}
	}

	@Override
	public AttValueInfo getAttValue(Object object) {
		if(object instanceof String) {
			AttValueInfo a = new AttValueInfo(object.toString());
			if(!isValid(a))
				throw new ValueException("expected data type is String, and format is longitude"+ SPLIT + "lantitude");
			else
				return a;
		} else if(object instanceof Location) {
			Location location = (Location)object;
			String longitude = Double.toString(location.getLongitude());
			String latitude = Double.toString(location.getLatitude());
			AttValueInfo a = new AttValueInfo(longitude + SPLIT + latitude);
			return a;
		} else
			throw new ValueException("expected data type is Location or String and format is longitude"+ SPLIT + "lantitude");
	}

	@Override
	public Object getData(DataValue value, Class<?> type) {
		if(value instanceof LocationValue) {
			LocationValue location =(LocationValue)value;
			return new Location( location.getLongitude(), location.getLatitude());
		}
		else
			throw new ValueException("expected data value is LocationValue, but not " + value.getClass().getName());
	}

	@Override
	public DataValue getAttData(Object object) {
		AttValueInfo a = getAttValue(object);
		
		return new LocationValue(a.getValue());
	}

	@Override
	public Object getValue(AttValueInfo value, Class<?> type) {
		// TODO Auto-generated method stub
		return getData(new LocationValue(value.getValue()), Location.class);
	}

}
