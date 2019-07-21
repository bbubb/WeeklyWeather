package what.is.weeklyweather;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import what.is.weeklyweather.forecastdarksky.DataItem;

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForecastViewHolder> {

    private List<DataItem> items;

    public ForecastAdapter(List<DataItem> items){this.items = items;}

    @NonNull
    @Override
    public ForecastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.five_day_forecast_item, parent, false);
        return new ForecastViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ForecastViewHolder holder, int position) {
        DataItem weekDay =items.get(position);
        holder.tvWeekDay.setText(String.valueOf(weekDay.getTime()));
        holder.tvDate.setText(DateFormat.getDateInstance(DateFormat.SHORT).format(new Date(weekDay.getTime()*(long)1000)));
        holder.tvTempHigh.setText(String.valueOf(weekDay.getApparentTemperatureHigh())+"°");
        holder.tvTempLow.setText(String.valueOf(weekDay.getApparentTemperatureLow())+"°");
//        holder.ivWeatherIcon.setImageResource(weekDay.getWeather().get().getIcon());

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ForecastViewHolder extends RecyclerView.ViewHolder{
        ImageView ivWeatherIcon;
        TextView tvWeekDay, tvDate, tvTempHigh, tvTempLow;


        public ForecastViewHolder(@NonNull View itemView) {
            super(itemView);
            ivWeatherIcon = itemView.findViewById(R.id.iv_forecast_weather_icon);
            tvWeekDay = itemView.findViewById(R.id.tv_day_of_week);
            tvDate = itemView.findViewById(R.id.tv_forecast_day_month);
            tvTempHigh = itemView.findViewById(R.id.tv_high_temp);
            tvTempLow = itemView.findViewById(R.id.tv_low_temp);
        }
    }
}
