package com.loonggg.mvpframe.data.api;


import com.loonggg.mvpframe.data.api.model.NewsModel;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

public interface ApiService {
    @GET("toutiao/index")
    Observable<NewsModel> getNewsTop(@Query("type") String type, @Query("key") String key);
}
