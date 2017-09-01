package com.example.liuale.myyoutubeappdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import com.google.android.youtube.player.YouTubeBaseActivity;

import java.util.ArrayList;

public class MainActivity extends YouTubeBaseActivity
{
    public static final int GONE = 0x00000008;
    public static final int VISIBLE = 0x00000000;

    ArrayList<YoutubeVideoItem> listitems = new ArrayList<>();
    RecyclerView MyRecyclerView;
//    String Wonders[] = {"Chichen Itza","Christ the Redeemer","Great Wall of China","Machu Picchu","Petra","Taj Mahal","Colosseum"};
//    int  Images[] = {R.drawable.chichen_itza,R.drawable.christ_the_redeemer,R.drawable.great_wall_of_china,R.drawable.machu_picchu,R.drawable.petra,R.drawable.taj_mahal,R.drawable.colosseum};

    private static Context context;

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.fragment_card);
        //initializeList();
        setTitle("7 Wonders in Modern World");

        MyRecyclerView = (RecyclerView) findViewById(R.id.cardView);
        MyRecyclerView.setHasFixedSize(true);

        LinearLayoutManager MyLinearLayoutManager = new LinearLayoutManager(this);
        MyLinearLayoutManager.setOrientation(LinearLayout.VERTICAL);

        if(listitems.size() > 0 & MyRecyclerView != null) {
            MyRecyclerView.setAdapter(new MyAdapter(listitems));
        }
        MyRecyclerView.setLayoutManager(MyLinearLayoutManager);

        context = getBaseContext();

    }

    public static Context getAppContext(){
        return context;
    }



//    public void initializeList() {
//        listitems.clear();
//
//        for(int i =0;i<7;i++){
//            WonderModel item = new WonderModel();
//            item.setCardName(Wonders[i]);
//            item.setImageResourceId(Images[i]);
//            item.setIsfav(0);
//            item.setIsturned(0);
//            listitems.add(item);
//        }
//    }
}
