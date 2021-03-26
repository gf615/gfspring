package com.gfar.java.basis.thread.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * java线程池任务执行过程
 * 1、开始，任务队列为空，执行线程为空
 * 2、新增任务，当前存活线程小于等于corePoolSize，启动新线程执行任务
 * 3、新增任务，当前对此线程大于corePoolSize,添加到taskBlockingQueue
 * 4、新增任务，任务队列已满，启动非核心线程，并且线程总数小于maxPoolSize，执行新任务
 * 5、新增任务，当前任务队列已满，线程数已达到maxPoolSize，则执行拒绝策略
 *
 * 思想
 *  线程池创建的线程，是线程池自实现的（worker）
 *  在线程work的run方法中调用task的run方法。
 *  基本思想：接口回调
 */

public class TestThreadPool {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue taskBlockingQueue = new ArrayBlockingQueue(11);
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2,5,100, TimeUnit.SECONDS,taskBlockingQueue);
        for (int i=1;i<=18;i++){
            Runnable task = new Task("task"+i);
            poolExecutor.execute(task);
        }

        Thread.currentThread().join(100);
        System.out.println("123====");
        poolExecutor.shutdown();//不关闭线程池，不会退出jvm
    }
}
