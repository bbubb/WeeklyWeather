package what.is.weeklyweather.repositories;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import java.util.List;

import what.is.weeklyweather.AppExecutors;
import what.is.weeklyweather.database.WeatherDatabase;
import what.is.weeklyweather.database.dao.HourlyDAO;
import what.is.weeklyweather.pojos.pojos.HourlyEntry;

public class HourlyRepository {

    private HourlyDAO mHourlyDAO;
    private LiveData<List<HourlyEntry>> mAllHourlyEntries;
    private LiveData<HourlyEntry> mHourlyEntry;


    public HourlyRepository(Application application){
        WeatherDatabase db = WeatherDatabase.getDatabase(application);
        mHourlyDAO = db.hourlyDAO();
        mAllHourlyEntries = mHourlyDAO.getAllHourlyEntries();
    }

    public LiveData<List<HourlyEntry>> getAllHourlyEntries(){
        return mAllHourlyEntries;
    }
    public LiveData<HourlyEntry> getHourlyEntry(){return mHourlyEntry;}

    public void insert(HourlyEntry hourlyEntry){
        AppExecutors.getInstance().getDiskId().execute(new Runnable() {
            @Override
            public void run() {mHourlyDAO.insert(hourlyEntry);
            }
        });
    }

    public HourlyRepository(@NonNull int id, @NonNull WeatherDatabase db){
        this.mHourlyEntry = db.hourlyDAO().getHourlyById(id);
    }
}
