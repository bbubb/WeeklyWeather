package what.is.weeklyweather;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import what.is.weeklyweather.currentweatherpojo.WeatherResponse;

public class CurrentWeatherFrag extends Fragment {
    Unbinder unbinder;
    private static final String TAG = "CurrentWeatherFrag";
    WeatherResponse mWeatherResponse;
    @BindView(R.id.tv_current_date)
    TextView tvCurrentDate;
    @BindView(R.id.tv_current_temp)
    TextView tvCurrentTemp;
    @BindView(R.id.tv_humidity)
    TextView tvHumidity;
    @BindView(R.id.tv_current_weather_info)
    TextView tvCurrentWeatherInfo;
    @BindView(R.id.tv_current_chance_of_precipitation)
    TextView tvCurrentPrecipitation;

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
    public void onEventWeatherResponse(EventWeatherResponse eventWeatherResponse){
        Log.d(TAG, "onEventWeatherResponse: WeatherResponse Received");
        mWeatherResponse = eventWeatherResponse.weatherResponse;
//        tvCurrentWeatherInfo = mWeatherResponse.getWeather().get().getDescription();
        double temp = mWeatherResponse.getMain().getTemp();
        String strTemp = String.valueOf(Math.round(temp));
        tvCurrentTemp.setText(strTemp);
        Toast.makeText(getContext(), strTemp, Toast.LENGTH_SHORT).show();
        tvHumidity.setText(String.valueOf(mWeatherResponse.getMain().getHumidity())+"%");
        tvCurrentPrecipitation.setText(String.valueOf(mWeatherResponse.getRain())+"%");

    }

    @Override
    public void onDetach() {
        EventBus.getDefault().unregister(this);
        unbinder.unbind();
        super.onDetach();
    }
}
