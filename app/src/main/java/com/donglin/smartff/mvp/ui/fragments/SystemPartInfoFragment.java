package com.donglin.smartff.mvp.ui.fragments;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.donglin.smartff.R;
import com.donglin.smartff.mvp.base.BaseFragment;
import com.donglin.smartff.mvp.ui.adapter.MyFragmentPagerAdapter;
import com.donglin.smartff.mvp.ui.adapter.MyRecyclerViewSysOrgInfoAdapter;

import butterknife.BindView;
import recycler.coverflow.CoverFlowLayoutManger;
import recycler.coverflow.RecyclerCoverFlow;

/**
 * Created by Administrator on 2018/1/15 0015.
 */

public class SystemPartInfoFragment extends BaseFragment {
    @BindView(R.id.sys_recyeler_header)
    RecyclerCoverFlow sysRecyelerHeader;
    @BindView(R.id.sys_viewpager)
    ViewPager mSysViewpager;
    @BindView(R.id.tabLayout)
    TabLayout mTabLayout;
    private MyRecyclerViewSysOrgInfoAdapter myRecyclerViewSysOrgInfoAdapter;

    @Override
    protected void initOnclickView() {
        sysRecyelerHeader.setOnItemSelectedListener(new CoverFlowLayoutManger.OnSelected() {
            @Override
            public void onItemSelected(int position) {
             /*   ((TextView)findViewById(R.id.index)).setText((position+1)+"/"+mList.getLayoutManager().getItemCount());*/
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
        //recyclerView适配
        myRecyclerViewSysOrgInfoAdapter = new MyRecyclerViewSysOrgInfoAdapter(mContext);
        sysRecyelerHeader.setAdapter(myRecyclerViewSysOrgInfoAdapter);
        myRecyclerViewSysOrgInfoAdapter.setmLists(list);
        //ViewPager适配
        mSysViewpager.setAdapter(new MyFragmentPagerAdapter(getChildFragmentManager(), mFragment, sysList));
        mTabLayout.setupWithViewPager(mSysViewpager);

    }

    @Override
    public int getLayoutView() {
        return R.layout.fragment_home_sys;
    }

}
