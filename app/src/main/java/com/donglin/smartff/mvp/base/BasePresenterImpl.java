package com.donglin.smartff.mvp.base;

import com.donglin.smartff.mvp.base.interfaces.BaseApi;
import com.donglin.smartff.mvp.base.interfaces.BasePresenter;
import com.donglin.smartff.mvp.base.interfaces.BaseView;
import com.donglin.smartff.mvp.model.api.interfaces.RequestCallBack;

/**
 * Created by Administrator on 2018/1/10 0010.
 */

public class BasePresenterImpl<V extends BaseView,M extends BaseApi, T> implements BasePresenter ,RequestCallBack<T>{

    public V mView;
    public M mApi;

    public BasePresenterImpl(V rootView, M model) {
        mView = rootView;
        mApi = model;
    }


    @Override
    public void onCreate() {

    }

    @Override
    public void onDestroy() {
        if (mApi != null) {
            mApi.onDestory();
            this.mApi = null;
        }
        this.mView = null;
    }

    @Override
    public void beforeRequest() {
        if (mView != null) {
            mView.showPro();
        }
    }

    @Override
    public void success(T data) {
        if (mView != null) {
            mView.disPro();
        }
    }

    @Override
    public void success2(T data) {
        if (mView != null) {
            mView.disPro();
        }
    }

    @Override
    public void onError(String errorMsg) {
        if (mView != null) {
            mView.disPro();
        }
    }
}
