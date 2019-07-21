package what.is.weeklyweather.forecastdarksky;

import com.google.gson.annotations.SerializedName;

public class DataItem{

	@SerializedName("windGust")
	private double windGust;

	@SerializedName("apparentTemperatureMinTime")
	private int apparentTemperatureMinTime;

	@SerializedName("temperatureMax")
	private double temperatureMax;

	@SerializedName("icon")
	private String icon;

	@SerializedName("precipIntensityMax")
	private double precipIntensityMax;

	@SerializedName("windBearing")
	private int windBearing;

	@SerializedName("ozone")
	private double ozone;

	@SerializedName("temperatureMaxTime")
	private int temperatureMaxTime;

	@SerializedName("apparentTemperatureMin")
	private double apparentTemperatureMin;

	@SerializedName("sunsetTime")
	private int sunsetTime;

	@SerializedName("temperatureLow")
	private double temperatureLow;

	@SerializedName("precipType")
	private String precipType;

	@SerializedName("humidity")
	private double humidity;

	@SerializedName("moonPhase")
	private double moonPhase;

	@SerializedName("windSpeed")
	private double windSpeed;

	@SerializedName("apparentTemperatureLowTime")
	private int apparentTemperatureLowTime;

	@SerializedName("sunriseTime")
	private int sunriseTime;

	@SerializedName("apparentTemperatureLow")
	private double apparentTemperatureLow;

	@SerializedName("summary")
	private String summary;

	@SerializedName("precipProbability")
	private double precipProbability;

	@SerializedName("temperatureHighTime")
	private int temperatureHighTime;

	@SerializedName("visibility")
	private double visibility;

	@SerializedName("precipIntensity")
	private double precipIntensity;

	@SerializedName("cloudCover")
	private double cloudCover;

	@SerializedName("temperatureMin")
	private double temperatureMin;

	@SerializedName("apparentTemperatureHighTime")
	private int apparentTemperatureHighTime;

	@SerializedName("pressure")
	private double pressure;

	@SerializedName("dewPoint")
	private double dewPoint;

	@SerializedName("temperatureMinTime")
	private int temperatureMinTime;

	@SerializedName("uvIndexTime")
	private int uvIndexTime;

	@SerializedName("apparentTemperatureMax")
	private double apparentTemperatureMax;

	@SerializedName("temperatureHigh")
	private double temperatureHigh;

	@SerializedName("temperatureLowTime")
	private int temperatureLowTime;

	@SerializedName("apparentTemperatureHigh")
	private double apparentTemperatureHigh;

	@SerializedName("time")
	private int time;

	@SerializedName("precipIntensityMaxTime")
	private int precipIntensityMaxTime;

	@SerializedName("windGustTime")
	private int windGustTime;

	@SerializedName("uvIndex")
	private int uvIndex;

	@SerializedName("apparentTemperatureMaxTime")
	private int apparentTemperatureMaxTime;

	public void setWindGust(double windGust){
		this.windGust = windGust;
	}

	public double getWindGust(){
		return windGust;
	}

	public void setApparentTemperatureMinTime(int apparentTemperatureMinTime){
		this.apparentTemperatureMinTime = apparentTemperatureMinTime;
	}

	public int getApparentTemperatureMinTime(){
		return apparentTemperatureMinTime;
	}

	public void setTemperatureMax(double temperatureMax){
		this.temperatureMax = temperatureMax;
	}

	public double getTemperatureMax(){
		return temperatureMax;
	}

	public void setIcon(String icon){
		this.icon = icon;
	}

	public String getIcon(){
		return icon;
	}

	public void setPrecipIntensityMax(double precipIntensityMax){
		this.precipIntensityMax = precipIntensityMax;
	}

	public double getPrecipIntensityMax(){
		return precipIntensityMax;
	}

	public void setWindBearing(int windBearing){
		this.windBearing = windBearing;
	}

	public int getWindBearing(){
		return windBearing;
	}

	public void setOzone(double ozone){
		this.ozone = ozone;
	}

	public double getOzone(){
		return ozone;
	}

