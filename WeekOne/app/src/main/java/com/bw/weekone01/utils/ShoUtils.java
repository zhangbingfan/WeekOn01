package com.bw.weekone01.utils;

import android.util.Log;

import com.bw.weekone01.model.ShowModel;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;

public class ShoUtils {
    //单例模式
    private  static ShoUtils shoUtils;

    private ShoUtils() {
    }

    public static ShoUtils getInstance()
    {
        if (shoUtils==null)
        {
            //同步锁
            synchronized (ShoUtils.class)
            {
                if (shoUtils==null)
                {
                    shoUtils=new ShoUtils();
                }
            }
        }
        return shoUtils;
    }
//    get请求
    public void doGet(String url, Callback callback)
    {
        HttpLoggingInterceptor httpLoggingInterceptor=new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.i("xxx",message);
            }
        });
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient=new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build();
        Request request=new Request.Builder()
                .url(url+"?keyword=手机&page=1&count=10")
                .build();
        okHttpClient.newCall(request).enqueue(callback);
    }
}
