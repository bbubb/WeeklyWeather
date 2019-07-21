package what.is.weeklyweather;

import what.is.weeklyweather.forecastdarksky.ForecastDarkSkyResponse;

public class EventForecastResponse {
    public final ForecastDarkSkyResponse forecastResponse;

    public EventForecastResponse(ForecastDarkSkyResponse forecastResponse) {
        this.forecastResponse = forecastResponse;
    }
}
