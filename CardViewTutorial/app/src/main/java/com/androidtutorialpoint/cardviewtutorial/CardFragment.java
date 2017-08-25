package com.androidtutorialpoint.cardviewtutorial;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class CardFragment extends Fragment {

    ArrayList<WonderModel> listitems = new ArrayList<>();
    RecyclerView mRecyclerView;
    String Wonders[] = {"Chichen Itza","Christ the Redeemer","Great Wall of China","Machu Picchu","Petra","Taj Mahal","Colosseum"};
    int  Images[] = {R.drawable.chichen_itza,R.drawable.christ_the_redeemer,R.drawable.great_wall_of_china,R.drawable.machu_picchu,R.drawable.petra,R.drawable.taj_mahal,R.drawable.colosseum};

    @Override
    public void onCreate(@Nullable Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        initializeList();
        getActivity().setTitle("7 Wonders of the Modern World");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_card, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.card_view);
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(getActivity());
        mLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        if(listitems.size() > 0 & mRecyclerView != null){
            mRecyclerView.setAdapter(new MyAdapter(listitems));
        }
        mRecyclerView.setLayoutManager(mLinearLayoutManager);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle saveInstanceState){
        super.onActivityCreated(saveInstanceState);
    }

    private class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
        private ArrayList<WonderModel> mWonderModelArrayList;

        public MyAdapter(ArrayList<WonderModel> Data){
            mWonderModelArrayList = Data;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_items,parent,false);
            MyViewHolder holder = new MyViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, int position){

            holder.titleTextView.setText(listitems.get(position).getCardName());
            holder.coverImageView.setImageResource(listitems.get(position).getImageResourceId());
            holder.coverImageView.setTag(listitems.get(position).getImageResourceId());
            holder.likeImageView.setTag(R.drawable.ic_like);

        }

        @Override
        public int getItemCount(){
            return mWonderModelArrayList.size();
        }
    }

    private class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView titleTextView;
        public ImageView coverImageView;
        public ImageView likeImageView;
        public ImageView shareImageView;

        public MyViewHolder(View view){
            super(view);
            titleTextView = (TextView) view.findViewById(R.id.titleTextView);
            coverImageView = (ImageView) view.findViewById(R.id.coverImageView);
            likeImageView = (ImageView) view.findViewById(R.id.likeImageView);
            shareImageView = (ImageView) view.findViewById(R.id.shareImageView);

            likeImageView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){

                    int id = (int)likeImageView.getTag();
                    if(id == R.drawable.ic_like){

                        likeImageView.setTag(R.drawable.ic_liked);
                        likeImageView.setImageResource(R.drawable.ic_liked);

                        Toast.makeText(getActivity(),titleTextView.getText()+" add to favourites",Toast.LENGTH_SHORT).show();
                    } else {
                        likeImageView.setTag(R.drawable.ic_like);
                        likeImageView.setImageResource(R.drawable.ic_like);
                        Toast.makeText(getActivity(),titleTextView.getText()+" removed from favourites",Toast.LENGTH_SHORT).show();
                    }
                }
            });

            shareImageView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){

                    Uri imageUri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE +
                            "://" + getResources().getResourcePackageName(coverImageView.getId())
                            + '/' + "drawable" + '/' + getResources().getResourceEntryName((int)coverImageView.getTag()));

                    Intent shareIntent = new Intent();
                    shareIntent.setAction(Intent.ACTION_SEND);
                    shareIntent.putExtra(Intent.EXTRA_STREAM,imageUri);
                    shareIntent.setType("image/jpeg");
                    startActivity(Intent.createChooser(shareIntent,"Share"));
                }
            });
        }


    }

    public void initializeList() {
        listitems.clear();

        for(int i = 0; i < 7; i++){

            WonderModel wonderModel = new WonderModel();
            wonderModel.setCardName(Wonders[i]);
            wonderModel.setImageResourceId(Images[i]);
            wonderModel.setIsfav(0);
            wonderModel.setIsturned(0);
            listitems.add(wonderModel);
        }
    }


}
