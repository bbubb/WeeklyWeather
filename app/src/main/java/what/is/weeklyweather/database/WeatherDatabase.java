package what.is.weeklyweather.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import what.is.weeklyweather.database.converters.Converter;
import what.is.weeklyweather.database.dao.CurrentWeatherDAO;
import what.is.weeklyweather.database.dao.ForecastDAO;
import what.is.weeklyweather.database.dao.HourlyDAO;
import what.is.weeklyweather.database.dao.LocationDAO;
import what.is.weeklyweather.pojos.pojos.CurrentEntry;
import what.is.weeklyweather.pojos.pojos.ForecastEntry;
import what.is.weeklyweather.pojos.pojos.HourlyEntry;
import what.is.weeklyweather.pojos.pojos.LocationEntry;

@Database(entities = {CurrentEntry.class, ForecastEntry.class, HourlyEntry.class, LocationEntry.class}, version = 1, exportSchema = false)
@TypeConverters({Converter.class})
public abstract class WeatherDatabase extends RoomDatabase {


    private static final String TAG = WeatherDatabase.class.getSimpleName();
    private static WeatherDatabase INSTANCE;

    public static WeatherDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (WeatherDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            WeatherDatabase.class, "weather_database")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract LocationDAO locationDAO();

    public abstract CurrentWeatherDAO currentWeatherDAO();

    public abstract ForecastDAO forecastDAO();

    public abstract HourlyDAO hourlyDAO();

}
