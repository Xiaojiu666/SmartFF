package com.donglin.smartff.mvp.model.entity;

import java.util.List;

/**
 * Created by Administrator on 2018/1/11 0011.
 */

public class AlarmInfo4OneDay {

    public String orgName;
    public String orgColor;

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgColor() {
        return orgColor;
    }

    public void setOrgColor(String orgColor) {
        this.orgColor = orgColor;
    }

    public List<Hour4AlarmSize> getTimes() {
        return times;
    }

    public void setTimes(List<Hour4AlarmSize> times) {
        this.times = times;
    }

    public List<Hour4AlarmSize> times;


}
