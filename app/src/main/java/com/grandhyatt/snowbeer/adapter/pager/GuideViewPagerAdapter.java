package com.grandhyatt.snowbeer.adapter.pager;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.grandhyatt.snowbeer.utils.PackageUtils;
import com.grandhyatt.snowbeer.R;
import com.grandhyatt.snowbeer.utils.SPUtils;
import com.grandhyatt.snowbeer.view.activity.LoginActivity;

import java.util.List;


public class GuideViewPagerAdapter extends PagerAdapter {
    private static final String SHAREDPREFERENCES_NAME = "first_pref";

    // 界面列表
    private List<View> views;
    private Activity mActivity;


    public GuideViewPagerAdapter(List<View> views, Activity activity) {
        this.views = views;
        this.mActivity = activity;
    }

    // 销毁arg1位置的界面
    @Override
    public void destroyItem(View arg0, int arg1, Object arg2) {
        ((ViewPager) arg0).removeView(views.get(arg1));
    }

    @Override
    public void finishUpdate(View arg0) {
    }

    // 获得当前界面数
    @Override
    public int getCount() {
        if (views != null) {
            return views.size();
        }
        return 0;
    }

    // 初始化arg1位置的界面
    @Override
    public Object instantiateItem(View arg0, int arg1) {
        ((ViewPager) arg0).addView(views.get(arg1), 0);
        if (arg1 == views.size() - 1) {
            ImageView ivStart = arg0.findViewById(R.id.iv_start);
            ivStart.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 设置已经引导
                    setGuided();
                    toLoginActivity();
                }

            });
        }
        return views.get(arg1);
    }

    /**
     * 进入主界面
     */
    private void toLoginActivity() {
        mActivity.startActivity(new Intent(mActivity, LoginActivity.class));
        mActivity.finish();
        setGuided();
    }

    /**
     * method desc：设置已经引导过了，下次启动不用再次引导
     */
    private void setGuided() {
        SPUtils.setGuided(mActivity, PackageUtils.getPackageVersionCode(mActivity));
    }

    // 判断是否由对象生成界面
    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return (arg0 == arg1);
    }

    @Override
    public void restoreState(Parcelable arg0, ClassLoader arg1) {
    }

    @Override
    public Parcelable saveState() {
        return null;
    }

    @Override
    public void startUpdate(View arg0) {
    }

}
