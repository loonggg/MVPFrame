package com.loonggg.mvpframe.di.component;

import android.app.Application;
import android.content.Context;

import com.google.gson.Gson;
import com.loonggg.mvpframe.App;
import com.loonggg.mvpframe.data.DataManager;
import com.loonggg.mvpframe.data.api.ApiService;
import com.loonggg.mvpframe.di.ApplicationContext;
import com.loonggg.mvpframe.di.module.ApiModule;
import com.loonggg.mvpframe.di.module.ApplicationModule;

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
