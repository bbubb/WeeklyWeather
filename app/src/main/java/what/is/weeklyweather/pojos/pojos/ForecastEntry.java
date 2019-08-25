package what.is.weeklyweather.pojos.pojos;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;

import what.is.weeklyweather.pojos.pojos.responses.responsepojos.forecast.Datum;

@Entity(tableName = "forecast_entry")
public class ForecastEntry {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "forecast_list")
    private List<Datum> mForecastList;

    public ForecastEntry(List<Datum> mForecastList) {
        this.mForecastList = mForecastList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Datum> getForecastList() {
        return mForecastList;
    }


}
