package com.example.jsonplaceholder.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;

import com.example.jsonplaceholder.Adapters.DetailsPagerAdapter;
import com.example.jsonplaceholder.R;
import com.example.jsonplaceholder.data.usermodel.UserModel;
import com.google.android.material.tabs.TabLayout;

import java.util.List;

public class DetailsActivity extends AppCompatActivity {

    private static final String TAG = "DetailsActivity";
    private UserModel model;
    private ViewPager mViewPager;
    private DetailsPagerAdapter mAdapter;

    public static void startDetailsActivity(Activity source , UserModel model){
        Intent detailsIntent = new Intent(source , DetailsActivity.class);
        detailsIntent.putExtra(TAG , model);
        source.startActivity(detailsIntent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();
        model = intent.getParcelableExtra(TAG);
        Log.d(TAG , model .getUsername());


        setupViewPager();



    }

    private void setupViewPager() {

        mViewPager = findViewById(R.id.details_vp);
        mAdapter = new DetailsPagerAdapter(getSupportFragmentManager() , model.getId());
        mViewPager.setAdapter(mAdapter);
        TabLayout tabLayout = findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(mViewPager);

    }
}
