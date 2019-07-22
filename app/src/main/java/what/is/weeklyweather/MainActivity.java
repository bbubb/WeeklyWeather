package what.is.weeklyweather;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
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
import what.is.weeklyweather.retrofit.RetrofitDarkSkyClient;
import what.is.weeklyweather.retrofit.WeatherService;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private String currentExclude="minutely,hourly,daily,alerts,flags", forecastExclude="currently,minutely,hourly,alerts,flags";
    @BindView(R.id.rv_5day_forecast) RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        ButterKnife.bind(this);
        CurrentWeatherFrag currentWeatherFrag = new CurrentWeatherFrag();
        loadFragment(R.id.frame_current_forecast, currentWeatherFrag, "Current Weather");

        retrofitCurrentDarkSkyRequest();
        retrofitForecastDarkSkyRequest();

        setRecyclerView();
//        FiveDayForecastFrag fiveDayForecastFrag = new FiveDayForecastFrag();
//        loadFragment(R.id., fiveDayForecastFrag, "5 Day Forecast");

    }

    private void setRecyclerView(){
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL));
        recyclerView.setHasFixedSize(true);
    }

    private void loadRecyclerView (List<DataItem> forecastDays){
        ForecastAdapter forecastAdapter = new ForecastAdapter(forecastDays);
        recyclerView.setAdapter(forecastAdapter);
    }

    public void retrofitCurrentDarkSkyRequest(){
        WeatherService currentDarkSkyService = RetrofitDarkSkyClient.getRetrofit().create(WeatherService.class);
        Call<CurrentDarkSkyResponse> currentDarkSkyResponseCall = currentDarkSkyService.loadCurrentDarkSkyService(currentExclude);
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
        Call<ForecastDarkSkyResponse> forecastDarkSkyResponseCall = forecastDarkSkyService.loadForecastDarkSkyService(forecastExclude);
        forecastDarkSkyResponseCall.enqueue(new Callback<ForecastDarkSkyResponse>() {
            @Override
            public void onResponse(Call<ForecastDarkSkyResponse> call, Response<ForecastDarkSkyResponse> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "onResponse: Success");
                    loadRecyclerView(response.body().getDaily().getData());

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

    private void loadFragment(int frameLayout, Fragment fragment, String tag) {
        getSupportFragmentManager().beginTransaction().add(frameLayout, fragment, tag).commit();
    }
}
