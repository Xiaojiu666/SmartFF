package com.donglin.smartff.mvp.ui.fragments;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.donglin.smartff.LineChatSet;
import com.donglin.smartff.R;
import com.donglin.smartff.di.compoent.DaggerIotFragmentCom;
import com.donglin.smartff.di.moudle.IotFragmentMoudle;
import com.donglin.smartff.mvp.base.BaseFragment;
import com.donglin.smartff.mvp.model.entity.AlarmInfo4OneDay;
import com.donglin.smartff.mvp.presenter.IotFragmentPresenterImpl;
import com.donglin.smartff.mvp.ui.adapter.MyExcelRecyclerViewAdapter;
import com.donglin.smartff.mvp.ui.view.IotView;
import com.donglin.smartff.utils.MLog;
import com.donglin.smartff.widget.AutoVerticalViewDataData;
import com.donglin.smartff.widget.AutoVerticalViewView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import lecho.lib.hellocharts.view.LineChartView;

/**
 * Created by Administrator on 2018/1/9 0009.
 */

public class IotFragment extends BaseFragment<IotFragmentPresenterImpl> implements IotView {
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.toolbar_tv_orgname)
    TextView mToolbarTvOrgname;
    @BindView(R.id.tb)
    AutoVerticalViewView tb;
    @BindView(R.id.home_line_chart)
    LineChartView mHomeLineChart;
    @BindView(R.id.home_rec_org)
    RecyclerView mHomeRecOrg;

    public MyExcelRecyclerViewAdapter myExcelRecyclerViewAdapter;
    @BindView(R.id.toolbar_org_name)
    RelativeLayout mToolbarOrgName;



    @Override
    protected void initOnclickView() {
    }

    @Override
    protected void setupFragmentComponent() {
        DaggerIotFragmentCom.builder().iotFragmentMoudle(new IotFragmentMoudle(this)).build().inJect(this);
    }

    @Override
    public void initData() {
        mPresenter.onCreate();
    }

    @Override
    protected void initView() {
        mToolbarTvOrgname.setSelected(true);
        mToolbarOrgName.setVisibility(View.VISIBLE);
        mHomeRecOrg.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        mHomeRecOrg.setItemAnimator(new DefaultItemAnimator());
        myExcelRecyclerViewAdapter = new MyExcelRecyclerViewAdapter(mContext);
        mHomeRecOrg.setAdapter(myExcelRecyclerViewAdapter);
    }

    @Override
    public int getLayoutView() {
        return R.layout.fragment_home_iot;
    }

    @Override
    public void showPro() {

    }

    @Override
    public void disPro() {

    }

    @Override
    public void noNetShow() {

    }


    @Override
    public void showAlarmInfoChart4OneDay(List<AlarmInfo4OneDay> mAlarmInfo4Day) {
        for (int i = 0; i < mAlarmInfo4Day.size(); i++) {
            MLog.e(mAlarmInfo4Day.get(0).getTimes().size());
        }
        new LineChatSet(mHomeLineChart, mAlarmInfo4Day);
        myExcelRecyclerViewAdapter.setmLists(mAlarmInfo4Day);
    }

    @Override
    public void showAlarmInfo4OneHours(String datas) {


        final List data = new ArrayList();
        data.add(new AutoVerticalViewDataData("报警", "OBE互联网创新园1号火系统-点型烟感探测器火警", "1"));
        data.add(new AutoVerticalViewDataData("故障", "OBE互联网创新园1号火系统-点型烟感探测器故障", "2"));
        data.add(new AutoVerticalViewDataData("手报", "OBE互联网创新园1号火系统-点型烟感探测器手动报警", "3"));
        tb.setViews(data);

    }
}
