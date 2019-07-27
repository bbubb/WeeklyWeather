package what.is.weeklyweather.pojos.pojos;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import what.is.weeklyweather.pojos.pojos.responses.responsepojos.Currently;

@Entity(tableName = "current_entry")
public class CurrentEntry {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @Embedded
    private Currently mCurrently;

    public CurrentEntry() {
    }

    @Ignore
    public CurrentEntry(Currently mCurrently) {
        this.mCurrently = mCurrently;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Currently getCurrently() {
        return mCurrently;
    }

    public void setCurrently(Currently mCurrently) {
        this.mCurrently = mCurrently;
    }
}
