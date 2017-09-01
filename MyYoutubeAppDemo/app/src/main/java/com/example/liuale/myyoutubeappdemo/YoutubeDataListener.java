package com.example.liuale.myyoutubeappdemo;

import java.util.List;

/**
 * Created by liuale on 8/31/17.
 */

public interface YoutubeDataListener
{
    void getNotified(List<YoutubeVideoItem> youtubeVideoList);
}
