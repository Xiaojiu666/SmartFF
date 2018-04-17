package com.donglin.smartff.widget;

/**
 * Created by Administrator on 2018/1/16 0016.
 */

public class AutoVerticalViewDataData {
    private String title;
    private String value;
    private String url;

    public AutoVerticalViewDataData(String title, String value, String url) {
        this.title = title;
        this.value = value;
        this.url = url;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
