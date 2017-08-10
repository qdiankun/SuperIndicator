package com.hejunlin.superindicator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hejunlin.superindicatorlibray.CircleIndicator;
import com.hejunlin.superindicatorlibray.LoopViewPager;

import java.util.ArrayList;
import java.util.List;

public class TestNetActivity  extends AppCompatActivity {

    LoopViewPager viewpager;
    private CircleIndicator indicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_net);
        viewpager = (LoopViewPager) findViewById(R.id.viewpager);
        indicator = (CircleIndicator) findViewById(R.id.indicator);
        initPicBeanAdapter();
    }

    private void initPicBeanAdapter() {

        List<BannerBean> bannerList = new ArrayList<>();
        bannerList.add(new BannerBean("https://static.ecovacs.cn/upload/app/2017/08/03/20170803161023275.jpg", getString(R.string.a_name)));
        bannerList.add(new BannerBean("https://static.ecovacs.cn/upload/app/2017/03/02/20170302145228780.jpg", getString(R.string.b_name)));
        bannerList.add(new BannerBean("https://static.ecovacs.cn/upload/app/2017/01/13/20170113150153498.jpg", getString(R.string.c_name)));

        PicBeanAdapter picBeanAdapter = new PicBeanAdapter(this, bannerList);
        viewpager.setLooperPic(true);
        viewpager.setAdapter(picBeanAdapter);
        indicator.setViewPager(viewpager);
    }
}