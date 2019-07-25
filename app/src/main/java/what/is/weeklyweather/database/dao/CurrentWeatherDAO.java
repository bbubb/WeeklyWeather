package what.is.weeklyweather.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import what.is.weeklyweather.pojos.pojos.CurrentEntry;

@Dao
public interface CurrentWeatherDAO {

    @Query("Select * from current_entry ORDER BY id")
    LiveData<List<CurrentEntry>> getAllCurrentWeatherEntries();

    @Insert
    void insert(CurrentEntry entry);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void update(CurrentEntry currentEntry);

    @Delete
    void delete(CurrentEntry entry);

    @Query("Select * from current_entry where id=:currentWeatherId")
    LiveData<CurrentEntry> getCurrentWeatherById(int currentWeatherId);

}


