package com.example.gift_speak_demo.presenter.impl;

import com.example.gift_speak_demo.module.IGuideModel;
import com.example.gift_speak_demo.module.bean.Home_Jx_bean;
import com.example.gift_speak_demo.presenter.IGuidePresenter;
import com.example.gift_speak_demo.ui.view.ISelectedView;

/**
 * Created by my on 2016/11/6.
 */
public class GuidePresenter implements IGuidePresenter,IGuidePresenter.Callback{

    private IGuideModel mGuideModel;
    private ISelectedView selectedView;

    public GuidePresenter(IGuideModel guideModel) {
        this.mGuideModel = guideModel;
    }

    @Override
    public void setSelectedView(ISelectedView selectedView) {
        this.selectedView = selectedView;
    }

    @Override
    public void success(int responseCode, Home_Jx_bean home_jx_bean) {
        //获取Model的结果
        this.selectedView.setListDatas(home_jx_bean);
    }

    @Override
    public void querySelectedList(int pageno) {
        this.mGuideModel.querySelectedList(pageno,this);
    }


}