	public void setTemperatureMaxTime(int temperatureMaxTime){
		this.temperatureMaxTime = temperatureMaxTime;
	}

	public int getTemperatureMaxTime(){
		return temperatureMaxTime;
	}

	public void setApparentTemperatureMin(double apparentTemperatureMin){
		this.apparentTemperatureMin = apparentTemperatureMin;
	}

	public double getApparentTemperatureMin(){
		return apparentTemperatureMin;
	}

	public void setSunsetTime(int sunsetTime){
		this.sunsetTime = sunsetTime;
	}

	public int getSunsetTime(){
		return sunsetTime;
	}

	public void setTemperatureLow(double temperatureLow){
		this.temperatureLow = temperatureLow;
	}

	public double getTemperatureLow(){
		return temperatureLow;
	}

	public void setPrecipType(String precipType){
		this.precipType = precipType;
	}

	public String getPrecipType(){
		return precipType;
	}

	public void setHumidity(double humidity){
		this.humidity = humidity;
	}

	public double getHumidity(){
		return humidity;
	}

	public void setMoonPhase(double moonPhase){
		this.moonPhase = moonPhase;
	}

	public double getMoonPhase(){
		return moonPhase;
	}

	public void setWindSpeed(double windSpeed){
		this.windSpeed = windSpeed;
	}

	public double getWindSpeed(){
		return windSpeed;
	}

	public void setApparentTemperatureLowTime(int apparentTemperatureLowTime){
		this.apparentTemperatureLowTime = apparentTemperatureLowTime;
	}

	public int getApparentTemperatureLowTime(){
		return apparentTemperatureLowTime;
	}

	public void setSunriseTime(int sunriseTime){
		this.sunriseTime = sunriseTime;
	}

	public int getSunriseTime(){
		return sunriseTime;
	}

	public void setApparentTemperatureLow(double apparentTemperatureLow){
		this.apparentTemperatureLow = apparentTemperatureLow;
	}

	public double getApparentTemperatureLow(){
		return apparentTemperatureLow;
	}

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

	public void setTemperatureHighTime(int temperatureHighTime){
		this.temperatureHighTime = temperatureHighTime;
	}

	public int getTemperatureHighTime(){
		return temperatureHighTime;
	}

	public void setVisibility(double visibility){
		this.visibility = visibility;
	}

	public double getVisibility(){
		return visibility;
	}

	public void setPrecipIntensity(double precipIntensity){
		this.precipIntensity = precipIntensity;
	}

	public double getPrecipIntensity(){
		return precipIntensity;
	}

	public void setCloudCover(double cloudCover){
		this.cloudCover = cloudCover;
	}

	public double getCloudCover(){
		return cloudCover;
	}

	public void setTemperatureMin(double temperatureMin){
		this.temperatureMin = temperatureMin;
	}

	public double getTemperatureMin(){
		return temperatureMin;
	}

	public void setApparentTemperatureHighTime(int apparentTemperatureHighTime){
		this.apparentTemperatureHighTime = apparentTemperatureHighTime;
	}

