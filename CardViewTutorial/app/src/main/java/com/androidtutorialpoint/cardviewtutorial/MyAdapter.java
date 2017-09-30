package com.androidtutorialpoint.cardviewtutorial;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;



public class MyAdapter extends RecyclerView.Adapter<MyAdapter.CardViewHolder>
{
    private ArrayList<Person> list;


    public MyAdapter(ArrayList<Person> Data)
    {
        list = Data;
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        // create a new view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycle_items, parent, false);
        return new CardViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final MyAdapter.CardViewHolder holder, final int position)
    {

//        WonderModel mWonderModel = list.get(position);
//
//        holder.titleTextView.setText(mWonderModel.getCardName());
//        holder.coverImageView.setImageResource(mWonderModel.getImageResourceId());
//        holder.coverImageView.setTag(mWonderModel.getImageResourceId());
//        holder.likeImageView.setTag(R.drawable.ic_like);

        final Person mPerson = list.get(position);


        holder.titleTextView.setText(mPerson.getName());
        holder.coverImageView.setImageResource(mPerson.getImageResourceId());
        holder.coverImageView.setTag(mPerson.getImageResourceId());
        holder.likeImageView.setTag(R.drawable.ic_like);

    }

    @Override
    public int getItemCount()
    {
        return list.size();
    }


    public static class CardViewHolder extends RecyclerView.ViewHolder
    {

        public TextView titleTextView;
        public ImageView coverImageView;
        public ImageView likeImageView;
        public ImageView shareImageView;
        public Context mContext;

        public CardViewHolder(View v)
        {
            super(v);
            titleTextView = (TextView) v.findViewById(R.id.titleTextView);
            coverImageView = (ImageView) v.findViewById(R.id.coverImageView);
            likeImageView = (ImageView) v.findViewById(R.id.likeImageView);
            shareImageView = (ImageView) v.findViewById(R.id.shareImageView);
            mContext = MainActivity.getContext();

            likeImageView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {


                    int id = (int) likeImageView.getTag();
                    if (id == R.drawable.ic_like)
                    {

                        likeImageView.setTag(R.drawable.ic_liked);
                        likeImageView.setImageResource(R.drawable.ic_liked);

                        Toast.makeText(mContext, titleTextView.getText() + " added to favourites",
                                Toast.LENGTH_SHORT).show();

                    }
                    else
                    {

                        likeImageView.setTag(R.drawable.ic_like);
                        likeImageView.setImageResource(R.drawable.ic_like);
                        Toast.makeText(mContext, titleTextView.getText() + " removed from favourites",
                                Toast.LENGTH_SHORT).show();


                    }

                }
            });


            shareImageView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {


                    Uri imageUri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE +
                            "://" + mContext.getResources().getResourcePackageName(coverImageView.getId())
                            + '/' + "drawable" + '/' +
                            mContext.getResources().getResourceEntryName((int) coverImageView.getTag()));


                    Intent shareIntent = new Intent();
                    shareIntent.setAction(Intent.ACTION_SEND);
                    shareIntent.putExtra(Intent.EXTRA_STREAM, imageUri);
                    shareIntent.setType("image/jpeg");
                    mContext.startActivity(Intent.createChooser(shareIntent, mContext.getResources().getText(R.string.send_to)));


                }
            });


        }
    }
}