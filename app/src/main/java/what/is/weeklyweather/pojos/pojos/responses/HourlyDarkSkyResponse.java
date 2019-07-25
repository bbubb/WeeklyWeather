package what.is.weeklyweather.pojos.pojos.responses;

import com.google.gson.annotations.SerializedName;

import what.is.weeklyweather.pojos.pojos.responses.responsepojos.hourly.Hourly;

public class HourlyDarkSkyResponse{

	@SerializedName("offset")
	private double offset;

	@SerializedName("timezone")
	private String timezone;

	@SerializedName("latitude")
	private double latitude;

	@SerializedName("hourly")
	private Hourly hourly;

	@SerializedName("longitude")
	private double longitude;

	public void setOffset(double offset){
		this.offset = offset;
	}

	public double getOffset(){
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

	public void setHourly(Hourly hourly){
		this.hourly = hourly;
	}

	public Hourly getHourly(){
		return hourly;
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
			"HourlyDarkSkyResponse{" + 
			"offset = '" + offset + '\'' + 
			",timezone = '" + timezone + '\'' + 
			",latitude = '" + latitude + '\'' + 
			",hourly = '" + hourly + '\'' + 
			",longitude = '" + longitude + '\'' + 
			"}";
		}
}