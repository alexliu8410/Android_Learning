package com.example.liuale.myyoutubeappdemo;

import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.youtube.YouTube;

import java.io.IOException;
/*
 * Created by liuale on 8/31/17.
 */

public class YoutubeDataManager
{
    private static final int NUMBER_OF_VIDEOS = 18;
    private static YouTube youtubeVideoData;
    private static final String CHANNEL_ID = "UCJX2nUYKjeq3S7ZoqzSyooA";
    private static YouTube.Search.List search;
    private YoutubeDataListener mYoutubeDataListener;
    private final NetHttpTransport mTransport;
    private final GsonFactory mJsonFactory;
    private final HttpRequestInitializer mHttpRequestInitializer;

    public YoutubeDataManager(YoutubeDataListener mYoutubeDataListner){
        this.mYoutubeDataListener = mYoutubeDataListner;
        mTransport = new NetHttpTransport();
        mJsonFactory = new GsonFactory();
        mHttpRequestInitializer = new HttpRequestInitializer()
        {
            @Override
            public void initialize(HttpRequest request) throws IOException
            {
                //No-op
            }
        };

        youtubeVideoData = new YouTube.Builder(mTransport,mJsonFactory,mHttpRequestInitializer).setApplicationName("Alex YouTube Demo").build();
    }
}
