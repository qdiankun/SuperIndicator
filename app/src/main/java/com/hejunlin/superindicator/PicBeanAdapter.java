package com.hejunlin.superindicator;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by hejunlin on 2016/8/25.
 */
public class PicBeanAdapter extends PagerAdapter {

    private Context mContext;
    private List<BannerBean> mBannerList;

    private static final String TAG = PicBeanAdapter.class.getSimpleName();

    public PicBeanAdapter(Context context, List<BannerBean> lists) {
        this.mContext = context;
        this.mBannerList = lists;
    }

    @Override
    public int getCount() {
        return mBannerList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup view, int position, Object object) {
        view.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        BannerBean bannerBean = mBannerList.get(position);
        Log.i(TAG, "->> bannerBean = " + bannerBean.toString());

        View view = LayoutInflater.from(mContext.getApplicationContext()).inflate(R.layout.recommend_page_item, container, false);
        ImageView imageView = (ImageView) view.findViewById(R.id.image);
        TextView textView = (TextView) view.findViewById(R.id.image_desc);
        textView.setText(bannerBean.getTitie());
        Glide.with(mContext).load(bannerBean.getUrl()).into(imageView);
        container.addView(view);
        return view;
    }
}
