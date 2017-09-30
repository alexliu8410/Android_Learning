package com.androidtutorialpoint.cardviewtutorial;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Person> listitems = new ArrayList<>();
    String Wonders[] = {"Chichen Itza","Christ the Redeemer","Great Wall of China","Machu Picchu","Petra","Taj Mahal","Colosseum"};
    int wonderModelImages[] = {R.drawable.chichen_itza,R.drawable.christ_the_redeemer,R.drawable.great_wall_of_china,R.drawable.machu_picchu,R.drawable.petra,R.drawable.taj_mahal,R.drawable.colosseum};
    int personImages[] = {R.drawable.jon_snow,R.drawable.arya_stark,R.drawable.bran_stark,R.drawable.rob_stark,R.drawable.ned_stark,R.drawable.ben_stark,R.drawable.lyanna_stark,R.drawable.sansa_stark,R.drawable.tony_stark};
    RecyclerView mRecyclerView;
    static Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = getBaseContext();
        gameOfThrone();
//        initializeList();


        mRecyclerView = (RecyclerView) findViewById(R.id.cardView);
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager MyLayoutManager = new LinearLayoutManager(this);
        MyLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);


        mRecyclerView.setLayoutManager(MyLayoutManager);
        mRecyclerView.setAdapter(new MyAdapter(listitems));

    }

    public static Context getContext(){
        return mContext;
    }

//    public void initializeList()
//    {
//        listitems.clear();
//
//        for (int i = 0; i < 7; i++)
//        {
//            WonderModel item = new WonderModel();
//            item.setCardName(Wonders[i]);
//            item.setImageResourceId(wonderModelImages[i]);
//            item.setIsfav(0);
//            item.setIsturned(0);
//            listitems.add(item);
//
//        }
//    }

    /*
     * Use of JSON File
     */

    public void gameOfThrone()
    {
        listitems.clear();
        String json;

        try
        {
            InputStream inputStream = mContext.getResources().openRawResource(R.raw.mock_card);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "UTF-8");

            JSONObject root = new JSONObject(json);
            JSONArray people = root.getJSONArray("children");

            String name;
            String imageUrl;
            int isFavor;
            int isTurned;
            int imageResourceId;

            for(int i = 0; i < people.length();i++)
            {
                JSONObject person = people.getJSONObject(i);

                name = person.getString("name");
                imageUrl = person.getString("imageUrl");
                isFavor = person.getInt("isfav");
                isTurned = person.getInt("isTurned");
                imageResourceId = personImages[i];

                Person temp = new Person();
                temp.withName(name).withImageUrl(imageUrl).withIsFavor(isFavor).withIsTurned(isTurned).withImageResourceId(imageResourceId);

                listitems.add(temp);
            }

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }

    }
}
