package what.is.weeklyweather;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Date;
import java.util.List;

import what.is.weeklyweather.hourlydarksky.DataItem;

public class HourlyAdapter extends RecyclerView.Adapter<HourlyAdapter.HourlyViewHolder> {

    private List<what.is.weeklyweather.hourlydarksky.DataItem> items;
    private Context context;

    public HourlyAdapter(List<what.is.weeklyweather.hourlydarksky.DataItem> items) {
         this.items = items;
    }

    @NonNull
    @Override
    public HourlyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.hourly_item, parent, false);
        return new HourlyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull HourlyViewHolder holder, int position) {
        DataItem hour = items.get(position);
        holder.tvTemp.setText(String.valueOf(Math.round(hour.getTemperature())) + "°");
        holder.ivHourlyIcon.setImageDrawable(getWeatherIcon(hour.getIcon()));
        holder.tvHour.setText(android.text.format.DateFormat.format("hha", (new Date((long) (hour.getTime() * (long) 1000)))).toString().toUpperCase());
        holder.tvPrecipitation.setText(String.valueOf(Math.round(hour.getPrecipProbability()))+"%");
    }

    private Drawable getWeatherIcon(String icon) {
        int id;
        switch (icon) {
            case "snow":
                id = R.drawable.snow;
                break;
            case "thunderstorms":
            case "wind":
                id = R.drawable.stormy;
                break;
            case "rain":
                id = R.drawable.rain;
                break;
            case "partly-cloudy-day":
            case  "partly-cloudy":
            case "fog":
                id = R.drawable.scattered_showers;
                break;
            case "clear-day":
            default:
                id = R.drawable.sunny;
                break;
        }
        return ContextCompat.getDrawable(context, id);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class HourlyViewHolder extends RecyclerView.ViewHolder {
        ImageView ivHourlyIcon;
        TextView tvHour, tvPrecipitation, tvTemp;


        public HourlyViewHolder(@NonNull View itemView) {
            super(itemView);
            ivHourlyIcon = itemView.findViewById(R.id.iv_hourly_weather_icon);
            tvHour = itemView.findViewById(R.id.tv_hour);
            tvTemp = itemView.findViewById(R.id.tv_hourly_temp);
            tvPrecipitation = itemView.findViewById(R.id.tv_hourly_precipitation);
        }
    }
}
