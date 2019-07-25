package what.is.weeklyweather.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import what.is.weeklyweather.database.converters.DateConverter;
import what.is.weeklyweather.database.dao.CurrentWeatherDAO;
import what.is.weeklyweather.pojos.pojos.CurrentEntry;


@Database(entities = {CurrentEntry.class}, version = 1, exportSchema = false)
//@TypeConverters({DateConverter.class})
public abstract class CurrentWeatherDatabase extends RoomDatabase {

    private static final String TAG = CurrentWeatherDatabase.class.getSimpleName();
    private static CurrentWeatherDatabase INSTANCE;

    public static CurrentWeatherDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (CurrentWeatherDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            CurrentWeatherDatabase.class, "current_weather_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract CurrentWeatherDAO currentWeatherDAO();

}
