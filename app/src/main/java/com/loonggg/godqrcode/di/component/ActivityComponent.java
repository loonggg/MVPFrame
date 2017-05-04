package com.loonggg.godqrcode.di.component;

import com.loonggg.godqrcode.di.ActivityScope;
import com.loonggg.godqrcode.di.module.ActivityModule;
import com.loonggg.godqrcode.ui.wwei.WweiQrCodeActivity;

import dagger.Component;

/**
 * Created by Administrator on 2017/2/21.
 */
@ActivityScope
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(WweiQrCodeActivity activity);
}
