package com.example.alphatabsample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.alphatabsample.model.Item;

import java.util.List;

public class AlphaAdapter extends ArrayAdapter<Item> {
    private LayoutInflater layoutInflater;
    private List<Item> items;
    private int res;

    /**
     * コンストラクタ
     * @param context アクティビティかアプリケーションのコンテキスト
     * @param resource リストビューのリソースファイル
     * @param objects 表示するアイテムのリスト
     */
    public AlphaAdapter(Context context, int resource, List<Item> objects) {
        super(context, resource, objects);

        this.items = objects;
        this.res = resource;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = layoutInflater.inflate(this.res, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder)convertView.getTag();
        }

        Item item = items.get(position);

        viewHolder.title.setText(item.getTitle());
        viewHolder.subTitle.setText(item.getSubTitle());

        return convertView;
    }

    /**
     * リストビュー内のアイテム
     */
    private static class ViewHolder {
        private TextView title;
        private TextView subTitle;

        public ViewHolder(View v) {
            title = (TextView) v.findViewById(R.id.title);
            subTitle = (TextView) v.findViewById(R.id.subTitle);
        }
    }
}
