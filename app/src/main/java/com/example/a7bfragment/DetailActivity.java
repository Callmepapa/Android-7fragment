package com.example.a7bfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

//实现fragment接口
public class DetailActivity extends AppCompatActivity implements DetailFragment.IDetailFragment {

    //重写接口的方法
    @Override
    public void itemClicked(String content){
        Toast.makeText(this,content,Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //获取intent的信息
        Intent intent = getIntent();
        int itemId = intent.getIntExtra("itemId",1);

        //找fragment对象
        FragmentManager fm = getSupportFragmentManager();
        DetailFragment fragment = (DetailFragment)fm.findFragmentById(R.id.fragment_detial);
        //传数据给fragment
        fragment.setItem(itemId);

    }
}
