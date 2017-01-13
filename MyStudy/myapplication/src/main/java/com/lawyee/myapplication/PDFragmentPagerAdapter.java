package com.lawyee.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.lawyee.myapplication.fragment.CommentFragment;
import com.lawyee.myapplication.fragment.DetailsFragment;
import com.lawyee.myapplication.fragment.ProductFragment;


/**
 * @Author : YFL  is Creating a porject in YFPHILPS
 * @Email : yufeilong92@163.com
 * @Time :2017/1/13 12:53
 * @Purpose :
 */
public class PDFragmentPagerAdapter extends FragmentPagerAdapter {
    private String[] mTitles;

    public PDFragmentPagerAdapter(FragmentManager fm, String[] mTitles) {
        super(fm);
        this.mTitles = mTitles;
    }

    @Override
    public Fragment getItem(int position) {

        if (position == 0) {
            return new ProductFragment();
        } else if (position == 1) {
            return new DetailsFragment();
        } else if (position == 2) {
            return new CommentFragment();
        }

        return new ProductFragment();
    }

    @Override
    public int getCount() {
        return mTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}
