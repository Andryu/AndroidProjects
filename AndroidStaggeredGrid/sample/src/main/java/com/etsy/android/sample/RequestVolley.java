package com.etsy.android.sample;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.util.Log;
import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by shunsuke_andoh on 2014/06/07.
 */
public class RequestVolley {

    //Volleyでリクエスト時に設定するタグ名。キャンセル時に利用する。
    private static final Object TAG_REQUEST_QUEUE = new Object();
    private static final String TAG = "RequestVolley";
    private RequestQueue mRequestQueue;

    public RequestVolley(Context context) {
        this.mRequestQueue = Volley.newRequestQueue(context);
    }

    /*
     * HTTPリクエストを投げる(JsonObjectを取得)
     */
    public void requestJsonObject(String url) {
        mRequestQueue.add(new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        // JSONObjectのパース, ListView, Viewへの追加等

                        if(jsonObject.toString() == "") return;
                        Log.d(TAG, "Request JSON " + jsonObject.toString());
                    }
                },
        new Response.ErrorListener() {
            @Override public void onErrorResponse(VolleyError error) {
                // エラー処理 error.networkResponseで確認
                // エラー表示
                Log.d(TAG, "Request Error " + error.toString());
            }
        }));

    }

    /*
     * HTTPリクエストを投げる(JSONArray)
     */
    public void requestJsonArray(String url){
        JsonArrayRequest request = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>(){
                    @Override
                    public void onResponse(JSONArray response) {

                        int length = response.length();

                        //レスポンス受け取り時の処理
                        if (length <= 0){
                            //空の場合
                            return;
                        }

                        for(int i = 0; i < length; i++){
                            try {
                                Integer value = (Integer)response.get(i);
                                //Log.d(TAG_LOG, value.toString());
                            } catch (JSONException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                        }

                        //
                        //Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_LONG).show();

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        //エラー時の処理
                        //Toast.makeText(getApplicationContext(), "onErrorResponse", Toast.LENGTH_LONG).show();

                    }
                }
        );
        //タグを設定する
        request.setTag(TAG_REQUEST_QUEUE);

        //リクエスト＆レスポンス情報の設定を追加
        mRequestQueue.add(request);

        //リクエスト開始
        mRequestQueue.start();
    }

    /*
     * HTTPリクエストを投げる(画像を取得する)
     */
    public void requestImage(String url, ImageView imageView){

        //ImageView を取得する
        final ImageView image = imageView;//(ImageView)findViewById(R.id.image);

        ImageRequest request = new ImageRequest(url,
                //レスポンス結果リスナー
                new Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap bm) {
                        image.setImageBitmap(bm);
                    }
                },
                //最大の幅。指定無しは0
                0,
                //最大の高さ。指定無しは0
                0,
                //デコードするフォーマット
                Config.ARGB_8888,
                //エラー時のリスナー（無視する場合にはnull)
                new Response.ErrorListener() {
                    public void onErrorResponse(VolleyError e) {
                        e.printStackTrace();
                    }
                }
        );
        //タグを設定する
        request.setTag(TAG_REQUEST_QUEUE);

        //リクエスト＆レスポンス情報の設定を追加
        mRequestQueue.add(request);

        //リクエスト開始
        mRequestQueue.start();
    }

    public void cancelAll() {
        mRequestQueue.cancelAll(TAG_REQUEST_QUEUE);
    }
}
