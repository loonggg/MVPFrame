package com.loonggg.godqrcode.ui.base;

/**
 * Created by Administrator on 2017/2/21.
 */

public interface MvpPresenter<V extends MvpView> {

    void attachView(V mvpView);

    void detachView();
}
