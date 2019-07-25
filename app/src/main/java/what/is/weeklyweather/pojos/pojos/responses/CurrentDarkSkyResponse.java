package what.is.weeklyweather.pojos.pojos.responses;

import com.google.gson.annotations.SerializedName;

import what.is.weeklyweather.pojos.pojos.responses.responsepojos.Currently;

public class CurrentDarkSkyResponse{

	@SerializedName("currently")
	private Currently currently;

	@SerializedName("offset")
	private int offset;

	@SerializedName("timezone")
	private String timezone;

	@SerializedName("latitude")
	private double latitude;

	@SerializedName("longitude")
	private double longitude;

	public void setCurrently(Currently currently){
		this.currently = currently;
	}

	public Currently getCurrently(){
		return currently;
	}

	public void setOffset(int offset){
		this.offset = offset;
	}

	public int getOffset(){
		return offset;
	}

	public void setTimezone(String timezone){
		this.timezone = timezone;
	}

	public String getTimezone(){
		return timezone;
	}

	public void setLatitude(double latitude){
		this.latitude = latitude;
	}

	public double getLatitude(){
		return latitude;
	}

	public void setLongitude(double longitude){
		this.longitude = longitude;
	}

	public double getLongitude(){
		return longitude;
	}

	@Override
 	public String toString(){
		return 
			"CurrentDarkSkyResponse{" + 
			"currently = '" + currently + '\'' + 
			",offset = '" + offset + '\'' + 
			",timezone = '" + timezone + '\'' + 
			",latitude = '" + latitude + '\'' + 
			",longitude = '" + longitude + '\'' + 
			"}";
		}
}