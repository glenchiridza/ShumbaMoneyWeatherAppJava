package com.glencconnnect.shumbamoneweather.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.glencconnnect.shumbamoneweather.R;
import com.glencconnnect.shumbamoneweather.adapters.WeatherRecyclerAdapter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DetailView extends AppCompatActivity {
//  weatherData.add(0,date);
//        weatherData.add(1,degrees);
//        weatherData.add(2,weatherDescription);
//        weatherData.add(3,humidity);
//        weatherData.add(4,pressure);
//        weatherData.add(5,icon);

    private ImageView icon;
    private TextView dvDate;
    private TextView dvHumidity;
    private TextView dvDegrees;
    private TextView dvPressure;
    private TextView dvWeatherDetail;
    private TextView dvDescription;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);

        //initialize views
        initViews();

        weatherData.add(0,date);
        weatherData.add(1,degrees);
        weatherData.add(2,weatherDescription);
        weatherData.add(3,humidity);
        weatherData.add(4,pressure);
        weatherData.add(5,icon);

        //set the values retrieved from intent, in accordance to their position in passed on ArrayList
        ArrayList<String> weatherData = getIntent().getStringArrayListExtra(WeatherRecyclerAdapter.WEATHER_DATA);

        if (weatherData != null){
            dvDate.setText(weatherData.get(0));
            StringBuilder deg = new StringBuilder().append(weatherData
                    .get(1)).append('\u00B0');
            dvDegrees.setText(deg);
            StringBuilder detail = new StringBuilder()
                    .append(getString(R.string.feels_like))
                    .append(deg)
                    .append(weatherData.get(2));
            dvWeatherDetail.setText(detail);
            dvHumidity.setText(weatherData.get(3));
            dvPressure.setText(weatherData.get(4));
            Picasso.get().load(weatherData.get(5)).into(icon);


            //calculate whether to output hot or cold based on degree condition given
            //if temp > 25deg hot and if temp <10 deg cold
            double degrees = Double.parseDouble(weatherData.get(1));
            if (degrees > 25) {
                dvDescription.setText(R.string.hot);
            } else {
                dvDescription.setText(R.string.cold);
            }

        }


    }

    private void initViews() {
        icon = findViewById(R.id.dv_icon);
        dvDate = findViewById(R.id.dv_date);
        dvHumidity = findViewById(R.id.dv_humidity);
        dvDegrees = findViewById(R.id.dv_degrees);
        dvPressure = findViewById(R.id.dv_pressure);
        dvWeatherDetail = findViewById(R.id.dv_weather_detail);
        dvDescription = findViewById(R.id.dv_description);

    }
}