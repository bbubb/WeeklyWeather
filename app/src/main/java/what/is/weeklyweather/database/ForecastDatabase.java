package what.is.weeklyweather.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import what.is.weeklyweather.database.dao.ForecastDAO;
import what.is.weeklyweather.pojos.pojos.ForecastEntry;

@Database(entities = {ForecastEntry.class}, version = 1, exportSchema = false)
public abstract class ForecastDatabase extends RoomDatabase {

    private final static String TAG = ForecastDatabase.class.getSimpleName();
    private static ForecastDatabase INSTANCE;

    public static ForecastDatabase getDatabase(Context context){
        if (INSTANCE==null){
            synchronized (ForecastDatabase.class){
                if(INSTANCE==null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            ForecastDatabase.class, "forecast_database")
                            .build();
                }
            }
        } return INSTANCE;
    }

    public abstract ForecastDAO forecastDAO();
}
