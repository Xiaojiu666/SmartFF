package com.donglin.smartff.mvp.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.donglin.smartff.mvp.ui.fragments.OrgInfofragment;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/1/9 0009.
 */

public abstract class BaseFragment<T extends BasePresenterImpl> extends Fragment {

    @Inject
    protected T mPresenter;
    public Context mContext;

    // TODO: 2018/1/16 0016 模拟数据
    public List list = new ArrayList();
    public List<Fragment> mFragment = new ArrayList<Fragment>();
    public List sysList = new ArrayList();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutView(), null);
        ButterKnife.bind(this, view);
        mContext = getActivity();
        sysList.add("火灾报警系统");
        sysList.add("消防水系统");
        sysList.add("电气火灾监控系统");
        sysList.add("信息传输系统");
        sysList.add("视频监控系统");
        sysList.add("消防联动系统");
        for (int i = 0; i < 6; i++) {
            list.add(i + "号组织机构");
            mFragment.add(new OrgInfofragment());
        }
        initView();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupFragmentComponent();
        initData();
        initOnclickView();
    }

    protected abstract void initOnclickView();

    protected abstract void setupFragmentComponent();

    public abstract void initData();

    protected abstract void initView();

    public abstract int getLayoutView();
}
