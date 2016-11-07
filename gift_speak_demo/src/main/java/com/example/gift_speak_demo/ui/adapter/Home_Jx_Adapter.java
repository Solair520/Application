package com.example.gift_speak_demo.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gift_speak_demo.R;
import com.example.gift_speak_demo.module.bean.Home_Jx_bean;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by my on 2016/11/5.
 */
public class Home_Jx_Adapter extends BaseAdapter{
    private List<Home_Jx_bean.DataBean.ItemsBean> beanList ;
    private Context mContext;
    private LayoutInflater mLayoutInfalter;

    public Home_Jx_Adapter(List<Home_Jx_bean.DataBean.ItemsBean> beanList, Context mContext) {
        this.beanList = beanList;
        this.mContext = mContext;
        mLayoutInfalter = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return beanList == null ? 0 : beanList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder viewHolder = null;
        if(view == null){
            view = mLayoutInfalter.inflate(R.layout.jx_listview,parent,false);
            viewHolder = new ViewHolder(view);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }
        Home_Jx_bean.DataBean.ItemsBean itemsBean = beanList.get(position);
        if (itemsBean != null){
            String title = itemsBean.getTitle();
            viewHolder.textView.setText(title);
            Picasso.with(mContext).load(itemsBean.getCover_image_url()).into(viewHolder.imageView);
        }
        return view;
    }

    class ViewHolder{
        @BindView(R.id.jx_image_list)
        ImageView imageView;
        @BindView(R.id.jx_text_name)
        TextView textView;
        public ViewHolder(View view){
            view.setTag(this);
            ButterKnife.bind(this,view);
        }
    }
}
