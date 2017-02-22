package com.loonggg.mvpframe.di.module;

import android.app.Activity;
import android.content.Context;

import com.loonggg.mvpframe.di.ActivityContext;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/2/21.
 */
@Module
public class ActivityModule {
    private Activity activity;
    public ActivityModule(Activity activity){
        this.activity = activity;
    }
    @Provides
    Activity provideActivity(){
        return activity;
    }

    @Provides
    @ActivityContext
    Context provideContext(){
        return activity;
    }
}
