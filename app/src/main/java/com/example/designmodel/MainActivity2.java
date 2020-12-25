package com.example.designmodel;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;

import com.example.designmodel.leakcanary.IAppListener;
import com.example.designmodel.leakcanary.SimpleCls;
import com.example.designmodel.leakcanary.singleTon.Call;
import com.example.designmodel.leakcanary.singleTon.DownloadManager;
import com.example.designmodel.leakcanary.singleTon.Task;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/*
 * 所有成员变量都在堆中
 * 局部变量：基本类型在栈中，引用类型在堆中
 * */
public class MainActivity2 extends AppCompatActivity {
    //8.0+版本 nativeHeap中 不会泄漏javaHeap
    private static Bitmap test;
    //静态内部类不会持有外部类引用，不会内存泄漏
    private static Test staticInnerClass;
    private ImageView iv;
    //非静态内部类会持有外部类引用，会内存泄漏
    private static T innerClass;
    //普通常量不会泄漏上下文，但是肯定自身耗内存，只泄漏他自己，不代表他就不泄露上下文，比如 DownloadManager2会泄漏上下文，因为监听里有this
    private static SimpleCls simpleCls;
    private static String lg;
    //DownloadManager2
    //handler比较特殊 构造函数能体现
    //activity->handler->message->messageQueue->looper
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("===============" + msg);
            test();
        }
    };

    private IAppListener listener = new IAppListener() {
        @Override
        public void onCallBack() {
            test();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        test = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        //iv = findViewById(R.id.iv);
        iv.setImageBitmap(test);
        staticInnerClass = new Test();
        lg = "123";
        innerClass = new T();
        simpleCls = new SimpleCls();

        //downloadManager -> task -> call
        Task task = DownloadManager.getInstance().newTask();
        Call call = task.newCall();
        call.execute();
        //call = null; // 无法回收，DownloadManager是静态单例，引用task，task引用了call，即使call置为空，也无法回收，切断GC_ROOT 联系即可避免内存泄露，即置task为空。
        //leakCanary 无法检测出来，貌似只检测context和fragment


//        DownloadManager2.getInstance().register(new DownloadManager2.DownloadListener() {
//            @Override
//            public void done() {
//
//            }
//        });
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mHandler.sendEmptyMessageDelayed(1, 10000);
//                mHandler.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        System.out.println("===============================");
//                    }
//                }, 10000);
//                try {
//                    Thread.sleep(10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                Message message = Message.obtain();
//                message.what = 1;
//                mHandler.sendMessageDelayed(message, 100000);
            }
        });
        //弱引用
        final ReferenceQueue<Object> weakQueue = new ReferenceQueue<>();
        Object object_weak = new Object();
        final WeakReference<Object> weakReference = new WeakReference<>(object_weak, weakQueue);
        System.out.println("weakReference============" + weakReference.get());
        System.out.println("weakQueue============" + weakQueue.poll());
        System.gc();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                System.out.println("weakReference============" + weakReference.get());
                System.out.println("weakQueue============" + weakQueue.poll());
            }
        }, 10000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        innerClass = null;
        //tests = null;
        //DownloadManager2.getInstance().unregister(this);
    }

    //    @Override
//    public void done() {
//        System.out.println("done!!!");
//    }

    private void test() {

    }

    private static class Test {
        private void say() {
            //报错 ,静态无法调用非静态的方法，生命周期不一样，编译器不允许
            //test();
        }
    }

    private class T {
        protected void say() {
            test();
        }

    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        System.out.println("level="+level);
    }
}