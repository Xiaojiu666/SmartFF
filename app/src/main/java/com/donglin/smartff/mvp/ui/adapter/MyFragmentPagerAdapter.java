package com.donglin.smartff.mvp.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.donglin.smartff.utils.MLog;

import java.util.List;

/**
 * Created by Administrator on 2015/6/24.
 */
public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    private  List<String> titles;
    private List<Fragment> list;

    public MyFragmentPagerAdapter(FragmentManager fm, List<Fragment> list,List<String> titles) {
        super(fm);
        this.list = list;
        this.titles = titles;
    }

    public MyFragmentPagerAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (titles!=null){
            MLog.e(titles.get(position));
            return titles.get(position);
        }
        return super.getPageTitle(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

}
