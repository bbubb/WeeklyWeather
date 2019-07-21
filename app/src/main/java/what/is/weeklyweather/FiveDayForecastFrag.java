package what.is.weeklyweather;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import what.is.weeklyweather.forecastdarksky.ForecastDarkSkyResponse;

public class FiveDayForecastFrag extends Fragment {
    private static final String TAG = "FiveDayForecastFrag";
    Unbinder unbinder;
    ForecastAdapter forecastAdapter;
    ForecastDarkSkyResponse forecastDarkSkyResponse;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        EventBus.getDefault().register(this);
    }

    @Subscribe
    public void onEventForecastResponse(EventForecastResponse eventForecastResponse){
        Log.d(TAG, "onEventForecastResponse: ");
        forecastDarkSkyResponse = eventForecastResponse.forecastResponse;

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.main_layout, container, false);
        unbinder = ButterKnife.bind(this, v);
        return v;
    }

    @Override
    public void onDetach() {
        EventBus.getDefault().unregister(this);
        super.onDetach();
        unbinder.unbind();
    }
}
