package com.example.ultraproject.ColorHelper;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.ultraproject.R;

public class ColorHelperActivity extends FragmentActivity {

    private static final int numberOfPages = 2;
    FragmentStateAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_helper);
        ViewPager2 viewPager2 = findViewById(R.id.viewpager);
        pagerAdapter = new ScreenSlidePagerAdapter(this);
        viewPager2.setAdapter(pagerAdapter);



    }

    private static class ScreenSlidePagerAdapter extends FragmentStateAdapter {
        public ScreenSlidePagerAdapter(FragmentActivity fa) {
            super(fa);
        }

        @Override
        public Fragment createFragment(int position) {
            switch (position){
                case 0:
                    return new CHRelatedFragment();
                case 1:
                    return new InfoFragment();
                default:
                    return null;
            }
        }

        @Override
        public int getItemCount() {
            return numberOfPages;
        }
    }
}