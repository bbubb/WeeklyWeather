package what.is.weeklyweather.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import what.is.weeklyweather.database.WeatherDatabase;
import what.is.weeklyweather.pojos.pojos.ForecastEntry;
import what.is.weeklyweather.pojos.pojos.HourlyEntry;
import what.is.weeklyweather.repositories.ForecastRepository;
import what.is.weeklyweather.repositories.HourlyRepository;

public class VmMainActivity extends ViewModel {

    private static final String TAG = VmMainActivity.class.getSimpleName();
    private ForecastRepository mForecastRepository;
    private HourlyRepository mHourlyRepository;
    private LiveData<List<ForecastEntry>> mAllForecastEntries;
    private LiveData<ForecastEntry> mForecastEntry;
    private LiveData<List<HourlyEntry>> mAllhourlyEntries;
    private LiveData<HourlyEntry> mHourlyEntry;


    public VmMainActivity(@NonNull int dataId, @NonNull WeatherDatabase db){
        mForecastRepository = new ForecastRepository(dataId, db);
        mForecastEntry = mForecastRepository.getForecastEntryLiveData();
        mAllForecastEntries = mForecastRepository.getAllForecastEntries();
        mHourlyRepository = new HourlyRepository(dataId, db);
        mHourlyEntry = mHourlyRepository.getHourlyEntry();
        mAllhourlyEntries = mHourlyRepository.getAllHourlyEntries();
    }

     public LiveData<List<ForecastEntry>> getAllForecastEntries(){return mAllForecastEntries;}
     public LiveData<ForecastEntry> getForecastEntry(){return mForecastEntry;}
    public void insert(ForecastEntry forecastEntry){mForecastRepository.insert(forecastEntry);}

    public  LiveData<List<HourlyEntry>> getAllHourlyEntries(){return mAllhourlyEntries;}
    public LiveData<HourlyEntry> getHourlyEntry(){return mHourlyEntry;}
    public void insert(HourlyEntry hourlyEntry){mHourlyRepository.insert(hourlyEntry);}

}
