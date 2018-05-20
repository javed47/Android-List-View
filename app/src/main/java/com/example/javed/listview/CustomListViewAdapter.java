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

/**
 * The constructor is changeable
 * the main optimization is done in the getView method
 * the optimization is done in a way that after creating all the views once no other new views will create
 * only the previously built list views will be replaced by new ones
 */
class Item{
    String title;
    String description;
    int image;

    //this class is created for dry method of the data to be stored
    public Item(String title, String description, int image) {
        this.title = title;
        this.description = description;
        this.image = image;
    }
}

public class CustomListViewAdapter extends BaseAdapter {

    Context listViewContext;
    ArrayList<Item> single_row_items;

    //Constructor is changeable for other apps
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

        //if new list item to be created
        if(row == null) {
            //layout inflater is needed to create for wiring the View object with the xml file
            LayoutInflater inflater = (LayoutInflater)
                    listViewContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.single_row_for_list, parent, false);
            myViewHolder = new MyViewHolder(row);
            row.setTag(myViewHolder);
        }else {
            //else the tagged item should be reused
            myViewHolder = (MyViewHolder) row.getTag();
        }
        Item item =  single_row_items.get(position);
        myViewHolder.title.setText(item.title);
        myViewHolder.description.setText(item.description);
        myViewHolder.image.setImageResource(item.image);
        return row;
    }

    //this class is used for reusing the already built list items
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

