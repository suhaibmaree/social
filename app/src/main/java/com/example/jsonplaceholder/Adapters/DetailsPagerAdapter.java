package com.example.jsonplaceholder.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.jsonplaceholder.views.fragments.AlbumsFragment;
import com.example.jsonplaceholder.views.fragments.PostsFragment;

public class DetailsPagerAdapter extends FragmentStatePagerAdapter {

    private static int NUM_ITEM = 2;
    private int id;

    public void setId(int id) {
        this.id = id;
    }


    public DetailsPagerAdapter(@NonNull FragmentManager fm, int id) {
        super(fm);
        this.id = id;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                return AlbumsFragment.newInstance(0 , "Albums" , id);
            case 1:
                return PostsFragment.newInstance(1 , "Posts" , id);
            default:
                return null;


        }

    }

    @Override
    public int getCount() {
        return NUM_ITEM;
    }


    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0)
            return "Albums";
        else
            return "Posts";
    }
}
