package what.is.weeklyweather.database.dao;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import what.is.weeklyweather.pojos.pojos.HourlyEntry;

@Dao
public interface HourlyDAO {

    @Query("Select * from hourly_entry order by id")
    LiveData<List<HourlyEntry>> getAllHourlyEntries();

    @Insert
    void insert(HourlyEntry hourlyEntry);

    @Delete
    void delete(HourlyEntry hourlyEntry);

    @Query("Select * from hourly_entry where id=:hourlyId")
    LiveData<HourlyEntry> getHourlyById(int hourlyId);
}
