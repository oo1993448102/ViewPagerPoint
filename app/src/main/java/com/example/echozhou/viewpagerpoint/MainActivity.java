package com.example.echozhou.viewpagerpoint;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager view_pager;
    private LinearLayout ll_point;
    private List<View> views;
    private List<Integer> nums;
    private int page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        view_pager = (ViewPager) findViewById(R.id.view_pager);
        ll_point = (LinearLayout) findViewById(R.id.ll_point);
        views = new ArrayList<View>();
        nums = new ArrayList<Integer>();
        LayoutInflater inflater = getLayoutInflater();
        for (int i = 0; i <= 10; i++) {
            nums.add(i);
        }
        if (nums.size() % 3 == 0) {
            page = nums.size() / 3;
        } else {
            page = (nums.size() / 3) + 1;
        }
        for (int j = 0; j < page; j++) {
            View v = inflater.inflate(R.layout.adapter_view_pager, null);
            TextView tv_one = (TextView) v.findViewById(R.id.tv_one);
            TextView tv_two = (TextView) v.findViewById(R.id.tv_two);
            TextView tv_three = (TextView) v.findViewById(R.id.tv_three);
            if(3*j<nums.size()) {
                tv_one.setText(nums.get(3 * j) + "");
            }
            if(3*j+1<nums.size()) {
                tv_two.setText(nums.get(3 * j + 1) + "");
            }
            if(3*j+2<nums.size()) {
                tv_three.setText(nums.get(3 * j + 2) + "");
            }
            views.add(v);
        }
        MyPagerAdapter adapter = new MyPagerAdapter(views,nums);
        view_pager.setAdapter(adapter);

        initPoint();

        view_pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                backPoint();
                ImageView point = (ImageView) ll_point.getChildAt(position);
                point.setImageResource(R.drawable.gray_point);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void backPoint() {
        for (int i = 0; i < page; i++) {
            ImageView point = (ImageView) ll_point.getChildAt(i);
            point.setImageResource(R.drawable.orange_point);
        }
    }

    private void initPoint() {
        for (int i = 0; i < page; i++) {
            final ImageView imageView = new ImageView(this);
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            imageView.setPadding(2,2,2,2);
            if(i == 0){
                imageView.setImageResource(R.drawable.gray_point);
            }
            else {
                imageView.setImageResource(R.drawable.orange_point);
            }
            ll_point.addView(imageView);
        }
    }
}
