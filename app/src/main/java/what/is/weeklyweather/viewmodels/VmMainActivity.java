package what.is.weeklyweather.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import what.is.weeklyweather.pojos.pojos.ForecastEntry;
import what.is.weeklyweather.pojos.pojos.HourlyEntry;
import what.is.weeklyweather.repositories.ForecastRepository;
import what.is.weeklyweather.repositories.HourlyRepository;

public class VmMainActivity extends AndroidViewModel {

    private static final String TAG = VmMainActivity.class.getSimpleName();
    private ForecastRepository mForecastRepository;
    private HourlyRepository mHourlyRepository;
    private LiveData<List<ForecastEntry>> mAllForecastEntries;
    private LiveData<List<HourlyEntry>> mAllhourlyEntries;


    public VmMainActivity(@NonNull Application application) {
        super(application);
        mForecastRepository = new ForecastRepository(application);
        mAllForecastEntries = mForecastRepository.getAllForecastEntries();
        mHourlyRepository = new HourlyRepository(application);
        mAllhourlyEntries = mHourlyRepository.getAllHourlyEntries();
    }

     public LiveData<List<ForecastEntry>> getAllForecastEntries(){return mAllForecastEntries;}
    public void insert(ForecastEntry forecastEntry){mForecastRepository.insert(forecastEntry);}

    public  LiveData<List<HourlyEntry>> getAllHourlyEntries(){return mAllhourlyEntries;}
    public void insert(HourlyEntry hourlyEntry){mHourlyRepository.insert(hourlyEntry);}
}
