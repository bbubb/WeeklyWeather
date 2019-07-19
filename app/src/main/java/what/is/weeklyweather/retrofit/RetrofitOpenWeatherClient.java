package what.is.weeklyweather.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitOpenWeatherClient {
    public static final String BASE_URL = "api.openweathermap.org/";

    private static Retrofit retrofit;

    private RetrofitOpenWeatherClient() {
    }

    public static Retrofit getRetrofit(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
