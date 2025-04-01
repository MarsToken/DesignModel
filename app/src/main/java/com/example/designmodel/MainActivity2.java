package com.example.designmodel;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.designmodel.leakcanary.IAppListener;
import com.example.designmodel.leakcanary.SimpleCls;
import com.example.designmodel.leakcanary.singleTon.Call;
import com.example.designmodel.leakcanary.singleTon.DownloadManager;
import com.example.designmodel.leakcanary.singleTon.Task;
import com.example.designmodel.testutils.FileObserverTest;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

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
    private Handler mHandler = new Handler() {
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
            ReentrantLock lock = new ReentrantLock();

            test();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        RelativeLayout rl = findViewById(R.id.rl);
        ViewGroup.LayoutParams rlLayoutParams = rl.getLayoutParams();
        rlLayoutParams.height = 300;
        rl.setLayoutParams(rlLayoutParams);
        TextView textView = new TextView(this);
        RelativeLayout.LayoutParams layoutParams =
            new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 165);
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        textView.setLayoutParams(layoutParams);
        textView.setBackgroundResource(R.drawable.bg_bottom_line);
        textView.setText("haha搜搜哈哈哈啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊");
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test();
            }
        });
        rl.addView(textView);
        testFileObserver();
        test = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        //iv = findViewById(R.id.iv);
        // iv.setImageBitmap(test);
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
//        iv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mHandler.sendEmptyMessageDelayed(1, 10000);
////                mHandler.postDelayed(new Runnable() {
////                    @Override
////                    public void run() {
////                        System.out.println("===============================");
////                    }
////                }, 10000);
////                try {
////                    Thread.sleep(10);
////                } catch (InterruptedException e) {
////                    e.printStackTrace();
////                }
////                Message message = Message.obtain();
////                message.what = 1;
////                mHandler.sendMessageDelayed(message, 100000);
//            }
//        });
        //弱引用
        final ReferenceQueue<Object> weakQueue = new ReferenceQueue<>();
        Object object_weak = new Object();
        final WeakReference<Object> weakReference = new WeakReference<>(object_weak, weakQueue);
        System.out.println("weakReference============" + weakReference.get());
        System.out.println("weakQueue============" + weakQueue.poll());
        System.gc();

        new Handler().postDelayed(() -> {
            System.out.println("weakReference============" + weakReference.get());
            System.out.println("weakQueue============" + weakQueue.poll());
        }, 10000);
    }

    private int index = 0;
    private void testFileObserver() {
        Log.e("tag", getApplication().getApplicationInfo().dataDir);
        String path = getCacheDir().getAbsolutePath();
        new Thread(() -> FileObserverTest.observer(path)).start();
        findViewById(R.id.btn_create).setOnClickListener(v -> {
            File file = new File(path);
            if (!file.exists()) {
                file.mkdirs();
            }
            try {
                File writeFile = new File(path  + "/test.txt");
                if (!writeFile.exists()) {
                    writeFile.createNewFile();
                }
                FileWriter writer = new FileWriter(writeFile);
                writer.write("user:张三" + (++index));
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
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
        new Thread(() -> {
            WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
            int ipAddress = wifiManager.getConnectionInfo().getIpAddress();
            String ip = String.format("%d.%d.%d.%d", (ipAddress & 0xff), (ipAddress >> 8 & 0xff), (ipAddress >> 16 & 0xff), (ipAddress >> 24 & 0xff));
            System.out.println("wifi ip is " + ip);
            ConnectivityManager cm = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo netInfo = cm.getActiveNetworkInfo();
            if (netInfo != null && netInfo.isConnectedOrConnecting()) {
                try {
                    InetAddress inetAddress = InetAddress.getLocalHost();
                    ip = inetAddress.getHostAddress();
                    System.out.println("活跃的ip is " + ip);
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
            }
//            try {
//                for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();) {
//                    NetworkInterface intf = en.nextElement();
//                    for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();) {
//                        InetAddress inetAddress = enumIpAddr.nextElement();
//                        if (!inetAddress.isLoopbackAddress()) {
//                            ip = inetAddress.getHostAddress();
//                            System.out.println("所有的ip is " + ip);
//                        }
//                    }
//                }
//            } catch (SocketException ex) {
//                ex.printStackTrace();
//            }
            System.out.println("dong ip:" + getIPAddress(this));
        }).start();
    }
    public static String getIPAddress(Context context) {
        NetworkInfo info = ((ConnectivityManager) context
            .getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)).bindProcessToNetwork(null);
//        }
        if (info != null && info.isConnected()) {
            if (info.getType() == ConnectivityManager.TYPE_MOBILE) {//当前使用2G/3G/4G网络
                try {
                    //Enumeration<NetworkInterface> en=NetworkInterface.getNetworkInterfaces();
                    if (NetworkInterface.getNetworkInterfaces() == null) {
                        System.out.println("ip size is 0");
                        return "";
                    }
                    for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements(); ) {
                        NetworkInterface intf = en.nextElement();
                        for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements(); ) {
                            InetAddress inetAddress = enumIpAddr.nextElement();
                            if (!inetAddress.isLoopbackAddress() && inetAddress instanceof Inet4Address) {
                                return inetAddress.getHostAddress();
                            }
                        }
                    }
                } catch (SocketException e) {
                    e.printStackTrace();
                }


            } else if (info.getType() == ConnectivityManager.TYPE_WIFI) {//当前使用无线网络
                WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
                WifiInfo wifiInfo = wifiManager.getConnectionInfo();
                String ipAddress = intIP2StringIP(wifiInfo.getIpAddress());//得到IPV4地址
                return ipAddress;
            } else if (info.getType() == ConnectivityManager.TYPE_ETHERNET) {

                //有线网络
                try {
                    // 获取本地设备的所有网络接口
                    Enumeration<NetworkInterface> enumerationNi = NetworkInterface
                        .getNetworkInterfaces();
                    while (enumerationNi.hasMoreElements()) {
                        NetworkInterface networkInterface = enumerationNi.nextElement();
                        String interfaceName = networkInterface.getDisplayName();
                        Log.i("tag", "网络名字" + interfaceName);

                        // 如果是有线网卡
                        if (interfaceName.equals("eth0")) {
                            Enumeration<InetAddress> enumIpAddr = networkInterface
                                .getInetAddresses();

                            while (enumIpAddr.hasMoreElements()) {
                                // 返回枚举集合中的下一个IP地址信息
                                InetAddress inetAddress = enumIpAddr.nextElement();
                                // 不是回环地址，并且是ipv4的地址
                                if (!inetAddress.isLoopbackAddress()
                                    && inetAddress instanceof Inet4Address) {
                                    Log.i("tag", inetAddress.getHostAddress() + "   ");

                                    return inetAddress.getHostAddress();
                                }
                            }
                        }
                    }

                } catch (SocketException e) {
                    e.printStackTrace();
                }

            }
        } else {
            //当前无网络连接,请在设置中打开网络
        }
        return null;
    }

    public static String intIP2StringIP(int ip) {
        return (ip & 0xFF) + "." +
            ((ip >> 8) & 0xFF) + "." +
            ((ip >> 16) & 0xFF) + "." +
            (ip >> 24 & 0xFF);
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
        System.out.println("level=" + level);
    }

}
