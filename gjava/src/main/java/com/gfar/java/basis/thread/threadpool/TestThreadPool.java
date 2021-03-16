package com.gfar.java.basis.thread.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestThreadPool {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue taskBlockingQueue = new ArrayBlockingQueue(11);
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2,5,100, TimeUnit.SECONDS,taskBlockingQueue);
        for (int i=1;i<=13;i++){
            Runnable task = new Task("task"+i);
            poolExecutor.execute(task);
        }

        Thread.currentThread().join(100);
        System.out.println("123====");
        poolExecutor.shutdown();//不关闭线程池，不会退出jvm
    }
}
