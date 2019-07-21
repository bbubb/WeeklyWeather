package what.is.weeklyweather.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import what.is.weeklyweather.currentdarksky.CurrentDarkSkyResponse;
import what.is.weeklyweather.forecastdarksky.ForecastDarkSkyResponse;

public interface WeatherService {

    @GET("/forecast/a7a790212f6a24d9a64f2d8cd0022deb/39.9517178,-75.1703913")
    Call<CurrentDarkSkyResponse> loadCurrentDarkSkyService(@Query("exclude") String excludes);

    @GET("/forecast/a7a790212f6a24d9a64f2d8cd0022deb/39.9517178,-75.1703913")
    Call<ForecastDarkSkyResponse> loadForecastDarkSkyService(@Query("exclude") String excludes);
}