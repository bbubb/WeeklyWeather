package what.is.weeklyweather.pojos.pojos;


import android.location.Location;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "location_table")
public class LocationEntry {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo
    private Location location;

    public LocationEntry(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
