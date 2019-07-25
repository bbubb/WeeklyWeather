package what.is.weeklyweather.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import what.is.weeklyweather.database.dao.HourlyDAO;
import what.is.weeklyweather.pojos.pojos.HourlyEntry;

@Database(entities = {HourlyEntry.class}, version = 1, exportSchema = false)
public abstract class HourlyDatabase extends RoomDatabase {

    private static final String TAG = HourlyDatabase.class.getSimpleName();
    private static HourlyDatabase INSTANCE;

    public static HourlyDatabase getDatabase(Context context){
        if(INSTANCE==null){
            synchronized (HourlyDatabase.class){
                if (INSTANCE==null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            HourlyDatabase.class, "hourly_database")
                            .build();
                }
            }
        } return INSTANCE;
    }

    public abstract HourlyDAO hourlyDAO();
}
