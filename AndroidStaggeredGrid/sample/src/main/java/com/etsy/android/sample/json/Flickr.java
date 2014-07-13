package com.etsy.android.sample.json;

import net.vvakame.util.jsonpullparser.annotation.JsonKey;
import net.vvakame.util.jsonpullparser.annotation.JsonModel;

/**
 * Created by shunsuke_andoh on 2014/07/13.
 {
    "photos":
    {
        "page":1,
        "pages":3328,
        "perpage":100,
        "photo":
        [
            {
                "farm":4,
                "id":"14240666327",
                "isfamily":0,
                "isfriend":0,
                "ispublic":1,
                "owner":"8231395@N04",
                "secret":"51be2a1f64",
                "server":"3888",
                "title":"Orlando Wetlands Sunrise 3"
            },
            ...
        ]
    },
    "start":"ok"
 }
 */
@JsonModel(decamelize = true)
public class Flickr {
    @JsonKey
    private FlickrPhotos photos;
    @JsonKey
    private String stat;

    public FlickrPhotos getPhotos() {
        return photos;
    }

    public void setPhotos(FlickrPhotos photos) {
        this.photos = photos;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }
}
