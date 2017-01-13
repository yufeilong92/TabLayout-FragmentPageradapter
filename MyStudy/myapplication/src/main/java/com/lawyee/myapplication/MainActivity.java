package com.lawyee.myapplication;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

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
public static final String TAG = "MainActivity";
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
                Log.e(TAG, "onTabSelected: " );
                int position = tab.getPosition();
                switch (position) {
                    case 0:
                        Toast.makeText(MainActivity.this, "你选中的" + tv.getText(), Toast.LENGTH_SHORT).show();
                        tv.setTextColor(getResources().getColor(R.color.colorAccent));
                        break;
                    case 1:
                        Toast.makeText(MainActivity.this, "你选中的" + tv2.getText(), Toast.LENGTH_SHORT).show();
                        tv2.setTextColor(getResources().getColor(R.color.colorAccent));
                        break;
                    case 2:
                        Toast.makeText(MainActivity.this, "你选中的" + tv3.getText(), Toast.LENGTH_SHORT).show();
                        tv3.setTextColor(getResources().getColor(R.color.colorAccent));
                        break;
                    default:
                        Log.e("====", "onTabSelected: "+position);
                        tv.setTextColor(getResources().getColor(R.color.colorAccent));
                        vpprodiunctidata.setCurrentItem(position);
                        break;
                }
            }



            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tv.setTextColor(getResources().getColor(R.color.colorPrimary));
                tv2.setTextColor(getResources().getColor(R.color.colorPrimary));
                tv3.setTextColor(getResources().getColor(R.color.colorPrimary));
                Log.e(TAG, "onTabUnselected: " );

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                Log.e(TAG, "onTabReselected: " );

            }
        });
        //设置选中
     titles.getTabAt(2).select();
    }

    private void initViewPager() {
        vpprodiunctidata.setAdapter(new PDFragmentPagerAdapter(getSupportFragmentManager(), mTitles));
        vpprodiunctidata.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
//            在页面滚动
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
//            选中页面
            public void onPageSelected(int position) {
                Log.e("=====", "onPageSelected: " );
                titles.getTabAt(position).select();
            }

            @Override
//            页面滚动改变中
            public void onPageScrollStateChanged(int state) {

            }
        });

    }


}
