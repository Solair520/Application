package com.example.gift_speak_demo.dagger;

import com.example.gift_speak_demo.module.IGuideModel;
import com.example.gift_speak_demo.module.impl.GuideModel;
import com.example.gift_speak_demo.presenter.IGuidePresenter;
import com.example.gift_speak_demo.presenter.impl.GuidePresenter;

import com.google.gson.Gson;

import dagger.Module;
import dagger.Provides;


/**
 * Created by my on 2016/11/6.
 */
@Module
public class AppModule {

    @Provides
    public Gson provideGson() {
        return new Gson();
    }
    @Provides
    public IGuideModel provideGuideModule(Gson gson) {
        return new GuideModel(gson);
    }
    @Provides
    public IGuidePresenter provideGuidePresenter(IGuideModel guideModel) {
        return new GuidePresenter(guideModel);
    }
}
