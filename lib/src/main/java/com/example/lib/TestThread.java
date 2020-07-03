package com.example.lib;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Created by hp on 2020/3/25.
 */
public class TestThread {
    public static void main(String[] args) {
//        Thread2 runnable = new Thread2();
//        new Thread(runnable, "-1").start();
//        new Thread(runnable, "-2").start();

//        new MyThread3().createNewThread();

        /*
        * 线程生命周期：新建，就绪，运行，阻塞，死亡
        * 新建 (start)-> 就绪(获取服务器资源) -> 运行（1.run or call 方法执行完，2.error，3.exception，4.stop方法）-> 死亡
        * 运行（1.sleep，2.suspend，已弃用，抛异常，3.等待阻塞io方法，4.等synchronize锁，5.等待某个通知notify，生产者消费者）->阻塞
        * 阻塞（1.sleep时间到，2.resume，3.阻塞方法返回，4.获取同步锁，5.收到通知）->运行
        * */
        /*
        * 线程控制
        * 1.join:源码里，底层也是通过synchronize实现
        * 在主程序中调用某个线程的此方法的则此子线程一直执行完毕
        * （此时主线程处于阻塞状态，只有此子线程与其他非主线程并发执行），才让给主线程
        * 2.守护线程（精灵线程，后台线程）
        * setDaemon(true);
        *   由于前台线程都结束，故后台线程也结束，程序over,但可能会存在几毫秒的延迟
        * */
        //testJoin();
        tetYield();
    }

    public static class Thread2 implements Runnable{
        private int index;
        @Override
        public void run() {
            for (; index < 10; index++) {
                System.out.println(Thread.currentThread().getName() + ",index=" + index);
            }
        }
    }
    public static class MyThread3{
        public void createNewThread() {
            FutureTask<String> task = new FutureTask<>(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    int i = 0;
                    for (; i < 10; i++) {
                        System.out.println(Thread.currentThread().getName() + ",i=" + i);
                    }
                    return i + "个";
                }
            });
            new Thread(task, "thread2").start();
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + ",i=" + i);
                if (i == 5) {
                    new Thread(task, "thread1").start();//只能执行一次
//                    Thread.suspend();//容易导致死锁，避免使用，android sdk不让用，抛异常了

                    try {
                        Thread.sleep(10);//主线程阻塞
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
//                    try {
//                        System.out.println(task.get());//主线程阻塞 直到拿到结果主线程才会继续执行
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
                }
            }
        }
    }

    private static void tetYield() {
        new JoinThread("child thread 1").setProxy(Thread.MIN_PRIORITY).start();
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "," + Thread.currentThread().getPriority() + ",i=" + i);
            if (i == 20) {
                JoinThread jt = new JoinThread("child thread 2").setProxy(Thread.MAX_PRIORITY);
                jt.start();
                jt.yield();//让步，让系统的线程调度器重新调度一次，让其进入就绪状态，只有优先级比当前高或相同的线程才有机会执行
            }
        }
    }

    private static void testJoin() {
        new JoinThread("child thread 1").start();
        for (int i = 0; i < 30; i++) {
            System.out.println(Thread.currentThread().getName() + "," + Thread.currentThread().getPriority() + ",i=" + i);
            if (i == 20) {
                JoinThread jt = new JoinThread("child thread 2");
                jt.start();
                try {
                    jt.join();//子线程2加入到主线程，主线程阻塞，子线程1和子线程2继续执行，等到1,2执行完毕，主线程继续执行-多核无效！
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static class JoinThread extends Thread{
        public String name;

        public JoinThread(String name) {
            this.name=name;
        }

        public JoinThread setProxy(int level) {
            setPriority(level);
            return this;
        }
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                System.out.println(name +","+Thread.currentThread().getPriority()+ ",i=" + i);
            }
        }
    }

}
