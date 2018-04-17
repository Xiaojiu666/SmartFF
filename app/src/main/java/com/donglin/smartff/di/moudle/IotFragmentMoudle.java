package com.donglin.smartff.di.moudle;

import com.donglin.smartff.di.scope.FragmentScope;
import com.donglin.smartff.mvp.model.api.IotFragmentApiImpl;
import com.donglin.smartff.mvp.model.api.interfaces.IotFragmenApi;
import com.donglin.smartff.mvp.ui.view.IotView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2018/1/10 0010.
 */
@Module
public class IotFragmentMoudle {

    private IotView mView;

    public IotFragmentMoudle(IotView iotView){
        this.mView =iotView;
    }

    @FragmentScope
    @Provides
    IotView iotFragmentView() {
        return mView;
    }

    @FragmentScope
    @Provides
    IotFragmenApi provideMyOrderApi() {
        return new IotFragmentApiImpl();
    }
}
