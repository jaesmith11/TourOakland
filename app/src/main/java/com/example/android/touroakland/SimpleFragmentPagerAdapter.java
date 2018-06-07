package com.example.android.touroakland;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


/**
 * Created by James on 5/22/18.
 */

public class SimpleFragmentPagerAdapter  extends FragmentPagerAdapter {
    //Create context and string array to store tab titles
    //https://stackoverflow.com/questions/43264599/need-to-convert-a-string-resource-to-string-within-a-viewpager?utm_medium=organic&utm_source=google_rich_qa&utm_campaign=google_rich_qa
    private Context mContext;
    private String[] tabTitles;

    //Context parameter is added to constructor so array is accessible via getResources()
    public SimpleFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.mContext = context;
        tabTitles = mContext.getResources().getStringArray(R.array.tab_titles);
    }

    //Create new fragments based on position
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new OutdoorFragment();
            case 1:
                return new ArtFragment();
            case 2:
                return new NightFragment();
            case 3:
                return new ShopFragment();
        }
        return null;
    }

    //Specify number of tabs
    @Override
    public int getCount() {
        return 4;
    }

    //Populate title of tabs based on String[] tabTitles
    @Override
    public CharSequence getPageTitle(int position) {
    return tabTitles[position];
    }
}
