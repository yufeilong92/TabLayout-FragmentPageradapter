package com.lawyee.mystudy;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity  {

    @BindView(R.id.tablayout)
    TabLayout tablayout;

    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.activity_main)
    LinearLayout activityMain;
    private TabLayout mTablayout;
    private ViewPager mViewpager;
    private ArrayList<View> views;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
        setStatusBarColor();

    }

    private void setStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorAccent));
        }
    }

    private void initView() {
        mTablayout = (TabLayout) findViewById(R.id.tablayout);

        mTablayout.setOnTabSelectedListener(listener);
        mViewpager = (ViewPager) findViewById(R.id.viewpager);

        addtab();
        LayoutInflater inflater = LayoutInflater.from(getApplicationContext());
        View view = inflater.inflate(R.layout.layout1, null);
        View view1 = inflater.inflate(R.layout.layout2, null);
        View view2 = inflater.inflate(R.layout.layout3, null);
        views = new ArrayList<>();
        views.add(view);
        views.add(view1);
        views.add(view2);
        MypagerAdapter adapter = new MypagerAdapter();
        mTablayout.setupWithViewPager(mViewpager);
        mViewpager.setAdapter(adapter);
        mTablayout.getTabAt(1).select();

    }

    private void addtab() {
        int i = 3;
        for (int i1 = 0; i1 < i; i1++) {
            mTablayout.addTab(mTablayout.newTab().setText("你好 " + i1));
        }
    }

    private TabLayout.OnTabSelectedListener listener =new TabLayout.OnTabSelectedListener() {
    @Override
    public void onTabSelected(TabLayout.Tab tab) {
     Toast.makeText(MainActivity .this,"onTabSelected"+tab.getText(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
     Toast.makeText(MainActivity .this,"onTabUnselected"+tab.getText(),Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {
     Toast.makeText(MainActivity .this,"onTabReselected"+tab.getText(),Toast.LENGTH_SHORT).show();

    }
};



    class MypagerAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return views.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            container.addView(views.get(position));
            return views.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(views.get(position));
        }
    }

    ;

}
