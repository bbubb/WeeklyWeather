package what.is.weeklyweather.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import what.is.weeklyweather.pojos.pojos.responses.CurrentDarkSkyResponse;
import what.is.weeklyweather.pojos.pojos.responses.ForecastDarkSkyResponse;
import what.is.weeklyweather.pojos.pojos.responses.HourlyDarkSkyResponse;

public interface WeatherService {

    @GET("/forecast/a7a790212f6a24d9a64f2d8cd0022deb/{loc}/")
    Call<CurrentDarkSkyResponse> loadCurrentDarkSkyService(@Path(value="loc", encoded = true) String loc, @Query("exclude") String exclude);

    @GET("/forecast/a7a790212f6a24d9a64f2d8cd0022deb/{loc}/")
    Call<ForecastDarkSkyResponse> loadForecastDarkSkyService(@Path(value="loc", encoded = true) String loc, @Query("exclude") String exclude);

    @GET("/forecast/a7a790212f6a24d9a64f2d8cd0022deb/{loc}/")
    Call<HourlyDarkSkyResponse> loadHourlyDarkSkyService(@Path(value="loc", encoded = true) String loc, @Query("exclude") String exclude);

}