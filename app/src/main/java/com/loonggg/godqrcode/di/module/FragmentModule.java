package com.loonggg.godqrcode.di.module;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.loonggg.godqrcode.di.ActivityContext;

import dagger.Module;
import dagger.Provides;

/**
 * Created by loonggg on 2017/2/21.
 */
@Module
public class FragmentModule {
    private Fragment fragment;

    public FragmentModule(Fragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    Fragment provideFragment() {
        return fragment;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return fragment.getContext();
    }
}
