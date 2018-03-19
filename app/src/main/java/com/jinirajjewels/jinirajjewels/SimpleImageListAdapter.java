package com.jinirajjewels.jinirajjewels;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by rashil on 24/11/17.
 */

public class SimpleImageListAdapter extends BaseAdapter {
    private Context mContext;
    private final int[] ImageId;
    private String[] text;

    private LayoutInflater inflater;


    public SimpleImageListAdapter(Context c, int[] ImageId, String[] text) {
        mContext = c;
        this.ImageId = ImageId;
        this.text = text;

    }


    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return text.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
       View grid;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            grid = new View(mContext);
            grid = inflater.inflate(R.layout.listview_item_image, null);
            TextView textView = (TextView) grid.findViewById(R.id.grid_text);
            ImageView imageView = (ImageView)grid.findViewById(R.id.grid_image);
            textView.setText(text[position]);
            imageView.setImageBitmap(ImageSizeReducer.decodeSampledBitmapFromResource(mContext.getResources(),ImageId[position],100,100));
        } else {
            grid = (View) convertView;
        }

        return grid;
    }
}
