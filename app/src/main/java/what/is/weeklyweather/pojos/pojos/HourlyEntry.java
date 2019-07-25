package what.is.weeklyweather.pojos.pojos;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;

import what.is.weeklyweather.pojos.pojos.responses.responsepojos.hourly.DataItem;

@Entity(tableName = "hourly_entry")
public class HourlyEntry {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "hourly_list")
    private List<DataItem> mHourlyList;

    public HourlyEntry(List<DataItem> hourlyList){this.mHourlyList = hourlyList;}

    public List<DataItem> getHourlyList(){return this.mHourlyList;}

}
