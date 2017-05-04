package com.loonggg.mvpframe.di.component;

import com.loonggg.mvpframe.di.ActivityScope;
import com.loonggg.mvpframe.di.PerActivity;
import com.loonggg.mvpframe.di.module.ActivityModule;
import com.loonggg.mvpframe.ui.MainActivity;
import com.loonggg.mvpframe.ui.newstop.NewsTopActivity;

import dagger.Component;

/**
 * Created by Administrator on 2017/2/21.
 */
@ActivityScope
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(NewsTopActivity activity);
}
