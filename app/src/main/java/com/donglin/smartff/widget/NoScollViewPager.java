package com.donglin.smartff.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by Administrator on 2018/1/9 0009.
 */

public class NoScollViewPager extends ViewPager {
    public NoScollViewPager(Context context) {
        super(context);
    }

    public NoScollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    //设置viewpager向下传递事件
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }
    //返回true,表示将viewpager的滑动事件拦截
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return true;
    }
}
