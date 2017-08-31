package com.example.liuale.myyoutubeappdemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by liuale on 8/30/17.
 */

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private ArrayList<WonderModel> list;

    public MyAdapter(ArrayList<WonderModel> Data) {
        list = Data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycle_items, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        holder.titleTextView.setText(list.get(position).getCardName());
        holder.dateTextView.setText("08/30/2017");
        holder.coverImageView.setImageResource(list.get(position).getImageResourceId());
        holder.coverImageView.setTag(list.get(position).getImageResourceId());
        holder.likeImageView.setTag(R.drawable.ic_like);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}