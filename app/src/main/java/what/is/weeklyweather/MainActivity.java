package what.is.weeklyweather;

import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import what.is.weeklyweather.adapters.ForecastAdapter;
import what.is.weeklyweather.adapters.HourlyAdapter;
import what.is.weeklyweather.database.WeatherDatabase;
import what.is.weeklyweather.pojos.pojos.CurrentEntry;
import what.is.weeklyweather.pojos.pojos.ForecastEntry;
import what.is.weeklyweather.pojos.pojos.HourlyEntry;
import what.is.weeklyweather.pojos.pojos.responses.CurrentDarkSkyResponse;
import what.is.weeklyweather.pojos.pojos.responses.ForecastDarkSkyResponse;
import what.is.weeklyweather.pojos.pojos.responses.HourlyDarkSkyResponse;
import what.is.weeklyweather.pojos.pojos.responses.responsepojos.hourly.DataItem;
import what.is.weeklyweather.retrofit.RetrofitDarkSkyClient;
import what.is.weeklyweather.retrofit.WeatherService;
import what.is.weeklyweather.viewmodels.VmCurrentWeather;
import what.is.weeklyweather.viewmodels.VmMainActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private String currentExclude = "minutely,hourly,daily,alerts,flags", forecastExclude = "currently,minutely,hourly,alerts,flags", hourlyExclude = "currently,minutely,daily,alerts,flags";
    @BindView(R.id.rv_forecast)
    RecyclerView forecastRecycler;
    @BindView(R.id.rv_hourly)
    RecyclerView hourlyRecycler;
    private String lng = "-75.1704", lat = "39.9517", loc;
    private Location location;
    private AppExecutors roomExecutor;
    private WeatherDatabase mWeatherDb;
    private VmCurrentWeather vmCurrentWeather;
    private VmMainActivity vmMainActivity;
    private ForecastAdapter forecastAdapter;
    private HourlyAdapter hourlyAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        ButterKnife.bind(this);

//        lng = getIntent().getStringExtra("lng");
//        lat = getIntent().getStringExtra("lat");
        loc = lat+","+lng;
        Toast.makeText(this, loc, Toast.LENGTH_LONG).show();
        CurrentWeatherFrag currentWeatherFrag = new CurrentWeatherFrag();
        loadFragment(R.id.frame_current_forecast, currentWeatherFrag, "Current Weather");

        retrofitCurrentDarkSkyRequest();
        retrofitForecastDarkSkyRequest();
        retrofitHourlyDarkSkyRequest();

        vmMainActivity = ViewModelProviders.of(this).get(VmMainActivity.class);
        vmMainActivity.getAllForecastEntries().observe(this, new Observer<List<ForecastEntry>>() {
            @Override
            public void onChanged(List<ForecastEntry> forecastEntries) {
                forecastAdapter.setItems(forecastEntries.get(0).getForecastList());
            }
        });

        vmMainActivity.getAllHourlyEntries().observe(this, new Observer<List<HourlyEntry>>() {
            @Override
            public void onChanged(List<HourlyEntry> hourlyEntries) {
                hourlyAdapter.setItems(hourlyEntries.get(0).getHourlyList());
            }
        });


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
       forecastAdapter = new ForecastAdapter(forecastDays);
        forecastRecycler.setAdapter(forecastAdapter);
    }

    private void loadHourlyRecycler (List<DataItem> hour){
        hourlyAdapter = new HourlyAdapter(hour);
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
                           mWeatherDb.currentWeatherDAO().insert(currentEntry);
                       }
                   });
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
                        public void run() {mWeatherDb.forecastDAO().insert(forecastEntry);}
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
                        public void run() {mWeatherDb.hourlyDAO().insert(hourlyEntry);}
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
