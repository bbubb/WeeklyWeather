package what.is.weeklyweather;

import what.is.weeklyweather.currentweatherpojo.WeatherResponse;

public class EventWeatherResponse {
    public final WeatherResponse weatherResponse;

    public EventWeatherResponse(WeatherResponse weatherResponse) {
        this.weatherResponse = weatherResponse;
    }
}
