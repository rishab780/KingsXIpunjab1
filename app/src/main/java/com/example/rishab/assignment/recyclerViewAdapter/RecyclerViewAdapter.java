package com.example.rishab.assignment.recyclerViewAdapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.rishab.assignment.modelClass.PlayersModelClass;
import com.example.rishab.assignment.PlayerActivity;
import com.example.rishab.assignment.R;

import java.util.ArrayList;



/**
 * Created by Rishab on 20-04-2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private ArrayList<PlayersModelClass> players;
    private Context context;

    /**
     *
     * @param context context
     * @param players players
     */
    public RecyclerViewAdapter(final Context context, final ArrayList<PlayersModelClass> players) {
        Log.e("debug", "hello");
        this.players = players;
        this.context = context;
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        //context = parent.getContext();
        View itemView;
        itemView = LayoutInflater.from(context).inflate(R.layout.item_view, parent, false);
        //ViewHolder viewHolder = new ViewHolder(itemView);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final RecyclerViewAdapter.ViewHolder holder, final int position) {
        PlayersModelClass currentPlayer = players.get(position);
        Log.d("debug", currentPlayer.getmName());
        holder.name.setText(currentPlayer.getmName());
    }

    /**
     *
     * @return size
     */
    @Override
    public int getItemCount() {
        Log.d("debug", String.valueOf(players.size()));
        return players.size();
    }

    /**
     * abc
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name;

        /**
         *
         * @param itemView item vview of recycler view
         */

        public ViewHolder(final View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.tv_name);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {
                    Log.d("debug", "onClick: adapter");
                    Intent intent = new Intent(context, PlayerActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putParcelableArrayList("arraylist", players);
                    intent.putExtras(bundle);
                    Log.d("debug", "onClick: adapter");
                    context.startActivity(intent);
                }
            });

        }
    }
}
