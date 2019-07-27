package what.is.weeklyweather.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import what.is.weeklyweather.AppExecutors;
import what.is.weeklyweather.database.WeatherDatabase;
import what.is.weeklyweather.database.dao.CurrentWeatherDAO;
import what.is.weeklyweather.pojos.pojos.CurrentEntry;

public class CurrentWeatherRepository {

    private CurrentWeatherDAO mCurrentWeatherDao;
    private LiveData<List<CurrentEntry>> mAllCurrentWeatherEntries;

    public CurrentWeatherRepository(Application application) {
        WeatherDatabase db = WeatherDatabase.getDatabase(application);
        mCurrentWeatherDao = db.currentWeatherDAO();
        mAllCurrentWeatherEntries = mCurrentWeatherDao.getAllCurrentWeatherEntries();
    }

    public LiveData<List<CurrentEntry>> getAllCurrentWeatherEntries() {
        return mAllCurrentWeatherEntries;
    }

    public void update(CurrentEntry currentEntry){
        AppExecutors.getInstance().getDiskId().execute(new Runnable() {
            @Override
            public void run() {mCurrentWeatherDao.update(currentEntry);}
        });
    }

    public void delete(CurrentEntry currentEntry){
        AppExecutors.getInstance().getDiskId().execute(new Runnable() {
            @Override
            public void run() {
                mCurrentWeatherDao.delete(currentEntry);
            }
        });
    }

    public void insert(CurrentEntry currentWeatherEntry) {
        AppExecutors.getInstance().getDiskId().execute(new Runnable() {
            @Override
            public void run() {
                mCurrentWeatherDao.insert(currentWeatherEntry);
            }
        });
    }
}
