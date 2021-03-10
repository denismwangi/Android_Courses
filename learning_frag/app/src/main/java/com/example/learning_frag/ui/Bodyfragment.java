package com.example.learning_frag.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.learning_frag.R;
import com.example.learning_frag.data.AndroidImageAssets;

import java.util.ArrayList;
import java.util.List;

public class Bodyfragment extends Fragment {

    private static final String TAG = "BodyFragment";
    private static final String IMAGE_ID_LIST = "image_ids";
    private static final String LIST_INDEX = "list_index";

    private List<Integer> imgIds;
    private int mListIndex;

    public void setImgIds(List<Integer> imgIds) {
        this.imgIds = imgIds;
    }

    public void setmListIndex(int mListIndex) {
        this.mListIndex = mListIndex;
    }



    public Bodyfragment(){

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container ,@Nullable Bundle savedInstanceState) {
        View rootView =inflater.inflate(R.layout.body_fragment, container ,false);

        final ImageView imageView = (ImageView) rootView.findViewById(R.id.body_part_image_view);

       if(imgIds != null){
           imageView.setImageResource(imgIds.get(mListIndex));

           imageView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   if(mListIndex < imgIds.size()-1){
                       mListIndex++;
                   }else {
                       mListIndex = 0;
                   }
                   //set the resource for the image list item
                   imageView.setImageResource(imgIds.get(mListIndex));
               }
           });
       }
       else{
           Log.v(TAG, "this fragment has null images");
       }

        //return the rootview
        return rootView;

    }

    //set current state to this fragment
    @Override
    public void onSaveInstanceState(Bundle CurrentState){
        CurrentState.putIntegerArrayList(IMAGE_ID_LIST, (ArrayList<Integer>) imgIds);
        CurrentState.putInt(LIST_INDEX, mListIndex);

    }



}
