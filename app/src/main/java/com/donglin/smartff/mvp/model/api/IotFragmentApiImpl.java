package com.donglin.smartff.mvp.model.api;

import com.donglin.smartff.mvp.model.api.interfaces.IotFragmenApi;
import com.donglin.smartff.mvp.model.api.interfaces.RequestCallBack;
import com.donglin.smartff.mvp.model.entity.AlarmInfo4OneDay;
import com.donglin.smartff.mvp.model.entity.Hour4AlarmSize;

import java.util.List;

/**
 * Created by Administrator on 2018/1/10 0010.
 */

public class IotFragmentApiImpl implements IotFragmenApi {

    private List<AlarmInfo4OneDay> list;
    private Hour4AlarmSize size4hours;

    @Override
    public void loadAlarmInfo4OneHour(RequestCallBack<String> requestCallBack) {
        requestCallBack.success("success");
    }

    @Override
    public void loadAlarmChatInfo4OneDay(RequestCallBack<String> requestCallBack) {
        requestCallBack.success2("");
    }

    @Override
    public void onDestory() {

    }
}
