/**
 * Created by glenc on Nov 2021
 **/

package com.glencconnnect.shumbamoneweather.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.glencconnnect.shumbamoneweather.R;

public class WeatherRecyclerAdapter extends RecyclerView.Adapter {

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflate the list_item layout for display using viewholder, attach to root is false coz when oncreateview is called,
        // the layout is attached to view automatically then, so no need to attach again
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        //bind the view elements , use holder to access the views and set their representational data from the data received from api

        holder.set
    }

    @Override
    public int getItemCount() {

        return 0;
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


