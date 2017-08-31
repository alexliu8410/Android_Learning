package com.example.liuale.myyoutubeappdemo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

/**
 * Created by liuale on 8/30/17.
 */

public class YouTubePlayActivity extends YouTubeBaseActivity
{
    public static final String DEVELOPER_KEY = "AIzaSyBfRPX7aDEOUqFuARP3uA0rtVsXYGvGFY8";
    private static final String VIDEO_ID = "srH-2pQdKhg";
    private static final int RECOVERY_DIALOG_REQUEST = 1;

    private YouTubePlayerView mYouTubePlayerView;
    Button mButton;
    private YouTubePlayer.OnInitializedListener mOnInitializedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.youtubeplayer);

        mYouTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube_view);
        mOnInitializedListener = new YouTubePlayer.OnInitializedListener(){
            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult errReason){
                System.out.print("Error in getting Resource");
            }

            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored){
                player.loadVideo(VIDEO_ID);
            }
        };

        mYouTubePlayerView.initialize(DEVELOPER_KEY,mOnInitializedListener);

    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == RECOVERY_DIALOG_REQUEST){
            getYouTubePlayerProvider().initialize(DEVELOPER_KEY, mOnInitializedListener);
        }
    }

    protected YouTubePlayer.Provider getYouTubePlayerProvider(){
        return (YouTubePlayerView) findViewById(R.id.youtube_view);
    }
}
