package com.loonggg.godqrcode.di.module;

import android.app.Application;
import android.content.Context;

import com.loonggg.godqrcode.di.ApplicationContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/2/21.
 */

@Module
public class ApplicationModule {
    private final Application mApplication;

    public ApplicationModule(Application application) {
        this.mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Singleton
    @Provides
    Application provideApplication() {
        return mApplication;
    }

}
