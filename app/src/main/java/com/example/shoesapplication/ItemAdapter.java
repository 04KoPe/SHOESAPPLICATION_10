package com.example.shoesapplication;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

public class ItemAdapter extends BaseAdapter {

    public ItemAdapter(Context context, int layout, int layoutMess, List<Item> items) {
        this.context = context;
        this.layout = layout;
        this.layoutMess = layoutMess;
        this.items = items;
    }

    private Context context;
    private int layout;
    private int layoutMess;
    private List<Item> items;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public int getLayout() {
        return layout;
    }

    public void setLayout(int layout) {
        this.layout = layout;
    }

    public int getLayoutMess() {
        return layoutMess;
    }

    public void setLayoutMess(int layoutMess) {
        this.layoutMess = layoutMess;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(context).inflate(layout, null);
        ImageView productIMG = convertView.findViewById(R.id.shoesIMG);
        TextView productName = convertView.findViewById(R.id.shoesName);
        Item item = items.get(position);

        productIMG.setImageResource(item.getItemPhoto());
        productName.setText(item.getItemName());


        return convertView;
    }
}
