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
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import what.is.weeklyweather.pojos.pojos.CurrentEntry;
import what.is.weeklyweather.pojos.pojos.responses.responsepojos.Currently;
import what.is.weeklyweather.viewmodels.VmCurrentWeather;

public class CurrentWeatherFrag extends Fragment {
    Unbinder unbinder;
    private static final String TAG = "CurrentWeatherFrag";
     Currently mWeatherResponse;
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
    VmCurrentWeather vmCurrentWeather;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.current_weather_layout, container, false);
        unbinder = ButterKnife.bind(this, v);

        vmCurrentWeather = ViewModelProviders.of(this).get(VmCurrentWeather.class);
        vmCurrentWeather.getAllCurrentEntries().observe(this, new Observer<List<CurrentEntry>>() {
            @Override
            public void onChanged(List<CurrentEntry> allCurrentEntries) {
                mWeatherResponse = allCurrentEntries.get(0).getCurrently();
                String date = (android.text.format.DateFormat.format("E, dd MMM", new Date((long)(mWeatherResponse.getTime()) * (long) 1000)).toString());
                Log.d(TAG, "onEventWeatherResponse: "+ date);
                tvCurrentDate.setText(date);
                tvCurrentWeatherInfo.setText(mWeatherResponse.getSummary());
                tvCurrentTemp.setText(String.valueOf(Math.round(mWeatherResponse.getTemperature())) + "°");
                tvRainRate.setText(String.valueOf(Math.round((mWeatherResponse.getPrecipProbability()) * 100)) + "%");
                tvWindSpeed.setText(String.valueOf(Math.round(mWeatherResponse.getWindSpeed())) + " m/h");
                tvHumidity.setText(String.valueOf(Math.round((mWeatherResponse.getHumidity()) * 100)) + "%");
            }
        });
        return v;
    }


    @Override
    public void onDetach() {
        unbinder.unbind();
        super.onDetach();
    }
}
