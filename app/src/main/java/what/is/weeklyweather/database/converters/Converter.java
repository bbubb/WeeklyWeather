package what.is.weeklyweather.database.converters;

import android.location.Location;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import what.is.weeklyweather.pojos.pojos.responses.responsepojos.forecast.Datum;
import what.is.weeklyweather.pojos.pojos.responses.responsepojos.hourly.DataItem;

public class Converter {

    private static Gson gson = new Gson();

    @TypeConverter
    public static String forecastListToString(List<Datum> forecastList){
        return gson.toJson(forecastList);
    }

    @TypeConverter
    public static List<Datum> stringToForecastList(String forecastString){
        if(forecastString==null){
            return Collections.emptyList();
        }
       Type type =  new TypeToken<List<Datum>>(){}.getType();
        return gson.fromJson(forecastString, type);
    }

    @TypeConverter
    public static String hourlyListToString(List<DataItem> hourlyList){
        return gson.toJson(hourlyList);
    }

    @TypeConverter
    public static List<DataItem> stringToHourlyList(String hourlyString){
        if(hourlyString==null){
            return Collections.emptyList();
        }
       Type type =  new TypeToken<List<DataItem>>(){}.getType();
        return gson.fromJson(hourlyString, type);
    }

    @TypeConverter
    public static Date timestampToDate(Long timestamp){
        return timestamp == null ? null : (new Date(timestamp));
    }

    @TypeConverter
    public static Long dateToTimestamp(Date date){
        return date == null ? null : (date.getTime());
    }

    @TypeConverter
    public static String locationToString (Location location){
        return location==null ? null : (String.format(Locale.US, "%f,%f", location.getLatitude(),
                location.getLongitude()));
    }

    @TypeConverter
    public static Location stringToLocation (String latlon){
        if (latlon==null) {
            return(null);
        }

        String[] pieces=latlon.split(",");
        Location result=new Location("");

        result.setLatitude(Double.parseDouble(pieces[0]));
        result.setLongitude(Double.parseDouble(pieces[1]));

        return(result);
    }
}
