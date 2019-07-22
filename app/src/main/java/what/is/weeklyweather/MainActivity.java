package what.is.weeklyweather;

import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import what.is.weeklyweather.currentdarksky.CurrentDarkSkyResponse;
import what.is.weeklyweather.forecastdarksky.DataItem;
import what.is.weeklyweather.forecastdarksky.ForecastDarkSkyResponse;
import what.is.weeklyweather.hourlydarksky.HourlyDarkSkyResponse;
import what.is.weeklyweather.retrofit.RetrofitDarkSkyClient;
import what.is.weeklyweather.retrofit.WeatherService;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private String currentExclude = "minutely,hourly,daily,alerts,flags", forecastExclude = "currently,minutely,hourly,alerts,flags", hourlyExclude = "currently,minutely,daily,alerts,flags";
    @BindView(R.id.rv_forecast)
    RecyclerView forecastRecycler;
    @BindView(R.id.rv_hourly)
    RecyclerView hourlyRecycler;
    private String lng, lat, loc;
    private Location location;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        ButterKnife.bind(this);

        lng = getIntent().getStringExtra("lng");
        lat = getIntent().getStringExtra("lat");
        loc = lat+","+lng;
        Toast.makeText(this, loc, Toast.LENGTH_LONG).show();
        CurrentWeatherFrag currentWeatherFrag = new CurrentWeatherFrag();
        loadFragment(R.id.frame_current_forecast, currentWeatherFrag, "Current Weather");

        retrofitCurrentDarkSkyRequest();
        retrofitForecastDarkSkyRequest();
        retrofitHourlyDarkSkyRequest();

        setHourlyRecycler();
        setForecastRecycler();
    }

    private void setHourlyRecycler(){
        hourlyRecycler.setLayoutManager(new LinearLayoutManager(hourlyRecycler.getContext(), RecyclerView.VERTICAL, false ));
        hourlyRecycler.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        hourlyRecycler.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL));
        hourlyRecycler.setHasFixedSize(true);
}

    private void setForecastRecycler(){
        forecastRecycler.setLayoutManager(new LinearLayoutManager(forecastRecycler.getContext(), RecyclerView.HORIZONTAL, false));
        forecastRecycler.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        forecastRecycler.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL));
        forecastRecycler.setHasFixedSize(true);
    }

    private void loadForecastRecycler (List<DataItem> forecastDays){
        ForecastAdapter forecastAdapter = new ForecastAdapter(forecastDays);
        forecastRecycler.setAdapter(forecastAdapter);
    }

    private void loadHourlyRecycler (List<what.is.weeklyweather.hourlydarksky.DataItem> hour){
        HourlyAdapter hourlyAdapter = new HourlyAdapter(hour);
        hourlyRecycler.setAdapter(hourlyAdapter);
    }

    public void retrofitCurrentDarkSkyRequest(){
        WeatherService currentDarkSkyService = RetrofitDarkSkyClient.getRetrofit().create(WeatherService.class);
        Call<CurrentDarkSkyResponse> currentDarkSkyResponseCall = currentDarkSkyService.loadCurrentDarkSkyService(loc,currentExclude);
        currentDarkSkyResponseCall.enqueue(new Callback<CurrentDarkSkyResponse>() {
            @Override
            public void onResponse(Call<CurrentDarkSkyResponse> call, Response<CurrentDarkSkyResponse> response) {
                if(response.isSuccessful()){
                    Log.d(TAG, "onResponse: Success");
                    EventBus.getDefault().post(new EventWeatherResponse(response.body()));
                }else{
                    Log.d(TAG, "onResponse: Failure");
                }
            }

            @Override
            public void onFailure(Call<CurrentDarkSkyResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: "+ t.getLocalizedMessage());
            }
        });

    }

    public void  retrofitForecastDarkSkyRequest(){
        WeatherService forecastDarkSkyService = RetrofitDarkSkyClient.getRetrofit().create(WeatherService.class);
        Call<ForecastDarkSkyResponse> forecastDarkSkyResponseCall = forecastDarkSkyService.loadForecastDarkSkyService(loc,forecastExclude);
        forecastDarkSkyResponseCall.enqueue(new Callback<ForecastDarkSkyResponse>() {
            @Override
            public void onResponse(Call<ForecastDarkSkyResponse> call, Response<ForecastDarkSkyResponse> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "onResponse: Success");
                    loadForecastRecycler(response.body().getDaily().getData());

                }else {
                    Log.d(TAG, "onResponse: Failure");
                }
            }

            @Override
            public void onFailure(Call<ForecastDarkSkyResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: "+ t.getLocalizedMessage());

            }
        });

    }

    public void retrofitHourlyDarkSkyRequest(){
        WeatherService hourlyDarkSkyService = RetrofitDarkSkyClient.getRetrofit().create(WeatherService.class);
        Call<HourlyDarkSkyResponse> hourlyDarkSkyResponseCall = hourlyDarkSkyService.loadHourlyDarkSkyService(loc,hourlyExclude);
        hourlyDarkSkyResponseCall.enqueue(new Callback<HourlyDarkSkyResponse>() {
            @Override
            public void onResponse(Call<HourlyDarkSkyResponse> call, Response<HourlyDarkSkyResponse> response) {
                if(response.isSuccessful()){
                    Log.d(TAG, "onResponse: Success");
                    loadHourlyRecycler(response.body().getHourly().getData());
                } else {
                    Log.d(TAG, "onResponse: Failure");
                }
            }

            @Override
            public void onFailure(Call<HourlyDarkSkyResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: "+t.getLocalizedMessage());

            }
        });
    }

    private void loadFragment(int frameLayout, Fragment fragment, String tag) {
        getSupportFragmentManager().beginTransaction().add(frameLayout, fragment, tag).commit();
    }
}
