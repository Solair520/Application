package com.example.gift_speak_demo.module.impl;

import com.example.gift_speak_demo.common.URLConstant;
import com.example.gift_speak_demo.module.IGuideModel;
import com.example.gift_speak_demo.module.bean.Home_Jx_bean;
import com.example.gift_speak_demo.presenter.IGuidePresenter;
import com.example.gift_speak_demo.tool.LogUtils;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by my on 2016/11/5.
 */
public class GuideModel implements IGuideModel{

    private Gson gson;

    public GuideModel(Gson gson) {
        this.gson = gson;
    }

    @Override
    public void querySelectedList(int pageno, final IGuidePresenter.Callback callback) {
        RequestParams requestParams = new RequestParams(URLConstant.HOME_JX_URL);
        x.http().get(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                LogUtils.log(GuideModel.class,result);
                Home_Jx_bean bean = gson.fromJson(result,Home_Jx_bean.class);
                callback.success(1,bean);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }
}
