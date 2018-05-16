package com.example.javed.listview;

import android.app.Activity;
import android.content.res.Resources;
import android.media.Image;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends Activity {

    ListView list;
    String[] titles;
    String[] descriptions;
    int[] images = {R.drawable.dhaka_image, R.drawable.dhaka_image,
            R.drawable.dhaka_image, R.drawable.dhaka_image,
            R.drawable.dhaka_image, R.drawable.dhaka_image,
            R.drawable.dhaka_image, R.drawable.dhaka_image};
    CustomListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = (ListView) findViewById(R.id.list_view_1);
        Resources resource = getResources();
        titles = resource.getStringArray(R.array.Title);
        descriptions = resource.getStringArray(R.array.Description);
        adapter = new CustomListViewAdapter(this, titles, descriptions, images);
        list.setAdapter(adapter);
    }
}
