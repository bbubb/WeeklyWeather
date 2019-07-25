package what.is.weeklyweather.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import what.is.weeklyweather.pojos.pojos.CurrentEntry;
import what.is.weeklyweather.repositories.CurrentWeatherRepository;

public class VmCurrentWeather extends AndroidViewModel {
    private static final String TAG = VmCurrentWeather.class.getSimpleName();
    private CurrentWeatherRepository mRepository;
    private LiveData<List<CurrentEntry>> mAllCurrentEntries;


    public VmCurrentWeather(@NonNull Application application) {
        super(application);
        mRepository = new CurrentWeatherRepository(application);
        mAllCurrentEntries = mRepository.getAllCurrentWeatherEntries();
    }

    LiveData<List<CurrentEntry>> getAllCurrentEntries(){return mAllCurrentEntries;}

    public void insert(CurrentEntry currentWeatherEntry){mRepository.insert(currentWeatherEntry);}
}
