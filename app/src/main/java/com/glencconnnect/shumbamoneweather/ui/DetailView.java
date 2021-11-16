package com.glencconnnect.shumbamoneweather.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.glencconnnect.shumbamoneweather.R;

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