	public int getApparentTemperatureHighTime(){
		return apparentTemperatureHighTime;
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

	public void setTemperatureMinTime(int temperatureMinTime){
		this.temperatureMinTime = temperatureMinTime;
	}

	public int getTemperatureMinTime(){
		return temperatureMinTime;
	}

	public void setUvIndexTime(int uvIndexTime){
		this.uvIndexTime = uvIndexTime;
	}

	public int getUvIndexTime(){
		return uvIndexTime;
	}

	public void setApparentTemperatureMax(double apparentTemperatureMax){
		this.apparentTemperatureMax = apparentTemperatureMax;
	}

	public double getApparentTemperatureMax(){
		return apparentTemperatureMax;
	}

	public void setTemperatureHigh(double temperatureHigh){
		this.temperatureHigh = temperatureHigh;
	}

	public double getTemperatureHigh(){
		return temperatureHigh;
	}

	public void setTemperatureLowTime(int temperatureLowTime){
		this.temperatureLowTime = temperatureLowTime;
	}

	public int getTemperatureLowTime(){
		return temperatureLowTime;
	}

	public void setApparentTemperatureHigh(double apparentTemperatureHigh){
		this.apparentTemperatureHigh = apparentTemperatureHigh;
	}

	public double getApparentTemperatureHigh(){
		return apparentTemperatureHigh;
	}

	public void setTime(int time){
		this.time = time;
	}

	public int getTime(){
		return time;
	}

	public void setPrecipIntensityMaxTime(int precipIntensityMaxTime){
		this.precipIntensityMaxTime = precipIntensityMaxTime;
	}

	public int getPrecipIntensityMaxTime(){
		return precipIntensityMaxTime;
	}

	public void setWindGustTime(int windGustTime){
		this.windGustTime = windGustTime;
	}

	public int getWindGustTime(){
		return windGustTime;
	}

	public void setUvIndex(int uvIndex){
		this.uvIndex = uvIndex;
	}

	public int getUvIndex(){
		return uvIndex;
	}

	public void setApparentTemperatureMaxTime(int apparentTemperatureMaxTime){
		this.apparentTemperatureMaxTime = apparentTemperatureMaxTime;
	}

	public int getApparentTemperatureMaxTime(){
		return apparentTemperatureMaxTime;
	}

	@Override
 	public String toString(){
		return 
			"DataItem{" + 
			"windGust = '" + windGust + '\'' + 
			",apparentTemperatureMinTime = '" + apparentTemperatureMinTime + '\'' + 
			",temperatureMax = '" + temperatureMax + '\'' + 
			",icon = '" + icon + '\'' + 
			",precipIntensityMax = '" + precipIntensityMax + '\'' + 
			",windBearing = '" + windBearing + '\'' + 
			",ozone = '" + ozone + '\'' + 
			",temperatureMaxTime = '" + temperatureMaxTime + '\'' + 
			",apparentTemperatureMin = '" + apparentTemperatureMin + '\'' + 
			",sunsetTime = '" + sunsetTime + '\'' + 
			",temperatureLow = '" + temperatureLow + '\'' + 
			",precipType = '" + precipType + '\'' + 
			",humidity = '" + humidity + '\'' + 
			",moonPhase = '" + moonPhase + '\'' + 
			",windSpeed = '" + windSpeed + '\'' + 
			",apparentTemperatureLowTime = '" + apparentTemperatureLowTime + '\'' + 
			",sunriseTime = '" + sunriseTime + '\'' + 
			",apparentTemperatureLow = '" + apparentTemperatureLow + '\'' + 
			",summary = '" + summary + '\'' + 
			",precipProbability = '" + precipProbability + '\'' + 
			",temperatureHighTime = '" + temperatureHighTime + '\'' + 
			",visibility = '" + visibility + '\'' + 
			",precipIntensity = '" + precipIntensity + '\'' + 
			",cloudCover = '" + cloudCover + '\'' + 
			",temperatureMin = '" + temperatureMin + '\'' + 
			",apparentTemperatureHighTime = '" + apparentTemperatureHighTime + '\'' + 
			",pressure = '" + pressure + '\'' + 
			",dewPoint = '" + dewPoint + '\'' + 
			",temperatureMinTime = '" + temperatureMinTime + '\'' + 
			",uvIndexTime = '" + uvIndexTime + '\'' + 
			",apparentTemperatureMax = '" + apparentTemperatureMax + '\'' + 
			",temperatureHigh = '" + temperatureHigh + '\'' + 
			",temperatureLowTime = '" + temperatureLowTime + '\'' + 
			",apparentTemperatureHigh = '" + apparentTemperatureHigh + '\'' + 
			",time = '" + time + '\'' + 
			",precipIntensityMaxTime = '" + precipIntensityMaxTime + '\'' + 
			",windGustTime = '" + windGustTime + '\'' + 
			",uvIndex = '" + uvIndex + '\'' + 
			",apparentTemperatureMaxTime = '" + apparentTemperatureMaxTime + '\'' + 
			"}";
		}
}