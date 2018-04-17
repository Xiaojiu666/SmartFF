package com.donglin.smartff.mvp.model.api.interfaces;

import com.donglin.smartff.mvp.base.interfaces.BaseApi;

/**
 * Created by Administrator on 2018/1/10 0010.
 */

public interface IotFragmenApi extends BaseApi {

    void loadAlarmInfo4OneHour(RequestCallBack<String> data);

    void loadAlarmChatInfo4OneDay(RequestCallBack<String> data);
}
