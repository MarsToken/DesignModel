package com.example.designmodel;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.os.Bundle;
import android.view.View;

import com.example.designmodel.thread.Bean;
import com.example.designmodel.thread.TestThread;

public class MainActivity extends Activity {
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            System.out.println("get="+msg.what);
            test("jerry" + msg.what);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBean = new Bean();
    }

    public void onClick(View view) {
        test("tom");
        for (int i = 0; i < 100; i++) {
            final int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    //test("jerry" + finalI);
                    mHandler.sendEmptyMessage(finalI);
                }
            }).start();
        }
    }

    private Bean mBean;

    private void test(String name) {
        mBean.SetName(name);
        System.out.println(mBean);
    }
}
