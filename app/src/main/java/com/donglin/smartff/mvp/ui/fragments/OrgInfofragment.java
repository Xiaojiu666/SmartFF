package com.donglin.smartff.mvp.ui.fragments;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.donglin.smartff.R;
import com.donglin.smartff.mvp.base.BaseFragment;
import com.donglin.smartff.mvp.ui.adapter.MyRecyclerViewAlarmDateAdapter;
import com.donglin.smartff.mvp.ui.adapter.MyOrgAlarmInfoRecyclerViewAdapter;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/1/12 0012.
 */

public class OrgInfofragment extends BaseFragment {
    @BindView(R.id.org_recycelt_View)
    RecyclerView mOrgRecycleView;
    private MyOrgAlarmInfoRecyclerViewAdapter myOrgAlarmInfoRecyclerViewAdapter;
    private MyRecyclerViewAlarmDateAdapter myExcelRecyclerViewAdapter;


    @Override
    protected void initOnclickView() {

    }

    @Override
    protected void setupFragmentComponent() {

    }

    @Override
    public void initData() {

    }

    @Override
    protected void initView() {
        myOrgAlarmInfoRecyclerViewAdapter = new MyOrgAlarmInfoRecyclerViewAdapter(mContext);
        mOrgRecycleView.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL, false));
        mOrgRecycleView.setItemAnimator(new DefaultItemAnimator());
        mOrgRecycleView.setAdapter(myOrgAlarmInfoRecyclerViewAdapter);
        myOrgAlarmInfoRecyclerViewAdapter.setmLists(list);
    }

    @Override
    public int getLayoutView() {
        return R.layout.fragment_home_alarm_list;
    }
}
