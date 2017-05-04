package com.loonggg.godqrcode.data.api;

import android.util.Log;

public class SimpleAPICallBack<T> extends AbsAPICallback<T> {


    public SimpleAPICallBack() {
        super("连接错误", "连接错误", "未知错误");
    }

    public SimpleAPICallBack(String networkMsg, String parseMsg, String unknownMsg) {
        super(networkMsg, parseMsg, unknownMsg);
    }

    @Override
    protected void onError(ApiException ex) {
        Log.i("ERROR",ex.getMessage());
//        if (!StringUtil.isEmpty(ex.getDisplayMessage()))
//            ToastUtil.showShort(ex.getDisplayMessage());
    }

    @Override
    protected void onPermissionError(ApiException ex) {
    }

    @Override
    protected void onResultError(ApiException ex) {
//        if (!StringUtil.isEmpty(ex.getDisplayMessage()))
//            ToastUtil.showShort(ex.getDisplayMessage());
    }

    @Override
    public void onNext(T t) {
    }

    @Override
    public void onCompleted() {
    }
}
