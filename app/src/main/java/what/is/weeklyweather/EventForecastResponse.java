package what.is.weeklyweather;

import what.is.weeklyweather.fivedayforecastpojo.ForecastResponse;

public class EventForecastResponse {
    public final ForecastResponse forecastResponse;

    public EventForecastResponse(ForecastResponse forecastResponse) {
        this.forecastResponse = forecastResponse;
    }
}
