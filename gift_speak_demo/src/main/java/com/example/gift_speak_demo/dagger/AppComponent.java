package com.example.gift_speak_demo.dagger;

import com.example.gift_speak_demo.ui.MainActivity;

import dagger.Component;

/**
 * Created by my on 2016/11/6.
 */
@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(MainActivity activity);
}
