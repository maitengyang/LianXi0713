package com.example.lianxi0713.api;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;

/*
 *@Auther:苏格拉没有底
 *@Date: 2019/7/13
 *@Time:9:01
 *@Description:作用:
 * */public class AllApplication extends Application {
     public static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context=this;
        Fresco.initialize(this);

    }
}
