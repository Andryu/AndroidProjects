package com.etsy.android.sample.json;

import net.vvakame.util.jsonpullparser.annotation.JsonKey;
import net.vvakame.util.jsonpullparser.annotation.JsonModel;

/**
 * Created by shunsuke_andoh on 2014/07/12.
 */
// decamelize=true : xxx_yyy -> xxxYyyへ変換します。
@JsonModel(decamelize = true)
public class FlickrPhoto {
    @JsonKey
    private String id;
    @JsonKey
    private int farm;
    @JsonKey
    private int isfamily;
    @JsonKey
    private int isfriend;
    @JsonKey
    private int ispublic;
    @JsonKey
    private String owner;
    @JsonKey
    private String secret;
    @JsonKey
    private String server;
    @JsonKey
    private String title;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getFarm() {
        return farm;
    }

    public void setFarm(int farm) {
        this.farm = farm;
    }

    public int getIsfamily() {
        return isfamily;
    }

    public void setIsfamily(int isfamily) {
        this.isfamily = isfamily;
    }

    public int getIsfriend() {
        return isfriend;
    }

    public void setIsfriend(int isfriend) {
        this.isfriend = isfriend;
    }

    public int getIspublic() {
        return ispublic;
    }

    public void setIspublic(int ispublic) {
        this.ispublic = ispublic;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
