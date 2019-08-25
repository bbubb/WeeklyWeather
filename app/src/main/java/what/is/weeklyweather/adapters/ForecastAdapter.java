package what.is.weeklyweather.adapters;

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

import what.is.weeklyweather.R;
import what.is.weeklyweather.pojos.pojos.responses.responsepojos.forecast.Datum;

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForecastViewHolder> {

    private List<Datum> items;
    private Context context;

    public ForecastAdapter(List<Datum> items) {
        this.items = items;
    }

    public void setItems(List<Datum> mItems){
        items = mItems;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ForecastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.sevenday_forecast_item, parent, false);
        return new ForecastViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ForecastViewHolder holder, int position) {
        Datum weekDay = items.get(position);
        holder.tvWeekDay.setText(android.text.format.DateFormat.format("EEEEE-dd", (new Date(weekDay.getTime() * (long) 1000))).toString().toUpperCase());
        holder.tvWeatherInfo.setText(weekDay.getSummary());
        holder.tvTempHigh.setText(String.valueOf(Math.round(weekDay.getTemperatureMax())) + "°");
        holder.tvTempLow.setText(String.valueOf(Math.round(weekDay.getTemperatureMin())) + "°");
        holder.ivWeatherIcon.setImageDrawable(getWeatherIcon(weekDay.getIcon()));

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

    class ForecastViewHolder extends RecyclerView.ViewHolder {
        ImageView ivWeatherIcon;
        TextView tvWeekDay, tvTempHigh, tvTempLow, tvWeatherInfo;


        public ForecastViewHolder(@NonNull View itemView) {
            super(itemView);
            ivWeatherIcon = itemView.findViewById(R.id.iv_forecast_weather_icon);
            tvWeekDay = itemView.findViewById(R.id.tv_forecast_date);
            tvTempHigh = itemView.findViewById(R.id.tv_forecast_temp_high);
            tvTempLow = itemView.findViewById(R.id.tv_forecast_temp_low);
            tvWeatherInfo = itemView.findViewById(R.id.tv_forecast_weatherinfo);
        }
    }
}
