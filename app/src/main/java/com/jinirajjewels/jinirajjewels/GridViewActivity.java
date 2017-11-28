package com.jinirajjewels.jinirajjewels;

/**
 * Created by rashil on 24/11/17.
 */


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;


public class GridViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.content_main);
        GridView gridView = (GridView) findViewById(R.id.usage_example_gridview);

        gridView.setAdapter(
                new SimpleImageListAdapter(
                        GridViewActivity.this,
                        ListViewActivity.eatFoodyImages
                )
        );
    }
}
