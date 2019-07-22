package what.is.weeklyweather.hourlydarksky;

import com.google.gson.annotations.SerializedName;

public class DataItem{

	@SerializedName("summary")
	private String summary;

	@SerializedName("precipProbability")
	private double precipProbability;

	@SerializedName("visibility")
	private double visibility;

	@SerializedName("windGust")
	private double windGust;

	@SerializedName("precipIntensity")
	private double precipIntensity;

	@SerializedName("icon")
	private String icon;

	@SerializedName("cloudCover")
	private double cloudCover;

	@SerializedName("windBearing")
	private double windBearing;

	@SerializedName("apparentTemperature")
	private double apparentTemperature;

	@SerializedName("pressure")
	private double pressure;

	@SerializedName("dewPoint")
	private double dewPoint;

	@SerializedName("ozone")
	private double ozone;

	@SerializedName("temperature")
	private double temperature;

	@SerializedName("humidity")
	private double humidity;

	@SerializedName("time")
	private double time;

	@SerializedName("windSpeed")
	private double windSpeed;

	@SerializedName("uvIndex")
	private double uvIndex;

	@SerializedName("precipType")
	private String precipType;

	public void setSummary(String summary){
		this.summary = summary;
	}

	public String getSummary(){
		return summary;
	}

	public void setPrecipProbability(double precipProbability){
		this.precipProbability = precipProbability;
	}

	public double getPrecipProbability(){
		return precipProbability;
	}

	public void setVisibility(double visibility){
		this.visibility = visibility;
	}

	public double getVisibility(){
		return visibility;
	}

	public void setWindGust(double windGust){
		this.windGust = windGust;
	}

	public double getWindGust(){
		return windGust;
	}

	public void setPrecipdoubleensity(double precipIntensity){
		this.precipIntensity = precipIntensity;
	}

	public double getPrecipdoubleensity(){
		return precipIntensity;
	}

	public void setIcon(String icon){
		this.icon = icon;
	}

	public String getIcon(){
		return icon;
	}

	public void setCloudCover(double cloudCover){
		this.cloudCover = cloudCover;
	}

	public double getCloudCover(){
		return cloudCover;
	}

	public void setWindBearing(double windBearing){
		this.windBearing = windBearing;
	}

	public double getWindBearing(){
		return windBearing;
	}

	public void setApparentTemperature(double apparentTemperature){
		this.apparentTemperature = apparentTemperature;
	}

	public double getApparentTemperature(){
		return apparentTemperature;
	}

	public void setPressure(double pressure){
		this.pressure = pressure;
	}

	public double getPressure(){
		return pressure;
	}

	public void setDewPoint(double dewPoint){
		this.dewPoint = dewPoint;
	}

	public double getDewPoint(){
		return dewPoint;
	}

	public void setOzone(double ozone){
		this.ozone = ozone;
	}

	public double getOzone(){
		return ozone;
	}

	public void setTemperature(double temperature){
		this.temperature = temperature;
	}

	public double getTemperature(){
		return temperature;
	}

	public void setHumidity(double humidity){
		this.humidity = humidity;
	}

	public double getHumidity(){
		return humidity;
	}

	public void setTime(double time){
		this.time = time;
	}

	public double getTime(){
		return time;
	}

	public void setWindSpeed(double windSpeed){
		this.windSpeed = windSpeed;
	}

	public double getWindSpeed(){
		return windSpeed;
	}

	public void setUvIndex(double uvIndex){
		this.uvIndex = uvIndex;
	}

	public double getUvIndex(){
		return uvIndex;
	}

	public void setPrecipType(String precipType){
		this.precipType = precipType;
	}

	public String getPrecipType(){
		return precipType;
	}

	@Override
 	public String toString(){
		return 
			"DataItem{" + 
			"summary = '" + summary + '\'' + 
			",precipProbability = '" + precipProbability + '\'' + 
			",visibility = '" + visibility + '\'' + 
			",windGust = '" + windGust + '\'' + 
			",precipIntensity = '" + precipIntensity + '\'' + 
			",icon = '" + icon + '\'' + 
			",cloudCover = '" + cloudCover + '\'' + 
			",windBearing = '" + windBearing + '\'' + 
			",apparentTemperature = '" + apparentTemperature + '\'' + 
			",pressure = '" + pressure + '\'' + 
			",dewPoint = '" + dewPoint + '\'' + 
			",ozone = '" + ozone + '\'' + 
			",temperature = '" + temperature + '\'' + 
			",humidity = '" + humidity + '\'' + 
			",time = '" + time + '\'' + 
			",windSpeed = '" + windSpeed + '\'' + 
			",uvIndex = '" + uvIndex + '\'' + 
			",precipType = '" + precipType + '\'' + 
			"}";
		}
}