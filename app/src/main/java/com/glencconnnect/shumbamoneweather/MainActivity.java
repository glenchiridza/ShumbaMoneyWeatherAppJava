package com.glencconnnect.shumbamoneweather;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.glencconnnect.shumbamoneweather.adapters.WeatherRecyclerAdapter;
import com.glencconnnect.shumbamoneweather.models.List;
import com.glencconnnect.shumbamoneweather.models.OuterContainer;
import com.glencconnnect.shumbamoneweather.retrofit.RetrieveWeather;
import com.glencconnnect.shumbamoneweather.retrofit.ServiceBuilder;
import com.glencconnnect.shumbamoneweather.ui.AboutActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private WeatherRecyclerAdapter adapter;
    private FloatingActionButton fab;
    private FloatingActionButton fabRefresh;
    private TextView textView;
    private ProgressBar progressBar;
    private ImageView shumaLogo;

    public static String CHOICE_EXTRA = "CHOICE_EXTRA";

    private ArrayList<List> weatherList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.recycler_view);
        textView = findViewById(R.id.myview);
        progressBar = findViewById(R.id.progressing);
        shumaLogo = findViewById(R.id.shumba_img);

        fab = findViewById(R.id.fab);
        fabRefresh = findViewById(R.id.fab_refresh);


        weatherList = new ArrayList<>();

        adapter = new WeatherRecyclerAdapter(this,weatherList);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);


        progressBar.setVisibility(View.VISIBLE);

        fab.setOnClickListener(view->{
            shareIntent();
        });



        //called on create
        retrieveWeatherData();

        //click fab to refresh, to try retrieve again if failed on oncreate first view
        fabRefresh.setOnClickListener(view ->{
            progressBar.setVisibility(View.VISIBLE);
            textView.setVisibility(View.GONE);
            retrieveWeatherData();
        });

    }

    protected void retrieveWeatherData() {
        RetrieveWeather retrieveWeather = ServiceBuilder.builderService(RetrieveWeather.class);
        Call<OuterContainer> call = retrieveWeather.getData();

        call.enqueue(new Callback<OuterContainer>() {
            @Override
            public void onResponse(Call<OuterContainer> call, Response<OuterContainer> response) {

                progressBar.setVisibility(View.GONE);
                fabRefresh.setVisibility(View.GONE);
                textView.setVisibility(View.GONE);
                shumaLogo.setVisibility(View.GONE);

                if(response.isSuccessful()){

                    OuterContainer listing = response.body();
                    ArrayList<List> list = listing.getList();
                    weatherList = list;

                    adapter.setDataListing(weatherList);
                }
            }

            @Override
            public void onFailure(Call<OuterContainer> call, Throwable t) {

                progressBar.setVisibility(View.GONE);
                shumaLogo.setVisibility(View.VISIBLE);
                fabRefresh.setVisibility(View.VISIBLE);
                //the default error value in textview will be retained here from layout string resource, if no response
                textView.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        if(id == R.id.action_about){
            retrieveInfo("action_about");
        }
        else if(id == R.id.action_credits){
            retrieveInfo("action_credits");
        }
        return super.onOptionsItemSelected(item);
    }

    private void shareIntent(){
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT,getString(R.string.extra_share_app_text));
        startActivity(Intent.createChooser(shareIntent,"Share With"));
    }

    //retrieve information on about and credits, pass in the extras depending on the chosen option and dynamicaly populate that single activity with the right data
    //simply reusing the same AboutActiivty for two different options
    private void retrieveInfo(String choice_extra){
        Intent intent = new Intent(this, AboutActivity.class);
        intent.putExtra(CHOICE_EXTRA,choice_extra);
        startActivity(intent);
    }

}