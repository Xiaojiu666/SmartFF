package com.donglin.smartff.mvp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/1/9 0009.
 */

public abstract class BaseAppComPatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getResLayout());
        ButterKnife.bind(this);
        initData();
        initView();
        initOnClick();
    }

    protected abstract void initOnClick();

    protected abstract void initData();

    protected abstract void initView();

    //获取抽象方法
    public abstract  int getResLayout();
}
