package com.donglin.smartff.mvp.presenter;

import com.donglin.smartff.utils.MColorArray;
import com.donglin.smartff.mvp.base.BasePresenterImpl;
import com.donglin.smartff.mvp.model.api.interfaces.IotFragmenApi;
import com.donglin.smartff.mvp.model.entity.AlarmInfo4OneDay;
import com.donglin.smartff.mvp.model.entity.Hour4AlarmSize;
import com.donglin.smartff.mvp.presenter.interfaces.IotFragmentPresenter;
import com.donglin.smartff.mvp.ui.view.IotView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;

/**
 * Created by Administrator on 2018/1/10 0010.
 */

public class IotFragmentPresenterImpl extends BasePresenterImpl<IotView, IotFragmenApi, String> implements IotFragmentPresenter {

    @Inject
    public IotFragmentPresenterImpl(IotView rootView, IotFragmenApi model) {
        super(rootView, model);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        loadAlarmInfo();
    }

    @Override
    public void success(String data) {
        super.success(data);
        mView.showAlarmInfo4OneHours(data);
    }

    @Override
    public void success2(String data) {
        super.success2(data);
        List<AlarmInfo4OneDay> list = new ArrayList<AlarmInfo4OneDay>();
        for (int i = 0; i < 4; i++) {
            AlarmInfo4OneDay alarmInfo4OneDay = new AlarmInfo4OneDay();
            alarmInfo4OneDay.setOrgName("OBE互联网创新园" + i);
            alarmInfo4OneDay.setOrgColor(MColorArray.getRandomColor());
            List hour4AlarmSizes = new ArrayList<Hour4AlarmSize>();
            for (int j = 0; j < 24; j++) {
                Hour4AlarmSize size4hours = new Hour4AlarmSize();
                size4hours.setTime(i + "H");
                size4hours.setSize(new Random().nextInt(100));
                hour4AlarmSizes.add(size4hours);
            }
            alarmInfo4OneDay.setTimes(hour4AlarmSizes);
            list.add(alarmInfo4OneDay);
        }

        mView.showAlarmInfoChart4OneDay(list);
    }

    private void loadAlarmInfo() {
        mApi.loadAlarmInfo4OneHour(this);
        mApi.loadAlarmChatInfo4OneDay(this);
    }

    @Override
    public void loadAlarmInfo4OneHours() {

    }

    @Override
    public void loadAlarmInfoChartData() {

    }
}
