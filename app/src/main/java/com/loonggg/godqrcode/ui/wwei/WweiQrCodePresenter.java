package com.loonggg.godqrcode.ui.wwei;

import android.util.Log;

import com.facebook.stetho.common.LogUtil;
import com.loonggg.godqrcode.data.DataManager;
import com.loonggg.godqrcode.data.api.ApiException;
import com.loonggg.godqrcode.data.api.ApiService;
import com.loonggg.godqrcode.data.api.SimpleAPICallBack;
import com.loonggg.godqrcode.data.api.model.NewsModel;
import com.loonggg.godqrcode.data.api.model.QrCodeModel;
import com.loonggg.godqrcode.ui.base.BasePresenter;

import javax.inject.Inject;

import rx.Subscription;

/**
 * Created by Administrator on 2017/2/21.
 */

public class WweiQrCodePresenter extends BasePresenter<WweiQrCodeView> {
    private DataManager dataManager;
    private Subscription subscription;
    private int pageIndex = -1;
    @Inject
    ApiService apiService;

    @Inject
    public WweiQrCodePresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void attachView(WweiQrCodeView mvpView) {
        super.attachView(mvpView);
    }

    public void generateQrCode(String apiKey,String data,String bcolor,String fcolor,String icolor,String pcolor,String xt) {
        SimpleAPICallBack<QrCodeModel> subscriber = new SimpleAPICallBack<QrCodeModel>() {

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
            public void onNext(QrCodeModel qrCodeModel) {
                if (isViewAttached())
                    getMvpView().onNewsTopList(qrCodeModel);
            }

        };
        subscription = dataManager.generateQrCode(subscriber,apiKey,data,bcolor,fcolor,icolor,pcolor,xt);

    }

    @Override
    public void detachView() {
        super.detachView();
        if (subscription != null && !subscription.isUnsubscribed())
            subscription.unsubscribe();
    }
}
