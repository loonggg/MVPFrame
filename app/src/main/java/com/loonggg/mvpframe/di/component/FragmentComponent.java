package com.loonggg.mvpframe.di.component;

import android.support.v4.app.Fragment;

import com.loonggg.mvpframe.di.ActivityScope;
import com.loonggg.mvpframe.di.module.ActivityModule;
import com.loonggg.mvpframe.di.module.ApplicationModule;
import com.loonggg.mvpframe.di.module.FragmentModule;

import dagger.Component;

/**
 * Created by loonggg on 2017/2/22.
 */
@ActivityScope
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, FragmentModule.class})
public interface FragmentComponent {
    void inject(Fragment fragment);
}
