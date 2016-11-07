package com.example.gift_speak_demo.module;

import com.example.gift_speak_demo.presenter.IGuidePresenter;

/**
 * Created by my on 2016/11/5.
 * 请求数据的API接口
 */
public interface IGuideModel {

    void querySelectedList(int pageno, IGuidePresenter.Callback callback);
}
