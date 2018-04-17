package com.donglin.smartff.mvp.ui.view;

import com.donglin.smartff.mvp.base.interfaces.BaseView;
import com.donglin.smartff.mvp.model.entity.AlarmInfo4OneDay;

import java.util.List;

/**
 * Created by Administrator on 2018/1/10 0010.
 */

public interface IotView extends BaseView {

    void showAlarmInfo4OneHours(String data);

    void showAlarmInfoChart4OneDay(List<AlarmInfo4OneDay> data);
}
