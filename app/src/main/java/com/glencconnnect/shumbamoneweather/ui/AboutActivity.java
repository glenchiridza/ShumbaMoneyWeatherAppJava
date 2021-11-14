package com.glencconnnect.shumbamoneweather.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.glencconnnect.shumbamoneweather.MainActivity;
import com.glencconnnect.shumbamoneweather.R;

public class AboutActivity extends AppCompatActivity {

    private TextView textTitle;
    private TextView textDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        textTitle = findViewById(R.id.abt_title);
        textDescription = findViewById(R.id.abt_description);

        //get intent extra and customize activity output
        String action = getIntent().getStringExtra(MainActivity.CHOICE_EXTRA);
        if (action != null){
            //switch through the type of action selected and give desired output, pass in action
            switchThroughViewText(action);

        }
    }

    private void switchThroughViewText(String action){
        switch (action){
            //get the info for about action
            case "action_about":
                textTitle.setText(getString(R.string.shumba_money_weather));
                textDescription.setText(getString(R.string.about_text));
                break;
             //get info for credits
            case "action_credits":
                textTitle.setText(getString(R.string.andro_version));
                textDescription.setText(getString(R.string.developer_info));
                break;
        }
    }
}