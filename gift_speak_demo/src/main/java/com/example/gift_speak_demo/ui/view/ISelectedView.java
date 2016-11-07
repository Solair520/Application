package com.example.gift_speak_demo.ui.view;

import com.example.gift_speak_demo.module.bean.Home_Jx_bean;

/**
 * Created by my on 2016/11/6.
 * 接收presenter传递的内容的接口
 */
public interface ISelectedView {

    /**
     * 接收Presenter层返回的结果
     * @param home_jx_bean
     */
    void setListDatas(Home_Jx_bean home_jx_bean);
}
