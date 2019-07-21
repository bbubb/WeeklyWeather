package what.is.weeklyweather;

import what.is.weeklyweather.currentdarksky.CurrentDarkSkyResponse;

public class EventWeatherResponse {
    public final CurrentDarkSkyResponse weatherResponse;

    public EventWeatherResponse(CurrentDarkSkyResponse weatherResponse) {
        this.weatherResponse = weatherResponse;
    }
}
