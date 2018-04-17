package com.donglin.smartff.di.compoent;

import com.donglin.smartff.di.moudle.IotFragmentMoudle;
import com.donglin.smartff.di.scope.FragmentScope;
import com.donglin.smartff.mvp.ui.fragments.IotFragment;

import dagger.Component;

/**
 * Created by Administrator on 2018/1/10 0010.
 */

@FragmentScope
@Component(modules = IotFragmentMoudle.class)
public interface IotFragmentCom {
    void inJect(IotFragment iotFragment);
}
