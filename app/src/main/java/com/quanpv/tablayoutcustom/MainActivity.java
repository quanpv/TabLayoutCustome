package com.quanpv.tablayoutcustom;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private ViewPager view_pager;
    private TourDeTabLayout tab_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tab_layout = findViewById(R.id.tab_layout);
        tab_layout.setOnTabChangeListener(new TourDeTabLayout.SCTabChangeListener() {
            @Override
            public void onTabChange(int index, boolean isScroll) {
                view_pager.setCurrentItem(index);
            }
        });
        view_pager = findViewById(R.id.view_pager);
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        view_pager.setAdapter(pagerAdapter);
        view_pager.setOffscreenPageLimit(2);
        view_pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener(){

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tab_layout.highLightTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    public class PagerAdapter extends FragmentStatePagerAdapter {

        public PagerAdapter(FragmentManager fm){
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new BlankFragment();
                case 1:
                    return new BlankFragment();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 2;
        }
    }

}
