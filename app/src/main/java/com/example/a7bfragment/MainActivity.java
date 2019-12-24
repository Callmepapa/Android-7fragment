package com.example.a7bfragment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //创建按钮
    Button mDetailBtn1;
    Button mDetailBtn2;
    Button mDetailBtn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获取按钮和事件监听器
        mDetailBtn1 = findViewById(R.id.detaiBtn1);
        mDetailBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //开始DetailActivity方法
                startDetailActivity(1);
            }
        });

        mDetailBtn2 = findViewById(R.id.detailBtn2);
        mDetailBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startDetailActivity(2);
            }
        });

        mDetailBtn3 = findViewById(R.id.detailBtn3);
        mDetailBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startDetailActivity(3);
            }
        });

    }

    //创建intent方法调用detailActivity方法
    void startDetailActivity(int itemId){
        Intent intent = new Intent(this,DetailActivity.class);
       //传递数据
        intent.putExtra("itemId",itemId);
        startActivity(intent);

    }
}
