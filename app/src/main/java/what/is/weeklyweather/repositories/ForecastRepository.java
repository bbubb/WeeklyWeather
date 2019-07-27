package what.is.weeklyweather.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import what.is.weeklyweather.AppExecutors;
import what.is.weeklyweather.database.WeatherDatabase;
import what.is.weeklyweather.database.dao.ForecastDAO;
import what.is.weeklyweather.pojos.pojos.ForecastEntry;

public class ForecastRepository {

    private ForecastDAO mForecastDAO;
    private LiveData<List<ForecastEntry>> mAllForecastEntries;

    public ForecastRepository(Application application){
        WeatherDatabase db = WeatherDatabase.getDatabase(application);
        mForecastDAO = db.forecastDAO();
        mAllForecastEntries = mForecastDAO.getAllForecastEntries();
    }

    public LiveData<List<ForecastEntry>> getAllForecastEntries(){
        return mAllForecastEntries;
    }

    public void insert(ForecastEntry forecastEntry){
        AppExecutors.getInstance().getDiskId().execute(new Runnable() {
            @Override
            public void run() {mForecastDAO.insert(forecastEntry);}
        });
    }

}
