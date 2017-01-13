package com.lawyee.myapplication;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.titles)
    TabLayout titles;

    @BindView(R.id.vpPRODUNCTdatails)
    ViewPager vpprodiunctidata;
    private String[] mTitles = {"商品", "详情", "评论"};
    private TextView tv;
    private TextView tv2;
    private TextView tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initview();


    }

    private void initview() {

        initViewPager();
        initToobar();
    }

    private void initToobar() {
        titles.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorAccent));
        titles.addTab(titles.newTab().setCustomView(R.layout.layout1));
        tv = (TextView) findViewById(R.id.textview);
        tv.setText("商品");
        titles.addTab(titles.newTab().setCustomView(R.layout.layout2));
        tv2 = (TextView) findViewById(R.id.textview2);
        tv2.setText("详情");
        titles.addTab(titles.newTab().setCustomView(R.layout.layout3));
        tv3 = (TextView) findViewById(R.id.textview3);
        tv3.setText("评论");

        titles.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                vpprodiunctidata.setCurrentItem(position);
                switch(position)
                { case 0  :
                    tv.setTextColor(getResources().getColor(R.color.colorAccent));
                    break;
                    case 1:
                        tv2.setTextColor(getResources().getColor(R.color.colorAccent));
                        break;
                    case 2:
                        tv3.setTextColor(getResources().getColor(R.color.colorAccent));
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tv.setTextColor(getResources().getColor(R.color.colorPrimary));
                tv2.setTextColor(getResources().getColor(R.color.colorPrimary));
                tv3.setTextColor(getResources().getColor(R.color.colorPrimary));


            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void initViewPager() {
        vpprodiunctidata.setAdapter(new PDFragmentPagerAdapter(getSupportFragmentManager(), mTitles));
        vpprodiunctidata.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {

                titles.getTabAt(position).select();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }


}
