package com.example.liuale.myyoutubeappdemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.List;

/**
 * Created by liuale on 8/29/17.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> implements YouTubeDataListener{
    private List<MyCard> mYoutubeCards;
    private YouTubeData mYouTubeData;
    private RecyclerView mRecyclerView;

    public MyAdapter(RecyclerView mRecyclerView) {
        this.mRecyclerView = mRecyclerView;
        mYouTubeData = new YouTubeData(this);

    }

    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycle_items, parent, false);
        MyAdapter.MyViewHolder holder = new MyAdapter.MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyAdapter.MyViewHolder holder, int position) {

        holder.cardTitleTextView.setText(mYoutubeCards.get(position).getTitle());
        holder.dateTextView.setText(mYoutubeCards.get(position).getDate());
        holder.likeImageView.setTag(R.drawable.ic_like);
        holder.shareImageView.setTag(R.drawable.ic_share);

    }

    @Override
    public int getItemCount() {
        return mYoutubeCards.size();
    }

    @Override
    public void responseRecieved(List<MyCard> mYoutubeCards){
        this.mYoutubeCards = mYoutubeCards;

    }



    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView cardTitleTextView;
        public TextView titleTextView;
        public TextView dateTextView;
        public YouTubePlayerView youTubePlayerView;
        public ImageView likeImageView;
        public ImageView shareImageView;

        public MyViewHolder(View v) {
            super(v);
            cardTitleTextView = (TextView) v.findViewById(R.id.cardTitleTextView);
            titleTextView = (TextView) v.findViewById(R.id.titleTextView);
            dateTextView = (TextView) v.findViewById(R.id.dateTextView);
            youTubePlayerView = (YouTubePlayerView) v.findViewById(R.id.youtubeView);
            likeImageView = (ImageView) v.findViewById(R.id.likeImageView);
            shareImageView = (ImageView) v.findViewById(R.id.shareImageView);
            likeImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    int id = (int)likeImageView.getTag();
                    if( id == R.drawable.ic_like){

                        likeImageView.setTag(R.drawable.ic_liked);
                        likeImageView.setImageResource(R.drawable.ic_liked);

                        Toast.makeText(MainActivity.getContext(),titleTextView.getText()+" added to favourites",Toast.LENGTH_SHORT).show();

                    }else{

                        likeImageView.setTag(R.drawable.ic_like);
                        likeImageView.setImageResource(R.drawable.ic_like);
                        Toast.makeText(MainActivity.getContext(),titleTextView.getText()+" removed from favourites",Toast.LENGTH_SHORT).show();


                    }

                }
            });



            shareImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //on-op

                }
            });



        }
    }


}