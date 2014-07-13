package com.etsy.android.sample;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.etsy.android.grid.util.DynamicHeightImageView;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by shunsuke_andoh on 2014/06/22.
 */
public class DataAdapter  extends ArrayAdapter<Data>{

    private static class ViewHolder {
        DynamicHeightImageView image;
        TextView title;
        TextView description;
    }

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
        final ViewHolder holder;

        if(row == null) {
            LayoutInflater inflater = activity.getLayoutInflater();
            row = inflater.inflate(resource, parent, false);

            holder = new ViewHolder();
            holder.image = (DynamicHeightImageView)row.findViewById(R.id.image);
            holder.title = (TextView)row.findViewById(R.id.title);
            holder.description = (TextView)row.findViewById(R.id.description);

            row.setTag(holder);
        }
        else{
            holder = (ViewHolder) row.getTag();
        }
        final Data data = datas.get(position);
        holder.image.setHeightRatio(1.0);
        holder.image.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        Picasso.with(this.activity)
                .load(data.imageUrl)
                .placeholder(R.drawable.placeholder)
                .noFade()
                .into(holder.image);
        holder.title.setText(data.title);
        holder.description.setText(data.description);
        return row;
    }

}
