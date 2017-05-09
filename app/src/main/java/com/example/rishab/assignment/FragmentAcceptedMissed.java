package com.example.rishab.assignment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rishab.assignment.modelClass.PlayersModelClass;
import com.example.rishab.assignment.recyclerViewAdapter.RecyclerViewAdapter;

import java.util.ArrayList;

/**
 * Created by Rishab on 21-04-2017.
 */

public class FragmentAcceptedMissed extends Fragment {
    private RecyclerView recyclerView;
    private int mode;
    private Bundle extra;

    /**
     *
     * @param i mode
     * @param extra bundle
     */
    public FragmentAcceptedMissed(final int i, final Bundle extra) {
        mode = i;
        this.extra = extra;

    }


    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        ArrayList<PlayersModelClass> players  = extra.getParcelableArrayList("arraylist");
        View view = inflater.inflate(R.layout.activity_home, container, false);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(), players);
        recyclerView = (RecyclerView) view.findViewById(R.id.rv_players);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(recyclerViewAdapter);
        return view;
    }
}
