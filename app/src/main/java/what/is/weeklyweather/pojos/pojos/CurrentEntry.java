package what.is.weeklyweather.pojos.pojos;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import what.is.weeklyweather.pojos.pojos.responses.responsepojos.Currently;

@Entity(tableName = "current_entry")
public class CurrentEntry {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "currently")
    private Currently mCurrently;

    public CurrentEntry(Currently currently){this.mCurrently = currently;}

    public Currently getCurrent(){return this.mCurrently;}
}
