package com.loonggg.mvpframe.data;

import com.google.gson.Gson;
import com.loonggg.mvpframe.data.api.ApiService;
import com.loonggg.mvpframe.data.api.model.NewsModel;

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
    public Subscription getNewsTop(Subscriber<NewsModel> subscriber, String type, String key) {
        return apiService.getNewsTop(type, key)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }


}
