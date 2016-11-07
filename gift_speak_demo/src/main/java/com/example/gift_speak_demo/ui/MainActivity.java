package com.example.gift_speak_demo.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.RadioGroup;

import com.example.gift_speak_demo.R;
import com.example.gift_speak_demo.ui.fragment.Fragment_four_profile;
import com.example.gift_speak_demo.ui.fragment.Fragment_one_home;
import com.example.gift_speak_demo.ui.fragment.Fragment_three_category;
import com.example.gift_speak_demo.ui.fragment.Fragment_two_gift;

public class MainActivity extends AppCompatActivity {

    private FragmentManager mFragmentManager;
    private RadioGroup mRadioGroup;
    private Fragment_one_home fragment_one_home;
    private Fragment_two_gift fragment_two_gift;
    private Fragment_three_category fragment_three_category;
    private Fragment_four_profile fragment_four_profile;
    private Fragment mCurrentShowFrament;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView(){
        mFragmentManager = getSupportFragmentManager();
        mRadioGroup = (RadioGroup) findViewById(R.id.main_selector_rg);

        fragment_one_home = new Fragment_one_home();
        fragment_two_gift = new Fragment_two_gift();
        fragment_three_category = new Fragment_three_category();
        fragment_four_profile = new Fragment_four_profile();
        //指定进入app 界面直接进入礼包内容中
        controlFragment(fragment_one_home);
        setupLintener();
    }

    private void setupLintener(){
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.main_radio_one:
                        controlFragment(fragment_one_home);
                        break;
                    case R.id.main_radio_two:
                        controlFragment(fragment_two_gift);
                        break;
                    case R.id.main_radio_three:
                        controlFragment(fragment_three_category);
                        break;
                    case R.id.main_radio_four:
                        controlFragment(fragment_four_profile);
                        break;
                }
            }
        });
    }

    private void controlFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        if(mCurrentShowFrament != null){
            fragmentTransaction.hide(mCurrentShowFrament);
        }
        if(!fragment.isAdded()){
            fragmentTransaction.add(R.id.fragment_conten_layout,fragment);
        }else{
            fragmentTransaction.show(fragment);
        }
        fragmentTransaction.commit();
        mCurrentShowFrament = fragment;
    }
}
