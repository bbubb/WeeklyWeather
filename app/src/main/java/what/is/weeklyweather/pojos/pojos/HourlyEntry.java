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

    public HourlyEntry(List<DataItem> mHourlyList) {
        this.mHourlyList = mHourlyList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<DataItem> getHourlyList() {
        return mHourlyList;
    }
}
