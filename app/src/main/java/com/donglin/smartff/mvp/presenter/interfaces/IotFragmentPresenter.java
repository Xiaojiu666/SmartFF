package com.donglin.smartff.mvp.presenter.interfaces;

import com.donglin.smartff.mvp.base.interfaces.BasePresenter;

/**
 * Created by Administrator on 2018/1/10 0010.
 */

public interface IotFragmentPresenter extends BasePresenter {

    void loadAlarmInfo4OneHours();

    void loadAlarmInfoChartData();
}
