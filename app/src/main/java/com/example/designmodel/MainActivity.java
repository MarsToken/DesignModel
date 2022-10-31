package com.example.designmodel;

import android.arch.lifecycle.ViewModelProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.databinding.DataBindingUtil;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.designmodel.databinding.ActivityMainBinding;
import com.example.designmodel.jvm.JVMPromote;
import com.example.designmodel.mvvm.TestBean;
import com.example.designmodel.mvvm.TestViewModel;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {
    private MessageQueue.IdleHandler idleHandler = new MessageQueue.IdleHandler() {
        @Override
        public boolean queueIdle() {
            System.out.println("idleHandler===========");
            return false;
        }
    };
    private Handler mAsyncHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            System.out.println("======================sync handler!=============what=" + msg.what);
            invokeRemoveAsyncBarrier(Looper.myQueue(),token);
        }
    };
    private TestViewModel testViewModel;
    private int token;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        TestBean testBean = new TestBean();
        binding.setUser(testBean);
        ViewModelProvider provider = new ViewModelProvider(this, new TestViewModel.TestFactory("111"));

        testViewModel = provider.get(TestViewModel.class);
        testViewModel.doAction();
        //startActivity(new Intent(this,LiveDataActivity.class));

        View view = new View(this);
        view.invalidate(new Rect());
        receiver();

        HandlerThread handlerThread = new HandlerThread("thread-1"){
            @Override
            protected void onLooperPrepared() {
                System.out.println("looper is prepared!");
            }
        };
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper()){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                System.out.println(String.format("==========thread name = %s, msg=%s", Thread.currentThread().getName(), msg.toString()));
            }
        };
        Looper.myQueue().addIdleHandler(idleHandler);
        handler.sendEmptyMessage(1);
        //停止处理所有主线程的消息队列里的消息
        token = invokePostSyncBarrier(Looper.myQueue());
        //发送插队消息！
        Message msg = Message.obtain();
        msg.setAsynchronous(true);
        msg.what = 999;
        mAsyncHandler.sendMessageDelayed(msg,3000);
        handler.sendEmptyMessageDelayed(2, 0);
        handler.sendEmptyMessage(11);
        handler.sendEmptyMessageDelayed(3, 1000);
        handlerThread.getLooper().quitSafely();
        //handler.removeCallbacksAndMessages(null);
        //handler.getLooper().quitSafely();//主线程无法退出！
        handler.sendEmptyMessageDelayed(4, 0);
        handler.sendEmptyMessageDelayed(5, 3000);

//        for (int i = 0; i < 10; i++) {
//            AsyncTask asyncTask = new AsyncTask() {
//                @Override
//                protected Object doInBackground(Object[] objects) {
//                    System.out.println(String.format("current thread name is %s", Thread.currentThread().getName()));
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    return null;
//                }
//            };
//            asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,"");
//            //asyncTask.execute();
//        }

//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                Looper.prepare();
//                Handler handlers = new Handler(){
//                    @Override
//                    public void handleMessage(Message msg) {
//                        super.handleMessage(msg);
//                        System.out.println("======================================================" + msg.what);
//                    }
//                };
//                handlers.sendEmptyMessage(-1);
//                handlers.sendEmptyMessage(-10);
//                handlers.sendEmptyMessageDelayed(-100, 1000);
//                Looper.loop();
//            }
//        });
//        thread.start();
    }

    @Override
    protected void onResume() {
        super.onResume();
//        System.out.println("ReflectionC ActivityA onResume=============");
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                bindService(new Intent(MainActivity.this, CustomService.class), new ServiceConnection() {
//                    @Override
//                    public void onServiceConnected(ComponentName name, IBinder service) {//main
//                        System.out.println("Thread name is " + Thread.currentThread().getName() + ",component name is" + name);
//                    }
//
//                    @Override
//                    public void onServiceDisconnected(ComponentName name) {
//
//                    }
//                }, BIND_AUTO_CREATE);
//            }
//        }).start();

    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("ReflectionC ActivityA onPause=============");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("ReflectionC ActivityA onStop=============");
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        System.out.println("onWindowFocusChanged===========");
    }

    private void receiver() {
        IntentFilter filter = new IntentFilter("aa");
        Intent data = registerReceiver(null, filter);
        if (null != data && data.getAction().equals("aa")) {
            System.out.println("sticky broadcast!");
            //removeStickyBroadcast(data);
        }
    }

    public void onClick(View view) {
        startActivity(new Intent(this, KotlinDemoActivity.class));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.err.println("onDestroy!!!");
    }

    private int invokePostSyncBarrier(MessageQueue obj) {
        Class<MessageQueue> clazz = (Class<MessageQueue>) obj.getClass();
        try {
            Method method = clazz.getMethod("postSyncBarrier");
            method.setAccessible(true);
            int syncBarrierNumber = (int) method.invoke(obj);
            System.out.println("=====================invokeRemoveAsyncBarrier===============success=====================" + syncBarrierNumber);
            return syncBarrierNumber;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return -1;
    }

    private void invokeRemoveAsyncBarrier(MessageQueue obj,int token) {
        Class<MessageQueue> clazz = (Class<MessageQueue>) obj.getClass();
        try {
            Method method = clazz.getMethod("removeSyncBarrier",int.class);
            method.setAccessible(true);
            method.invoke(obj, token);
            System.out.println("======================invokeRemoveAsyncBarrier=================success=====================");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}

