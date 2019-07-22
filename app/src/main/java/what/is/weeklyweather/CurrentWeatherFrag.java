package what.is.weeklyweather;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import what.is.weeklyweather.currentdarksky.CurrentDarkSkyResponse;

public class CurrentWeatherFrag extends Fragment {
    Unbinder unbinder;
    private static final String TAG = "CurrentWeatherFrag";
    CurrentDarkSkyResponse mWeatherResponse;
    @BindView(R.id.tv_current_date)
    TextView tvCurrentDate;
    @BindView(R.id.tv_current_temp)
    TextView tvCurrentTemp;
    @BindView(R.id.tv_humidity)
    TextView tvHumidity;
    @BindView(R.id.tv_current_weather_info)
    TextView tvCurrentWeatherInfo;
    @BindView(R.id.tv_precipitation)
    TextView tvRainRate;
    @BindView(R.id.tv_wind)
    TextView tvWindSpeed;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        EventBus.getDefault().register(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.current_weather_layout, container, false);
        unbinder = ButterKnife.bind(this, v);

        return v;
    }

    @Subscribe
    public void onEventWeatherResponse(EventWeatherResponse eventWeatherResponse) {
        Log.d(TAG, "onEventWeatherResponse: WeatherResponse Received");
        mWeatherResponse = eventWeatherResponse.weatherResponse;
        String date = (android.text.format.DateFormat.format("E, dd MM", new Date((long)(mWeatherResponse.getCurrently().getTime()) * (long) 1000)).toString().toUpperCase());
        Log.d(TAG, "onEventWeatherResponse: "+ date);
        tvCurrentDate.setText(date);
        tvCurrentWeatherInfo.setText(mWeatherResponse.getCurrently().getSummary());
        tvCurrentTemp.setText(String.valueOf(Math.round(mWeatherResponse.getCurrently().getTemperature())) + "°");
        tvRainRate.setText(String.valueOf(Math.round((mWeatherResponse.getCurrently().getPrecipProbability()) * 100)) + "%");
        tvWindSpeed.setText(String.valueOf(Math.round(mWeatherResponse.getCurrently().getWindSpeed())) + " km/h");
        tvHumidity.setText(String.valueOf(Math.round((mWeatherResponse.getCurrently().getHumidity()) * 100)) + "%");
    }

    @Override
    public void onDetach() {
        EventBus.getDefault().unregister(this);
        unbinder.unbind();
        super.onDetach();
    }
}
