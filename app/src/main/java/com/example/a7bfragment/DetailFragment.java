package com.example.a7bfragment;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

//创建detailFragment继承自Fragment
public class DetailFragment extends Fragment {

    public DetailFragment() {
        // 必须要又无参构造函数
    }

    //重写onCreateView方法
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layoutRoot = inflater.inflate(R.layout.fragment_detail,
                container, false);

        return layoutRoot;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    //detailActivity use
    //创建一个属性，和setter方法，activity给fragment传数据
    private int itemId;
    public void setItem(int itemId){
        this.itemId = itemId;
    }

    //detailActivity use
    //创建一个接口，用来给activity传数据
    public interface IDetailFragment{
        void itemClicked(String content);
    }

    //声明接口 重写onAttach方法
    private IDetailFragment iDetailFragment;

    //跟activity有关系的context
    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        iDetailFragment = (IDetailFragment) context;
    }

    //创一个方法；调用activity实现的接口；传数据过去
    public void sendDataToActivity(String content){
        iDetailFragment.itemClicked(content);
    }

    @Override
    public void onStart(){
        super.onStart();

        View view = getView();
        if (view != null) {
            //获取dataService的信息
            //当调用 DataItem getItem方法时候，放回dataItems
            DataItem item = DataService.getItem(itemId);

            //获取按钮和单击事件监听器
            TextView title = (TextView) view.findViewById(R.id.textTitle);
            title.setText(item.getName());//把item的名字赋给按钮title

            //当单击按钮时候 这个名字也显示在下方
            title.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TextView textView = (TextView) v;
                    sendDataToActivity(textView.getText().toString());
                }
            });

            //获取按钮和单击事件监听器
            TextView desc = (TextView) view.findViewById(R.id.textDescription);
            desc.setText(item.getDescription());////把item的介绍赋给按钮desc
            desc.setOnClickListener(new View.OnClickListener() {
             //当单击按钮时候 这个介绍也显示在下方
                @Override
                public void onClick(View v) {
                    TextView textView = (TextView) v;
                    sendDataToActivity(textView.getText().toString());
                }
            });
        }

    }
}
