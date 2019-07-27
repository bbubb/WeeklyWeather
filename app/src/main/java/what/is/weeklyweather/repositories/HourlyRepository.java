package what.is.weeklyweather.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import what.is.weeklyweather.AppExecutors;
import what.is.weeklyweather.database.WeatherDatabase;
import what.is.weeklyweather.database.dao.HourlyDAO;
import what.is.weeklyweather.pojos.pojos.HourlyEntry;

public class HourlyRepository {

    private HourlyDAO mHourlyDAO;
    private LiveData<List<HourlyEntry>> mAllHourlyEntries;

    public HourlyRepository(Application application){
        WeatherDatabase db = WeatherDatabase.getDatabase(application);
        mHourlyDAO = db.hourlyDAO();
        mAllHourlyEntries = mHourlyDAO.getAllHourlyEntries();
    }

    public LiveData<List<HourlyEntry>> getAllHourlyEntries(){
        return mAllHourlyEntries;
    }

    public void insert(HourlyEntry hourlyEntry){
        AppExecutors.getInstance().getDiskId().execute(new Runnable() {
            @Override
            public void run() {mHourlyDAO.insert(hourlyEntry);
            }
        });
    }
}
