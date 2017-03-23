package com.example.zz.rxworkdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.zz.rxworkdemo.bean.FirstEvent;

public class NextActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        initView();
    }

    private void initView() {
        textView = ((TextView) findViewById(R.id.textview_id));
        textView.setText("测试发送成功与否");
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RxBus.getInstance().post(new FirstEvent("测试姓名","测试年龄"));
            }
        });
    }
}
