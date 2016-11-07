package com.example.gift_speak_demo.ui.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.design.widget.TabLayout;
import android.widget.ListView;

import com.example.gift_speak_demo.R;
import com.example.gift_speak_demo.module.bean.Home_Jx_bean;
import com.example.gift_speak_demo.presenter.IGuidePresenter;
import com.example.gift_speak_demo.tool.LogUtils;
import com.example.gift_speak_demo.ui.MainActivity;
import com.example.gift_speak_demo.ui.adapter.Home_Jx_Adapter;
import com.example.gift_speak_demo.ui.fragment.one_home_fragment.home_jx_Fragment;
import com.example.gift_speak_demo.ui.fragment.one_home_fragment.home_snp_Fragment;
import com.example.gift_speak_demo.ui.view.ISelectedView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by my on 2016/11/5.
 * 首页栏目的总页面
 */
public class Fragment_one_home extends Fragment implements ISelectedView{

    private View rootview;
    private List<Fragment> datas = new ArrayList<>();
    private List<String> titles = new ArrayList<>();
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private MyAdapter myAdapter;

    @BindView(R.id.home_listview)
    ListView mListView;
    @Inject
    IGuidePresenter mGuidePresenter;
    private List<Home_Jx_bean.DataBean.ItemsBean> itemsBeanList = new ArrayList<>();
    private Home_Jx_Adapter home_jx_adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragment_one_home, container,false);
        initView();

//      ButterKnife.bind(this,mListView);
//        DaggerAppComponent.create().inject(this);
        mGuidePresenter.setSelectedView(this);

        mGuidePresenter.querySelectedList(1);
//        home_jx_adapter = new Home_Jx_Adapter(itemsBeanList);

        return rootview;
    }

    private void initView(){
        mTabLayout = (TabLayout) rootview.findViewById(R.id.Fragment_one_Tab_Layout);
        mViewPager = (ViewPager) rootview.findViewById(R.id.Fragment_one_view_pager);
        //设置TabLayout选中前和选中后的标题颜色 ,以及标线的颜色,评分TabLayout
        mTabLayout.setTabTextColors(getResources().getColor(R.color.colorBlack),getResources().getColor(R.color.colorRed));
        mTabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorRed));
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);


        inDataFragment();
        inData();
        myAdapter = new MyAdapter(getChildFragmentManager());
        mViewPager.setAdapter(myAdapter);

        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                mViewPager.setCurrentItem(position);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mTabLayout.setScrollPosition(position,0,true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void inDataFragment(){
        Fragment fragment1 = new home_jx_Fragment();
        Fragment fragment2 = new home_snp_Fragment();
        Fragment fragment3 = new home_jx_Fragment();
        Fragment fragment4 = new home_jx_Fragment();
        Fragment fragment5 = new home_jx_Fragment();
        Fragment fragment6 = new home_jx_Fragment();
        Fragment fragment7 = new home_jx_Fragment();
        Fragment fragment8 = new home_jx_Fragment();
        Fragment fragment9 = new home_jx_Fragment();
        Fragment fragment10 = new home_jx_Fragment();
        Fragment fragment11 = new home_jx_Fragment();
        Fragment fragment12 = new home_jx_Fragment();
        Fragment fragment13 = new home_jx_Fragment();
        Fragment fragment14 = new home_jx_Fragment();
        datas.add(fragment1);
        datas.add(fragment2);
        datas.add(fragment3);
        datas.add(fragment4);
        datas.add(fragment5);
        datas.add(fragment6);
        datas.add(fragment7);
        datas.add(fragment8);
        datas.add(fragment9);
        datas.add(fragment10);
        datas.add(fragment11);
        datas.add(fragment12);
        datas.add(fragment13);
        datas.add(fragment14);
    }

    private void inData(){
        titles.add("精选");
        titles.add("送女票");
        titles.add("海淘");
        titles.add("创意生活");
        titles.add("送基友");
        titles.add("送爸妈");
        titles.add("送同事");
        titles.add("设计感");
        titles.add("文艺风");
        titles.add("奇葩搞怪");
        titles.add("科技范");
        titles.add("数码");
        titles.add("萌萌哒");
        titles.add("爱读书");
    }


    class MyAdapter extends FragmentPagerAdapter {
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return datas.get(position);
        }

        @Override
        public int getCount() {
            return datas == null ? 0 : datas.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }
    }

    @Override
    public void setListDatas(Home_Jx_bean home_jx_bean) {
        //
        if (home_jx_bean != null){
            LogUtils.log(Fragment_one_home.class,"" + home_jx_bean.getCode());
            if (home_jx_bean.getData() != null){
                itemsBeanList.addAll(home_jx_bean.getData().getItems());
                home_jx_adapter.notifyDataSetChanged();
            }
        }
    }
}