package com.example.liuale.myyoutubeappdemo;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by liuale on 8/30/17.
 */

public class MyViewHolder extends RecyclerView.ViewHolder {

    public TextView titleTextView;
    public TextView dateTextView;
    public ImageView coverImageView;
    public ImageView likeImageView;
    public ImageView shareImageView;
    private String videoId;

    public MyViewHolder(View v) {
        super(v);
        titleTextView = (TextView) v.findViewById(R.id.titleTextView);
        dateTextView = (TextView) v.findViewById(R.id.dataTextView);
        coverImageView = (ImageView) v.findViewById(R.id.coverImageView);
        likeImageView = (ImageView) v.findViewById(R.id.likeImageView);
        shareImageView = (ImageView) v.findViewById(R.id.shareImageView);

        final Context context = MainActivity.getAppContext();

        coverImageView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.getAppContext(), YouTubePlayActivity.class);
                MainActivity.getAppContext().startActivity(intent);
            }
        });


        likeImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int id = (int)likeImageView.getTag();
                if( id == R.drawable.ic_like){

                    likeImageView.setTag(R.drawable.ic_liked);
                    likeImageView.setImageResource(R.drawable.ic_liked);

                    Toast.makeText(MainActivity.getAppContext(),titleTextView.getText()+" added to favourites",Toast.LENGTH_SHORT).show();

                }else{

                    likeImageView.setTag(R.drawable.ic_like);
                    likeImageView.setImageResource(R.drawable.ic_like);
                    Toast.makeText(MainActivity.getAppContext(),titleTextView.getText()+" removed from favourites",Toast.LENGTH_SHORT).show();


                }

            }
        });



        shareImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri imageUri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE +
                        "://" + context.getResources().getResourcePackageName(coverImageView.getId())
                        + '/' + "drawable" + '/' + context.getResources().getResourceEntryName((int)coverImageView.getTag()));


                Intent shareIntent = new Intent();
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.putExtra(Intent.EXTRA_STREAM,imageUri);
                shareIntent.setType("image/jpeg");
                context.startActivity(Intent.createChooser(shareIntent, context.getResources().getText(R.string.send_to)));

            }
        });
    }

    public void setVideoId(String Id){
        this.videoId = Id;
    }

    public String getVideoId(){
        return videoId;
    }
}