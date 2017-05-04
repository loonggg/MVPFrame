package com.loonggg.godqrcode.di.component;

import android.app.Application;
import android.content.Context;

import com.google.gson.Gson;
import com.loonggg.godqrcode.App;
import com.loonggg.godqrcode.data.DataManager;
import com.loonggg.godqrcode.data.api.ApiService;
import com.loonggg.godqrcode.di.ApplicationContext;
import com.loonggg.godqrcode.di.module.ApiModule;
import com.loonggg.godqrcode.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Administrator on 2017/2/21.
 */

@Singleton
@Component(modules = {ApplicationModule.class, ApiModule.class})
public interface ApplicationComponent {
    void inject(App app);

    @ApplicationContext
    Context context();

    Gson gson();

    DataManager dataManager();

    Application application();

    ApiService apiservice();
}
