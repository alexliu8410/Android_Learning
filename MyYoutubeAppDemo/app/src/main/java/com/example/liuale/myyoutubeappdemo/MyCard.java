package com.example.liuale.myyoutubeappdemo;

/**
 * Created by liuale on 8/28/17.
 */

public class MyCard
{

    protected String title;
    protected String date;
    protected String videoId;
    protected String videoUrl;

    public MyCard(String title, String date, String videoId, String videoUrl){
        this.title = title;
        this.date = date;
        this.videoId = videoId;
        this.videoUrl = videoUrl;
    }

    public String getTitle(){
        return title;
    }

    public String getDate(){
        return date;
    }

    public String getVideoId(){
        return videoId;
    }

    public String getVideoUrl(){
        return videoUrl;
    }
}