package com.donglin.smartff.mvp.ui.fragments;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.donglin.smartff.R;
import com.donglin.smartff.mvp.base.BaseFragment;
import com.donglin.smartff.mvp.ui.adapter.MyFragmentPagerAdapter;
import com.donglin.smartff.mvp.ui.adapter.MyRecyclerViewAlarmDateAdapter;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/1/12 0012.
 */

public class AlarmFargment extends BaseFragment {
    /*    @BindView(R.id.toolbar)
        Toolbar toolbar;*/
    @BindView(R.id.collapsingToolbar)
    CollapsingToolbarLayout collapsingToolbar;
    @BindView(R.id.toolbar_switch_type)
    ImageView mToolbarSwitchType;
    @BindView(R.id.tabLayout)
    TabLayout mTabLayout;
    @BindView(R.id.alarm_appbar)
    AppBarLayout mAlarmAppbar;
    @BindView(R.id.alarm_recyeler_header)
    RecyclerView mAlarmRecyelerHeader;
    @BindView(R.id.alarm_viewpager)
    ViewPager mAlarmViewpager;
    /**
     * Fragment集合
     */


    private CollapsingToolbarLayoutState state;
    private MyRecyclerViewAlarmDateAdapter myExcelRecyclerViewAdapter;


    private enum CollapsingToolbarLayoutState {
        EXPANDED,
        COLLAPSED,
        INTERNEDIATE
    }

    @Override
    protected void initOnclickView() {
        mAlarmAppbar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (verticalOffset == 0) {
                    if (state != CollapsingToolbarLayoutState.EXPANDED) {
                        state = CollapsingToolbarLayoutState.EXPANDED;//修改状态标记为展开
                        collapsingToolbar.setTitle("展开");//设置title为EXPANDED
                    }
                } else if (Math.abs(verticalOffset) >= appBarLayout.getTotalScrollRange()) {
                    if (state != CollapsingToolbarLayoutState.COLLAPSED) {
                        collapsingToolbar.setTitle("折叠");//设置title不显示

                        // playButton.setVisibility(View.VISIBLE);//隐藏播放按钮
                        state = CollapsingToolbarLayoutState.COLLAPSED;//修改状态标记为折叠
                    }
                } else {
                    if (state != CollapsingToolbarLayoutState.INTERNEDIATE) {
                       /* if(state == CollapsingToolbarLayoutState.COLLAPSED){
                            playButton.setVisibility(View.GONE);//由折叠变为中间状态时隐藏播放按钮
                        }*/
                        collapsingToolbar.setTitle("中间位置");//设置title为INTERNEDIATE
                        state = CollapsingToolbarLayoutState.INTERNEDIATE;//修改状态标记为中间
                    }
                }
            }
        });


    }

    @Override
    protected void setupFragmentComponent() {

    }

    @Override
    public void initData() {

    }

    @Override
    protected void initView() {
        mToolbarSwitchType.setVisibility(View.VISIBLE);


        myExcelRecyclerViewAdapter = new MyRecyclerViewAlarmDateAdapter(mContext);
        mAlarmRecyelerHeader.setLayoutManager(new GridLayoutManager(getContext(), 2));
        mAlarmRecyelerHeader.setItemAnimator(new DefaultItemAnimator());
        mAlarmRecyelerHeader.setAdapter(myExcelRecyclerViewAdapter);
        myExcelRecyclerViewAdapter.setmLists(list);
        mAlarmViewpager.setAdapter(new MyFragmentPagerAdapter(getChildFragmentManager(), mFragment, list));
        mTabLayout.setupWithViewPager(mAlarmViewpager);
    }

    @Override
    public int getLayoutView() {
        return R.layout.fragment_home_alarm;
    }


}
