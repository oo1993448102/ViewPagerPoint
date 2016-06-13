package com.example.echozhou.viewpagerpoint;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import java.util.List;

/**
 * Created by EchoZhou on 2016/6/12.
 */
public class MyPagerAdapter extends PagerAdapter {
    private List<View> views;
    private List<Integer> nums;

    public MyPagerAdapter(List<View> views, List<Integer> nums) {
        this.views = views;
        this.nums = nums;
    }

    @Override
    public int getCount() {
        return views.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(View container, int position) {
        ((ViewPager) container).addView((View) views.get(position), 0);
        return views.get(position);
    }

    @Override
    public void destroyItem(View container, int position, Object object) {
        ((ViewPager) container).removeView((View) views.get(position));
    }
}
