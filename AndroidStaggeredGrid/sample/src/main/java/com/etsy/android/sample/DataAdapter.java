package com.etsy.android.sample;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.etsy.android.grid.util.DynamicHeightImageView;

import java.util.List;

/**
 * Created by shunsuke_andoh on 2014/06/22.
 */
public class DataAdapter  extends ArrayAdapter<Data>{

    Activity activity;
    int resource;
    List<Data> datas;

    public DataAdapter(Activity activity, int resource, List<Data> objects) {
        super(activity, resource, objects);

        this.activity = activity;
        this.resource = resource;
        this.datas = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        final DealHolder holder;

        if(row == null) {
            LayoutInflater inflater = activity.getLayoutInflater();
            row = inflater.inflate(resource, parent, false);

            holder = new DealHolder();
            holder.image = (DynamicHeightImageView)row.findViewById(R.id.image);
            holder.title = (TextView)row.findViewById(R.id.title);
            holder.description = (TextView)row.findViewById(R.id.description);

            row.setTag(holder);
        }
        else{
            holder = (DealHolder) row.getTag();
        }
        final Data data = datas.get(position);
        //holder.image.setImageResource(R.drawable.ic_launcher);
        /*
        // 画像取得処理
        ImageListener listener = ImageLoader.getImageListener(
                //ImageView
                holder.image,
                //読込中画像
                android.R.drawable.ic_menu_rotate,
                //読み込み失敗画像
                android.R.drawable.ic_delete
        );


        mImageLoader.get(
                //取得URL
                url,
                //リスナー
                listener,
                //maxWidth
                100,
                //maxHeight
                100
        );
        */
        //holder.image.setHeightRatio(1.0);
        holder.title.setText(data.title);
        holder.description.setText(data.description);
        return row;
    }

    static class DealHolder {
        DynamicHeightImageView image;
        TextView title;
        TextView description;
    }
}
