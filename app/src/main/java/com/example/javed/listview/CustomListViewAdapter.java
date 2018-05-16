package com.example.javed.listview;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.javed.listview.R;

import java.util.ArrayList;
import java.util.List;

class Item{
    String title;
    String description;
    int image;

    public Item(String title, String description, int image) {
        this.title = title;
        this.description = description;
        this.image = image;
    }
}

public class CustomListViewAdapter extends BaseAdapter {

    Context listViewContext;
    ArrayList<Item> single_row_items;

    public CustomListViewAdapter(Context listViewContext, String[] titles, String[] descriptions, int[] images) {
        this.listViewContext = listViewContext;
        single_row_items = new ArrayList<Item>();
        for (int i = 0; i < 8; i++){
            single_row_items.add(new Item(titles[i], descriptions[i], images[i]));
        }
    }

    @Override
    public int getCount() {
        return single_row_items.size();
    }

    @Override
    public Object getItem(int position) {
        return single_row_items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        MyViewHolder myViewHolder;

        if(row == null) {
            LayoutInflater inflater = (LayoutInflater)
                    listViewContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.single_row_for_list, parent, false);
            myViewHolder = new MyViewHolder(row);
            row.setTag(myViewHolder);
        }else {
            myViewHolder = (MyViewHolder) row.getTag();
        }
        Item item =  single_row_items.get(position);
        myViewHolder.title.setText(item.title);
        myViewHolder.description.setText(item.description);
        myViewHolder.image.setImageResource(item.image);
        return row;
    }

    class MyViewHolder{
        TextView title;
        TextView description;
        ImageView image;

        public MyViewHolder(View view) {
            this.title = (TextView) view.findViewById(R.id.title_text);
            this.description = (TextView) view.findViewById(R.id.description_text);
            this.image = (ImageView) view.findViewById(R.id.logo_image);
        }
    }
}

