package com.loonggg.mvpframe;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.StrictMode;

import com.facebook.stetho.Stetho;
import com.loonggg.mvpframe.di.component.ApplicationComponent;
import com.loonggg.mvpframe.di.component.DaggerApplicationComponent;
import com.loonggg.mvpframe.di.module.ApplicationModule;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by loonggg on 2017/2/21.
 */

public class App extends Application {
    private static ApplicationComponent mApplicationComponent;
    private static RefWatcher sRefWatcher;

    @Override
    public void onCreate() {
        super.onCreate();
        setStrictMode();
        initStetho();
        initLeakCanary();
        setupInjector();
    }

    private void setupInjector() {
        mApplicationComponent = DaggerApplicationComponent.builder().
                applicationModule(new ApplicationModule(this))
                .build();
        mApplicationComponent.inject(this);
    }

    private void initLeakCanary() {
        sRefWatcher = LeakCanary.install(this);
    }

    private void initStetho() {
        Stetho.initializeWithDefaults(this);
    }

    private void setStrictMode() {
        if (BuildConfig.DEBUG && Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build());
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectAll().penaltyLog().build());
        }
    }

    public static Context getContext() {
        return getContext();
    }

    public static ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }
}
