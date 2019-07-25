package what.is.weeklyweather.database.converters;

import androidx.room.TypeConverter;

public class DoubleConverter {
    @TypeConverter
    public static String doubleToString(Double data) {
        return data == null ? null : String.valueOf(Math.round(data));
    }

    @TypeConverter
    public static String doubleToPercentString(Double data){
        return data == null ? null : String.valueOf(Math.round(data*100));
    }

}
