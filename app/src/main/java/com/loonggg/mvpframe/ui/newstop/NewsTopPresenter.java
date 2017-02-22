package com.loonggg.mvpframe.ui.newstop;

import android.util.Log;

import com.facebook.stetho.common.LogUtil;
import com.loonggg.mvpframe.data.DataManager;
import com.loonggg.mvpframe.data.api.ApiException;
import com.loonggg.mvpframe.data.api.ApiService;
import com.loonggg.mvpframe.data.api.SimpleAPICallBack;
import com.loonggg.mvpframe.data.api.model.NewsModel;
import com.loonggg.mvpframe.ui.base.BasePresenter;

import javax.inject.Inject;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by Administrator on 2017/2/21.
 */

public class NewsTopPresenter extends BasePresenter<NewsTopView> {
    private DataManager dataManager;
    private Subscription subscription;
    private int pageIndex = -1;
    @Inject
    ApiService apiService;

    @Inject
    public NewsTopPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void attachView(NewsTopView mvpView) {
        super.attachView(mvpView);
    }

    public void getNewsTop(String type, String key) {
        SimpleAPICallBack<NewsModel> subscriber = new SimpleAPICallBack<NewsModel>() {

            @Override
            protected void onError(ApiException ex) {
                super.onError(ex);
                Log.i("ERROR", ex.getCode() + "");
                getMvpView().toError(ex.getDisplayMessage());
            }

            @Override
            public void onCompleted() {
                LogUtil.e("请求完成");
            }

            @Override
            public void onNext(NewsModel newsModel) {
                if (isViewAttached())
                    getMvpView().onNewsTopList(newsModel);
            }

        };
        subscription = dataManager.getNewsTop(subscriber, type, key);

    }

    @Override
    public void detachView() {
        super.detachView();
        if (subscription != null && !subscription.isUnsubscribed())
            subscription.unsubscribe();
    }
}
