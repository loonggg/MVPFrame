package com.loonggg.godqrcode.di.component;

import android.support.v4.app.Fragment;

import com.loonggg.godqrcode.di.ActivityScope;
import com.loonggg.godqrcode.di.module.ActivityModule;
import com.loonggg.godqrcode.di.module.FragmentModule;

import dagger.Component;

/**
 * Created by loonggg on 2017/2/22.
 */
@ActivityScope
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, FragmentModule.class})
public interface FragmentComponent {
    void inject(Fragment fragment);
}
