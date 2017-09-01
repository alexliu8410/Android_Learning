package com.example.liuale.myyoutubeappdemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuale on 8/30/17.
 */

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> implements YoutubeDataListener{
    private ArrayList<YoutubeVideoItem> list;

    public MyAdapter(ArrayList<YoutubeVideoItem> Data) {
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
        holder.titleTextView.setText(list.get(position).getVideoTitle());
        holder.dateTextView.setText(list.get(position).getReleaseDate());
        holder.likeImageView.setTag(R.drawable.ic_like);
        holder.shareImageView.setTag(R.drawable.ic_share);
        Picasso.with(MainActivity.getAppContext()).load(list.get(position).getCoverImageUrl()).into(holder.coverImageView);
    }

    @Override
    public void getNotified(List<YoutubeVideoItem> youtubeVideoItemList){

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}