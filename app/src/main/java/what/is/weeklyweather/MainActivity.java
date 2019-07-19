package what.is.weeklyweather;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
    CurrentWeatherFrag currentWeatherFrag;
    FiveDayForecastFrag fiveDayForecastFrag;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        currentWeatherFrag = new CurrentWeatherFrag();
        loadFragment(R.id.frame_current_forecast, currentWeatherFrag, "Current Weather");
        fiveDayForecastFrag = new FiveDayForecastFrag();
        loadFragment(R.id.frame_5day_forecast, fiveDayForecastFrag, "5 Day Forecast");

    }

    private void loadFragment(int frameLayout, Fragment fragment, String tag){
        getSupportFragmentManager().beginTransaction().add(frameLayout, fragment, tag).commit();
    }
}
