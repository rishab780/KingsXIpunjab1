package com.example.rishab.assignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import com.example.rishab.assignment.modelClass.PlayersModelClass;
import com.example.rishab.assignment.recyclerViewAdapter.RecyclerViewAdapter;

import java.util.ArrayList;

/**
 * abc
 */

public class HomeActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ArrayList<PlayersModelClass> players = new ArrayList<>();
        players.add(new PlayersModelClass("David Miller"));
        players.add(new PlayersModelClass("Glenn Maxwell"));
        players.add(new PlayersModelClass("Shaun Marsh"));
        players.add(new PlayersModelClass("Marcus Stoinis"));
        players.add(new PlayersModelClass("Hashim Amla"));
        players.add(new PlayersModelClass("Manan Vohra"));
        players.add(new PlayersModelClass("Akshar Rajesh Patel"));
        players.add(new PlayersModelClass("Gurkeerat Mann Singh"));
        players.add(new PlayersModelClass("Anureet Singh"));
        players.add(new PlayersModelClass("Sandeep Sharma"));


        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(this, players);
        recyclerView = (RecyclerView) findViewById(R.id.rv_players);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerViewAdapter);

    }
}
