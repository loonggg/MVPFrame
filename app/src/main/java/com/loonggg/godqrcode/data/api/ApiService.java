package com.loonggg.godqrcode.data.api;


import com.loonggg.godqrcode.data.api.model.NewsModel;
import com.loonggg.godqrcode.data.api.model.QrCodeModel;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface ApiService {
    @GET("wwei.html")
    Observable<QrCodeModel> generateQrCode(@Query("apikey") String apikey, @Query("data") String data, @Query("bcolor") String bcolor, @Query("fcolor") String fcolor, @Query("icolor") String icolor, @Query("pcolor") String pcolor, @Query("xt") String xt);
}
