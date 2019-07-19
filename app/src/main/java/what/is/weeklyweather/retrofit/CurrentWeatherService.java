package what.is.weeklyweather.retrofit;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CurrentWeatherService {


    @GET("data/2.5/weather")
    Call<List<Objects>> loadCurrentForecastService(@Query("APPID") String key, @Query("q") String city, @Query("units") String unitType);
}

//String key = "bc5d9b52c7459f5d48d7ff545603b6e2";
//String city = "Philadelphia";
//String unitTypes = "Imperial";
