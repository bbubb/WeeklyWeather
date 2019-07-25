package what.is.weeklyweather.database.converters;

import androidx.room.TypeConverter;

import java.util.Date;

public class DateConverter {
    @TypeConverter
    public static Date timestampToDate(Long timestamp){
        return timestamp == null ? null : new Date((timestamp) * (long) 1000);
    }

}
