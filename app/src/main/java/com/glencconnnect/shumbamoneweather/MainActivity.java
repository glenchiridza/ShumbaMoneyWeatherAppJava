package com.glencconnnect.shumbamoneweather;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.glencconnnect.shumbamoneweather.adapters.WeatherRecyclerAdapter;
import com.glencconnnect.shumbamoneweather.ui.AboutActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private WeatherRecyclerAdapter adapter;
    private FloatingActionButton fab;
    public static String CHOICE_EXTRA = "CHOICE_EXTRA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.recycler_view);
        fab = findViewById(R.id.fab);

        adapter = new WeatherRecyclerAdapter(this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);


        fab.setOnClickListener(view->{
            shareIntent();
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