package com.etsy.android.sample.json;

import net.vvakame.util.jsonpullparser.annotation.JsonKey;
import net.vvakame.util.jsonpullparser.annotation.JsonModel;

/**
 * Created by shunsuke_andoh on 2014/07/13.
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
