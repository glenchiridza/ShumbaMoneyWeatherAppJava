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

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private WeatherRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new WeatherRecyclerAdapter(this);
        recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);


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
            retrieveAbout();
        }
        else if(id == R.id.action_credits){
            shareIntent();
        }
        return super.onOptionsItemSelected(item);
    }

    private void shareIntent(){
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        startActivity(Intent.createChooser(shareIntent,"Share App"));
    }

    private void retrieveAbout(){
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
    }
}