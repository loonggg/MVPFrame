package com.loonggg.godqrcode.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.loonggg.godqrcode.App;
import com.loonggg.godqrcode.di.component.DaggerFragmentComponent;
import com.loonggg.godqrcode.di.component.FragmentComponent;
import com.loonggg.godqrcode.di.module.ActivityModule;
import com.loonggg.godqrcode.di.module.FragmentModule;

/**
 * Created by loonggg on 2017/2/22.
 */

public abstract class BaseFragment extends Fragment {
    private FragmentComponent fragmentComponent;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public FragmentComponent getFragmentComponent() {
        if (fragmentComponent == null) {
            fragmentComponent = DaggerFragmentComponent.builder()
                    .applicationComponent(App.getApplicationComponent())
                    .activityModule(new ActivityModule((BaseActivity) getActivity()))
                    .fragmentModule(new FragmentModule(this))
                    .build();
        }

        return fragmentComponent;
    }
}
