package com.example.learning_frag.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.example.learning_frag.R;
import com.example.learning_frag.data.AndroidImageAssets;

public class AndroidMeActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.learning_frag.R.layout.activity_android_me);

     if(savedInstanceState == null){
         Bodyfragment headFragment = new Bodyfragment();

         headFragment.setImgIds(AndroidImageAssets.getHeads());
         headFragment.setmListIndex(1);

         FragmentManager fragmentManager = getSupportFragmentManager();
         fragmentManager.beginTransaction()
                 .add(R.id.heade_container, headFragment)
                 .commit();

         Bodyfragment bodyFragment = new Bodyfragment();
         bodyFragment.setImgIds(AndroidImageAssets.getBodies());
         fragmentManager.beginTransaction()
                 .add(R.id.body_container, bodyFragment)
                 .commit();

         Bodyfragment legFragment = new Bodyfragment();
         legFragment.setImgIds(AndroidImageAssets.getLegs());
         fragmentManager.beginTransaction()
                 .add(R.id.leg_container, legFragment)
                 .commit();
     }

    }
}
