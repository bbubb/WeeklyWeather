package what.is.weeklyweather;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import org.greenrobot.eventbus.EventBus;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import what.is.weeklyweather.currentweatherpojo.WeatherResponse;
import what.is.weeklyweather.fivedayforecastpojo.ForecastResponse;
import what.is.weeklyweather.retrofit.RetrofitOpenWeatherClient;
import what.is.weeklyweather.retrofit.WeatherService;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private String key = "bc5d9b52c7459f5d48d7ff545603b6e2", city = "Philadelphia", unitTypes = "Imperial";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        retrofitCurrentWeatherRequest();
        retrofitForecastRequest();
        CurrentWeatherFrag currentWeatherFrag = new CurrentWeatherFrag();
        loadFragment(R.id.frame_current_forecast, currentWeatherFrag, "Current Weather");
        FiveDayForecastFrag fiveDayForecastFrag = new FiveDayForecastFrag();
        loadFragment(R.id.frame_5day_forecast, fiveDayForecastFrag, "5 Day Forecast");



    }

    public void retrofitCurrentWeatherRequest() {
        WeatherService currentWeatherService = RetrofitOpenWeatherClient.getRetrofit().create(WeatherService.class);
        Call<WeatherResponse> currentWeatherCall = currentWeatherService.loadCurrentForecastService(key, city, unitTypes);
        currentWeatherCall.enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                if(response.isSuccessful()){
                    Log.d(TAG, "onResponse: "+response.body().getName());
                    EventBus.getDefault().post(new EventWeatherResponse(response.body()));

                } else {
                    Log.d(TAG, "onResponse: Failure");
                }
            }
            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: "+ t.getLocalizedMessage());
            }
        });
    }

    public void retrofitForecastRequest(){
        WeatherService forecastWeatherService = RetrofitOpenWeatherClient.getRetrofit().create(WeatherService.class);
        Call<ForecastResponse> forecastWeatherCall = forecastWeatherService.loadFiveDayForecastService(key, city, unitTypes);
        forecastWeatherCall.enqueue(new Callback<ForecastResponse>() {
            @Override
            public void onResponse(Call<ForecastResponse> call, Response<ForecastResponse> response) {
                if (response.isSuccessful()){
                    Log.d(TAG, "onResponse: Success");
                    EventBus.getDefault().post(new EventForecastResponse(response.body()));
                }else {
                    Log.d(TAG, "onResponse: Failure");
                }
            }

            @Override
            public void onFailure(Call<ForecastResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: "+ t.getLocalizedMessage());

            }
        });
    }

//    private void loadForecastViews(List<Objects> forecasts) {
//        forecastAdapter = new ForecastAdapter(forecasts, MainActivity.this);
//        forecastsView.setAdapter(forecastAdapter);
//    }

    private void loadFragment(int frameLayout, Fragment fragment, String tag) {
        getSupportFragmentManager().beginTransaction().add(frameLayout, fragment, tag).commit();
    }
}
