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

    ArrayList<WonderModel> listitems = new ArrayList<>();
    RecyclerView MyRecyclerView;
    String Wonders[] = {"Chichen Itza","Christ the Redeemer","Great Wall of China","Machu Picchu","Petra","Taj Mahal","Colosseum"};
    int  Images[] = {R.drawable.chichen_itza,R.drawable.christ_the_redeemer,R.drawable.great_wall_of_china,R.drawable.machu_picchu,R.drawable.petra,R.drawable.taj_mahal,R.drawable.colosseum};

    static Context context;




    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.fragment_card);
        initializeList();
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


//    public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
//        private ArrayList<WonderModel> list;
//
//        public MyAdapter(ArrayList<WonderModel> Data) {
//            list = Data;
//        }
//
//        @Override
//        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//            // create a new view
//            View view = LayoutInflater.from(parent.getContext())
//                    .inflate(R.layout.recycle_items, parent, false);
//            MyViewHolder holder = new MyViewHolder(view);
//            return holder;
//        }
//
//        @Override
//        public void onBindViewHolder(final MyViewHolder holder, int position) {
//
//            holder.titleTextView.setText(list.get(position).getCardName());
//            holder.coverImageView.setImageResource(list.get(position).getImageResourceId());
//            holder.coverImageView.setTag(list.get(position).getImageResourceId());
//            holder.likeImageView.setTag(R.drawable.ic_like);
//
//        }
//
//        @Override
//        public int getItemCount() {
//            return list.size();
//        }
//    }

//    public class MyViewHolder extends RecyclerView.ViewHolder {
//
//        public TextView titleTextView;
//        public ImageView coverImageView;
//        public ImageView likeImageView;
//        public ImageView shareImageView;
//
//        public MyViewHolder(View v) {
//            super(v);
//            titleTextView = (TextView) v.findViewById(R.id.titleTextView);
//            coverImageView = (ImageView) v.findViewById(R.id.coverImageView);
//            likeImageView = (ImageView) v.findViewById(R.id.likeImageView);
//            shareImageView = (ImageView) v.findViewById(R.id.shareImageView);
//
//            coverImageView.setOnClickListener(new View.OnClickListener(){
//                @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
//                @Override
//                public void onClick(View view){
//                    coverImageView.setVisibility(View.GONE);
//                    titleTextView.setVisibility(View.GONE);
//                }
//            });
//
//
//            likeImageView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    int id = (int)likeImageView.getTag();
//                    if( id == R.drawable.ic_like){
//
//                        likeImageView.setTag(R.drawable.ic_liked);
//                        likeImageView.setImageResource(R.drawable.ic_liked);
//
//                        Toast.makeText(MainActivity.getAppContext(),titleTextView.getText()+" added to favourites",Toast.LENGTH_SHORT).show();
//
//                    }else{
//
//                        likeImageView.setTag(R.drawable.ic_like);
//                        likeImageView.setImageResource(R.drawable.ic_like);
//                        Toast.makeText(MainActivity.getAppContext(),titleTextView.getText()+" removed from favourites",Toast.LENGTH_SHORT).show();
//
//
//                    }
//
//                }
//            });
//
//
//
//            shareImageView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    Uri imageUri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE +
//                            "://" + getResources().getResourcePackageName(coverImageView.getId())
//                            + '/' + "drawable" + '/' + getResources().getResourceEntryName((int)coverImageView.getTag()));
//
//
//                    Intent shareIntent = new Intent();
//                    shareIntent.setAction(Intent.ACTION_SEND);
//                    shareIntent.putExtra(Intent.EXTRA_STREAM,imageUri);
//                    shareIntent.setType("image/jpeg");
//                    startActivity(Intent.createChooser(shareIntent, getResources().getText(R.string.send_to)));
//
//                }
//            });
//
//
//
//        }
//    }

    public void initializeList() {
        listitems.clear();

        for(int i =0;i<7;i++){
            WonderModel item = new WonderModel();
            item.setCardName(Wonders[i]);
            item.setImageResourceId(Images[i]);
            item.setIsfav(0);
            item.setIsturned(0);
            listitems.add(item);
        }
    }
}
