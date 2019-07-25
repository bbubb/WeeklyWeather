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
import what.is.weeklyweather.adapters.ForecastAdapter;
import what.is.weeklyweather.adapters.HourlyAdapter;
import what.is.weeklyweather.database.CurrentWeatherDatabase;
import what.is.weeklyweather.database.ForecastDatabase;
import what.is.weeklyweather.database.HourlyDatabase;
import what.is.weeklyweather.events.EventWeatherResponse;

import what.is.weeklyweather.pojos.pojos.CurrentEntry;
import what.is.weeklyweather.pojos.pojos.ForecastEntry;
import what.is.weeklyweather.pojos.pojos.HourlyEntry;
import what.is.weeklyweather.pojos.pojos.responses.CurrentDarkSkyResponse;
import what.is.weeklyweather.pojos.pojos.responses.ForecastDarkSkyResponse;
import what.is.weeklyweather.pojos.pojos.responses.HourlyDarkSkyResponse;
import what.is.weeklyweather.pojos.pojos.responses.responsepojos.hourly.DataItem;
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
    private AppExecutors roomExecutor;
    private CurrentWeatherDatabase mDbCurrently;
    private ForecastDatabase mDbForecast;
    private HourlyDatabase mDbHourly;


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
        hourlyRecycler.setLayoutManager(new LinearLayoutManager(hourlyRecycler.getContext(), LinearLayoutManager.HORIZONTAL, false ));
        hourlyRecycler.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        hourlyRecycler.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL));
        hourlyRecycler.setHasFixedSize(true);
}

    private void setForecastRecycler(){
        forecastRecycler.setLayoutManager(new LinearLayoutManager(forecastRecycler.getContext(), LinearLayoutManager.VERTICAL, false));
        forecastRecycler.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        forecastRecycler.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL));
        forecastRecycler.setHasFixedSize(true);
    }

    private void loadForecastRecycler (List<what.is.weeklyweather.pojos.pojos.responses.responsepojos.forecast.DataItem> forecastDays){
        ForecastAdapter forecastAdapter = new ForecastAdapter(forecastDays);
        forecastRecycler.setAdapter(forecastAdapter);
    }

    private void loadHourlyRecycler (List<DataItem> hour){
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
                   final CurrentEntry currentEntry = new CurrentEntry(response.body().getCurrently() );
                   roomExecutor.getDiskId().execute(new Runnable() {
                       @Override
                       public void run() {
                           mDbCurrently.currentWeatherDAO().insert(currentEntry);
                       }
                   });
                    EventBus.getDefault().post(new EventWeatherResponse(currentEntry));
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
                    final ForecastEntry forecastEntry = new ForecastEntry(response.body().getDaily().getData());
                    roomExecutor.getDiskId().execute(new Runnable() {
                        @Override
                        public void run() {mDbForecast.forecastDAO().insert(forecastEntry);}
                    });
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
                    final HourlyEntry hourlyEntry = new HourlyEntry(response.body().getHourly().getData());
                    roomExecutor.getDiskId().execute(new Runnable() {
                        @Override
                        public void run() {mDbHourly.hourlyDAO().insert(hourlyEntry);}
                    });
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
