package com.example.gift_speak_demo;

import android.app.Application;

import org.xutils.x;

/**
 * Created by my on 2016/11/5.
 */
public class MyApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        //完成Xtuils的初始化
        x.Ext.init(this);
    }
}
