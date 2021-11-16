/**
 * Created by glenc on Nov 2021
 **/

package com.glencconnnect.shumbamoneweather.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.glencconnnect.shumbamoneweather.models.OuterContainer;
import com.glencconnnect.shumbamoneweather.models.Weather;
import com.glencconnnect.shumbamoneweather.ui.DetailView;
import com.glencconnnect.shumbamoneweather.R;

import java.util.ArrayList;
import java.util.List;

public class WeatherRecyclerAdapter extends RecyclerView.Adapter<WeatherRecyclerAdapter.MyViewHolder> {

    public static final String WEATHER_DATA = "WEATHER_DATA";
    private Context context;
    private ArrayList<com.glencconnnect.shumbamoneweather.models.List> weatherList;

    public WeatherRecyclerAdapter(Context context, ArrayList<com.glencconnnect.shumbamoneweather.models.List> weatherList) {
        this.context = context;
        this.weatherList = weatherList;
    }

    public void setDataListing(ArrayList<com.glencconnnect.shumbamoneweather.models.List> weatherList){
        this.weatherList = weatherList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflate the list_item layout for display using viewholder, attach to root is false coz when oncreateview is called,
        // the layout is attached to view automatically then, so no need to attach again
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //bind the view elements , use holder to access the views and set their representational data from the data received from api

//
//        bannerImage.setImageResource(R.drawable.top_learner);
//        Picasso.get().load(learnersList.get(position).getImage()).into(bannerImage);
//        full_name.setText(learnersList.get(position).getName());
//
        String city = "Harare";
        StringBuilder deg_sb = new StringBuilder();



        String date = weatherList.get(position).getDt_txt();
    //    String weatherDescription = weatherList.get(0).getWeather().get(position).getDescription();
        String degrees  = String.valueOf(weatherList.get(position).getMain().getTemp());
        deg_sb.append(degrees).append('\u00B0').append(" C");

        //get the weather list
        ArrayList<Weather>  weather = weatherList.get(position).getWeather();
        String weatherDescription = weather.get(0).getDescription();
        String icon = weather.get(0).getIcon()+".png";

        String humidity = String.valueOf(weatherList.get(position).getMain().getHumidity());
        String pressure = String.valueOf(weatherList.get(position).getMain().getPressure());

        holder.wCity.setText(city);
        holder.wDate.setText(date);
        holder.wWeather.setText(weatherDescription);
        holder.wDegrees.setText(deg_sb);

        //pass the content to the intent being started
        ArrayList<String> weatherData = new ArrayList<>();
        weatherData.add(0,date);
        weatherData.add(1,degrees);
        weatherData.add(2,weatherDescription);
        weatherData.add(3,humidity);
        weatherData.add(4,pressure);
        weatherData.add(5,icon);

        holder.itemView.setOnClickListener(view->{
            Intent detailIntent = new Intent(context,DetailView.class);
            detailIntent.putExtra(WEATHER_DATA,weatherData);
            context.startActivity(detailIntent);
        });
    }


    @Override
    public int getItemCount() {

        return weatherList ==null ? 0 : weatherList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView wDate;
        private TextView wCity;
        private TextView wDegrees;
        private TextView wWeather;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            wDate = itemView.findViewById(R.id.txt_date);
            wCity = itemView.findViewById(R.id.txt_city);
            wDegrees = itemView.findViewById(R.id.txt_degrees);
            wWeather = itemView.findViewById(R.id.txt_weather);
        }
    }
}


