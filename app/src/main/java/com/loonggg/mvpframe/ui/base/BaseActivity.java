package com.loonggg.mvpframe.ui.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.loonggg.mvpframe.App;
import com.loonggg.mvpframe.di.component.ActivityComponent;
import com.loonggg.mvpframe.di.component.DaggerActivityComponent;
import com.loonggg.mvpframe.di.module.ActivityModule;

/**
 * Created by Administrator on 2017/2/21.
 */

public abstract class BaseActivity extends AppCompatActivity {
    ActivityComponent mActivityComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    public ActivityComponent getActivityComponent() {
        if (mActivityComponent == null) {
            mActivityComponent = DaggerActivityComponent.builder()
                    .applicationComponent(App.getApplicationComponent())
                    .activityModule(new ActivityModule(this))
                    .build();
        }
        return mActivityComponent;
    }
}
