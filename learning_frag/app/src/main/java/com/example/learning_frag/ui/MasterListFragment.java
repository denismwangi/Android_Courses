package com.example.learning_frag.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.fragment.app.Fragment;

import com.example.learning_frag.R;
import com.example.learning_frag.data.AndroidImageAssets;

public class MasterListFragment extends Fragment {


    OnImageClickListener mCallbak;
    public interface OnImageClickListener{
        void OnImageSelected(int position);
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        try{
            mCallbak = (OnImageClickListener) context;

        }catch (ClassCastException e){
            throw new ClassCastException(context.toString() + "must implement imageOnclicklistener");
        }

    }

    //mandatoryfragment
    public MasterListFragment(){

    }
    // Inflates the GridView of all AndroidMe images
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.master_grid_layout, container, false);

        GridView gridView = (GridView) rootView.findViewById(R.id.images_grid_view);

        //create the adapter
        MasterListAdapter mAdapter = new MasterListAdapter(getContext(), AndroidImageAssets.getAll());

        //set the adapter on the gind view
        gridView.setAdapter(mAdapter);


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mCallbak.OnImageSelected(position);

            }
        });

        //return the root view
        return rootView;
    }


}
