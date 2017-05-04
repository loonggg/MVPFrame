package com.loonggg.godqrcode.di.module;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.loonggg.godqrcode.data.api.ApiService;
import com.loonggg.godqrcode.di.ApplicationContext;
import com.loonggg.godqrcode.util.CacheUtil;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;


@Module
public class ApiModule {
    private static final long OKCLIENT_DISK_CACHE_SIZE = 20 * 1024 * 1024;
    private static final String OKCLIENT_DISK_CACHE_NAME = "http-cache";
    //    String baseUrl = "http://v.juhe.cn/";
    String baseUrl = "http://api.wwei.cn/";

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(@ApplicationContext Context context) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(15 * 1000L, TimeUnit.MILLISECONDS)//15
                .readTimeout(20 * 1000L, TimeUnit.MILLISECONDS)//20
                .writeTimeout(30 * 1000L, TimeUnit.MILLISECONDS)//15
                .cache(new Cache(new File(CacheUtil.getHttpCacheDir(context), OKCLIENT_DISK_CACHE_NAME),
                        OKCLIENT_DISK_CACHE_SIZE)); //设置缓存目录和20M缓存
        return builder.build();
    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    ApiService provideApiService(Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }


}
