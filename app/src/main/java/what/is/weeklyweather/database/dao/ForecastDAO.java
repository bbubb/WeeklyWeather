package what.is.weeklyweather.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import what.is.weeklyweather.pojos.pojos.ForecastEntry;

@Dao
public interface ForecastDAO {

    @Query("Select * from forecast_entry ORDER BY id")
    LiveData<List<ForecastEntry>> getAllForecastEntries();

    @Insert
    void insert(ForecastEntry forecastEntry);

    @Delete
    void delete(ForecastEntry forecastEntry);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void update(ForecastEntry forecastEntry);

    @Query("Select * from forecast_entry where id=:forecastId")
    LiveData<ForecastEntry> getForecastById(int forecastId);


}
