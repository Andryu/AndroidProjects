package com.sample.mvvm.app;

import android.os.Binder;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import gueei.binding.v30.app.BindingActivityV30;

public class MainActivity extends BindingActivityV30 {

    private MainViewModel mViewModel;
    private SparseArray<BallView> mBallViews = new SparseArray<>();
    private ViewGroup mStage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);
        Binder.init(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

}
