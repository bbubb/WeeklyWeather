package what.is.weeklyweather.events;

import what.is.weeklyweather.pojos.pojos.CurrentEntry;

public class EventWeatherResponse {
    public final CurrentEntry weatherResponse;

    public EventWeatherResponse(CurrentEntry weatherResponse) {
        this.weatherResponse = weatherResponse;
    }
}
