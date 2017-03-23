package com.example.zz.rxworkdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.zz.rxworkdemo.bean.FirstEvent;

import rx.functions.Action1;

/**
 * 类描述：测试类RXJAva
 * 创建人：zz
 * 创建时间：2017/3/23 15:11
 */
public class MainActivity extends Activity implements View.OnClickListener{

    private Button buttonFirst;
    private Button buttonLong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        RxBus.getInstance().tObservable(FirstEvent.class).subscribe(new Action1<FirstEvent>() {
            @Override
            public void call(FirstEvent firstEvent) {
              buttonLong.setText(firstEvent.getUserName()+"--"+firstEvent.getAge());
            }
        });
    }
    /**
     * 初始化UI
     */
    private void initView() {
        buttonFirst = ((Button) findViewById(R.id.button_first));
        buttonFirst.setOnClickListener(this);
        buttonLong = ((Button) findViewById(R.id.button_long));
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_first:
                RxFirst();
                break;
        }
    }
    private void RxFirst() {
      startActivity(new Intent(MainActivity.this,NextActivity.class));
    }
}
