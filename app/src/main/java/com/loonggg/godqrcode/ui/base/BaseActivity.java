package com.loonggg.godqrcode.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.loonggg.godqrcode.App;
import com.loonggg.godqrcode.di.component.ActivityComponent;
import com.loonggg.godqrcode.di.component.DaggerActivityComponent;
import com.loonggg.godqrcode.di.module.ActivityModule;

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
