package what.is.weeklyweather.events;

import what.is.weeklyweather.pojos.pojos.responses.ForecastDarkSkyResponse;

public class EventForecastResponse {
    public final ForecastDarkSkyResponse forecastResponse;

    public EventForecastResponse(ForecastDarkSkyResponse forecastResponse) {
        this.forecastResponse = forecastResponse;
    }
}
