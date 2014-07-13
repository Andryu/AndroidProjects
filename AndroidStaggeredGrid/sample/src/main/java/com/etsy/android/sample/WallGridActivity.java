package com.etsy.android.sample;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageLoader.ImageCache;
import com.etsy.android.grid.StaggeredGridView;
import com.etsy.android.sample.common.SecretItems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class WallGridActivity extends Activity implements AbsListView.OnItemClickListener {

    //ログ出力時のタグ名
    private static final String TAG_LOG = "Log";
    //Volleyでリクエスト時に設定するタグ名。キャンセル時に利用する。
    private static final Object TAG_REQUEST_QUEUE = new Object();

    private RequestQueue mRequestQueue;
    //ImageLoader
    private ImageLoader mImageLoader;
    //ImageLoaderのキャッシュ
    private ImageCache mCache;
    //
    private ArrayList<HashMap> mHolderImages = new ArrayList<HashMap>();
    // スクロール中か
    private static Boolean sScrolling = false; //RequestQueueのインスタンス用

    /*
    Pinterest Demo
    */
    // GridView
    private StaggeredGridView mGridView;
    private DataAdapter mAdapter;
    private static final int SAMPLE_DATA_ITEM_COUNT = 10;

    // TODO
    private RequestVolley requestVolley;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wall_grid);

        // RequestQueue 初期化
        init();

        setTitle("Pinterest Layout Demo");
        mGridView = (StaggeredGridView) findViewById(R.id.grid_view);

        mAdapter = new DataAdapter(this, R.layout.list_item_sample, generateSampleData());
        mGridView.setAdapter(mAdapter);
        mGridView.setOnItemClickListener(this);
    }

    public void init() {
        // RequestQueue
        String BASE_URL = "https://api.flickr.com/services/rest/?method=flickr.photos.search";
        String api_key = SecretItems.API_FLICKR; // API Key
        String keyword = "blue";
        String text = "sky";
        requestVolley = new RequestVolley(this);
        requestVolley.requestJsonObject(BASE_URL + "&api_key=" + api_key + "&tag=" + keyword + "&text=" + text + "&format=json&nojsoncallback=1");
        //mRequestQueue = Volley.newRequestQueue(this);
        //requestJsonArray();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        Toast.makeText(this, "Item Clicked:" + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.wall_grid, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public static ArrayList<Data> generateSampleData() {
        String repeat = "repeat";
        final ArrayList<Data> datas = new ArrayList<Data>();
        for (int i = 0; i < SAMPLE_DATA_ITEM_COUNT; i++) {
            Data data = new Data();
            data.imageUrl = "https://jiresal-test.s3.amazonaws.com/deal3.png";
            data.title = "Pinterest Card";
            data.description = "Super awesome description";
            Random ran = new Random();
            int x = ran.nextInt(i + SAMPLE_DATA_ITEM_COUNT);
            for (int j = 0; j < x; j++)
                data.description += repeat;
            datas.add(data);
        }
        return datas;
    }
}
