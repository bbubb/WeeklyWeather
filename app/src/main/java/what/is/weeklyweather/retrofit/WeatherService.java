package what.is.weeklyweather.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import what.is.weeklyweather.currentweatherpojo.WeatherResponse;
import what.is.weeklyweather.fivedayforecastpojo.ForecastResponse;

public interface WeatherService {

    @GET("/data/2.5/forecast?")
    Call<ForecastResponse> loadFiveDayForecastService(@Query("APPID") String key, @Query("q") String city, @Query("units") String unitType);

    @GET("/data/2.5/weather?")
    Call<WeatherResponse> loadCurrentForecastService(@Query("APPID") String key, @Query("q") String city, @Query("units") String unitType);

}
