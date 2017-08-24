package com.androidtutorialpoint.listviewtutorial;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;


/**
 * Created by anonymous on 10/30/15.
 */
public class ListScientistsFragment extends Fragment {

    private final String TAG = "ListScientistFragment";

    private String[] scientistNames = {"Marie Curie","Thomas Edison","Albert Einstein","Michael Faraday","Galileo Galilei","Stephen Hawking","Johannes Kepler","Issac Newton","Nikola Tesla"};
    private String[] birthYear = {"1867","1847","1879","1791","1564","1942","1571","1643","1856"};
    private String[] deathYear = {"1934","1931","1955","1867","1642","Present","1630","1727","1943"};
    private int[] image = {R.drawable.curie,R.drawable.edison,R.drawable.einstein,R.drawable.faraday,R.drawable.hawking,R.drawable.kepler,R.drawable.newton,R.drawable.tesla};

    private ArrayList<Scientist> mScientists;
    private RecyclerView mScientistRecyclerView;
    private ScientistAdapter mAdapter;

    @Override
    public void onCreate(Bundle saveInstanceState){
        mScientists = new ArrayList<>();
        for(int i = 0; i <scientistNames.length; i++){
            Scientist s = new Scientist();
            s.setName(scientistNames[i]);
            s.getBirthYear(birthYear[i]);
            getSharedElementReturnTransition()
        }
    }

}

