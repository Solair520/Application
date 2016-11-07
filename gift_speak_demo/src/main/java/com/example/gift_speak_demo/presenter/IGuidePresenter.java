package com.example.gift_speak_demo.presenter;

import com.example.gift_speak_demo.module.bean.Home_Jx_bean;
import com.example.gift_speak_demo.ui.view.ISelectedView;

/**
 * Created by my on 2016/11/6.
 */
public interface IGuidePresenter {

    void setSelectedView(ISelectedView selectedView);

    /**
     * 加载指南精选列表数据
     * @param pageno
     */
    void querySelectedList(int pageno);

    interface Callback{
        void success(int responseCode, Home_Jx_bean home_jx_bean);
    }
}
