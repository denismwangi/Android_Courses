package com.example.learning_frag.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.List;

public class MasterListAdapter extends BaseAdapter {

    private Context mcontext;
    private List<Integer> mImageIds;

    public MasterListAdapter(Context mcontext, List<Integer> mImageIds) {
        this.mcontext = mcontext;
        this.mImageIds = mImageIds;
    }

    @Override
    public int getCount() {
        return mImageIds.size();
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null){
            //if this image view is not recycled it creates a new imageview to hold an image;
            imageView = new ImageView(mcontext);

            //define the layout params
            imageView.setAdjustViewBounds(true);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8,8,8,8);
        }else{
            imageView = (ImageView) convertView;
        }
        //set the image resource and return the new created imageview
        imageView.setImageResource(mImageIds.get(position));
        return imageView;
    }
}
