package com.sample.myapplication.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import java.util.List;
import android.view.View;
import android.widget.TextView;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

/**
 * Created by shunsuke_andoh on 2014/04/27.
 * Description Use CardItem Data Class for Array
 *
 * ArrayAdapter
 * ListView に表示されるアイテム（ レイアウトリソースの情報から生成された View ）内の "指定された１つの TextView にテキストをセットする" 為の Adapter
 *
 */
public class CardArrayAdapter extends ArrayAdapter<CardItem>{

    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public CardArrayAdapter(Context context, int resource, List<CardItem> objects) {
        super(context, resource, objects);

        mContext = context;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Viewは作成済みのものがあれば再利用
        if(convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.card_item, null);
        }

        // 行データ取得
        CardItem item = (CardItem) getItem(position);

        TextView title = (TextView) convertView.findViewById(R.id.card_title);
        title.setText(item.getTitleText());

        // アニメーション設定
        Animation anim;
        if(position % 2 == 0) {
            anim = AnimationUtils.loadAnimation(getContext(), R.anim.card_a);
        } else {
            anim = AnimationUtils.loadAnimation(getContext(), R.anim.card_b);
        }

        convertView.startAnimation(anim);

        return convertView;
    }
}
