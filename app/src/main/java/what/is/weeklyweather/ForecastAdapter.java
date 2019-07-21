package what.is.weeklyweather;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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
        View view;
        holder.tvWeekDay.setText(android.text.format.DateFormat.format("E",(new Date(weekDay.getTime() * (long)1000))).toString().toUpperCase());
        holder.tvDate.setText(android.text.format.DateFormat.format("dd",(new Date(weekDay.getTime() * (long)1000))).toString().toUpperCase());
        holder.tvTempHigh.setText(String.valueOf(Math.round(weekDay.getTemperatureMax()))+"°");
        holder.tvTempLow.setText(String.valueOf(Math.round(weekDay.getTemperatureLow()))+"°");

        holder.ivWeatherIcon.setImageResource(R.drawable.sunny);
//        holder.ivWeatherIcon.setImageResource(setIcon(weekDay.getIcon()));

    }


    public int setIcon(String icon){
        int view = 0;
       if(icon=="default") {
           view = (R.drawable.sunny);
       }  else if (icon == "clear-day"){
           view =(R.drawable.sunny);
           }else if(icon == "partly-cloudy-day"){
           view =(R.drawable.scattered_showers);
           }else if(icon == "cloudy"){
           view =(R.drawable.partly_cloudy);
           }else if(icon == "rain"){
           view =(R.drawable.rain);
           }else if(icon == "wind"){

           }else if(icon == "thunderstorms"){
           view =(R.drawable.stormy);
           }else if(icon == "fog"){

           }else if(icon == "snow"){
           view = (R.drawable.snow);
           }else if(icon == null){
           view =(R.drawable.sunny);
           }
               return view; }

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
