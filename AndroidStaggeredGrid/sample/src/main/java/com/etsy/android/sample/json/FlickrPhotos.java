package com.etsy.android.sample.json;

import net.vvakame.util.jsonpullparser.annotation.JsonKey;
import net.vvakame.util.jsonpullparser.annotation.JsonModel;

import java.util.List;

/**
 * Created by shunsuke_andoh on 2014/06/23.
 */
// decamelize=true : xxx_yyy -> xxxYyyへ変換します。
@JsonModel(decamelize = true)
public class FlickrPhotos {
    @JsonKey
    private int page;
    @JsonKey
    private int pages;
    @JsonKey
    private int perpage;
    @JsonKey
    private List<FlickrPhoto> photo;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPerpage() {
        return perpage;
    }

    public void setPerpage(int perpage) {
        this.perpage = perpage;
    }

    public void setPhoto(List<FlickrPhoto> photo) { this.photo = photo; }
    public List<FlickrPhoto> getPhoto() { return this.photo; }
}
