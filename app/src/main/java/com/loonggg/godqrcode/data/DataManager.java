package com.loonggg.godqrcode.data;

import com.google.gson.Gson;
import com.loonggg.godqrcode.data.api.ApiService;
import com.loonggg.godqrcode.data.api.model.NewsModel;
import com.loonggg.godqrcode.data.api.model.QrCodeModel;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


@Singleton
public class DataManager {
    private final ApiService apiService;
    private final Gson gson;

    @Inject
    public DataManager(ApiService apiService, Gson gson) {
        this.apiService = apiService;
        this.gson = gson;
    }

    //左侧标题栏
    public Subscription generateQrCode(Subscriber<QrCodeModel> subscriber, String apiKey, String data,String bcolor,String fcolor,String icolor,String pcolor,String xt) {
        return apiService.generateQrCode(apiKey,data,bcolor,fcolor,icolor,pcolor,xt)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }


}
