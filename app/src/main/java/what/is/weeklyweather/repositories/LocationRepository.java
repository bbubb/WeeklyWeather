package what.is.weeklyweather.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import what.is.weeklyweather.AppExecutors;
import what.is.weeklyweather.database.WeatherDatabase;
import what.is.weeklyweather.database.dao.LocationDAO;
import what.is.weeklyweather.pojos.pojos.LocationEntry;

public class LocationRepository {
    private LocationDAO mLocationDAO;
    private LiveData<List<LocationEntry>> mAllLocationEntries;

    public LocationRepository(Application application){
        WeatherDatabase db = WeatherDatabase.getDatabase(application);
        mLocationDAO = db.locationDAO();
        mAllLocationEntries = mLocationDAO.getAllLocationEntries();
    }

    public LiveData<List<LocationEntry>> getAllLocationEntries(){return mAllLocationEntries;}

    public void insert(LocationEntry locationEntry){
        AppExecutors.getInstance().getDiskId().execute(new Runnable() {
            @Override
            public void run() {mLocationDAO.insert(locationEntry);}
        });
    }

    public void update(LocationEntry locationEntry){
        AppExecutors.getInstance().getDiskId().execute(new Runnable() {
            @Override
            public void run() {mLocationDAO.update(locationEntry);}
        });
    }
}
