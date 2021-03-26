package com.gfar.java.basis.collection.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 底层使用对象数组实现
 * CAS实现，Linux：lock cmpxchg
 */
public class TestArrayBlockingQueue {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(3,true);
        /**
         * 1、add，最终调用offer方法
         * 2、offer，方法开始，ReentrantLock.lock
         * 3、不会await阻塞等待，若已满直接抛异常
         */
        arrayBlockingQueue.add("test1");
        arrayBlockingQueue.add("test2");
        arrayBlockingQueue.add("test3");
        arrayBlockingQueue.add("test4");
        /**
         * 如果已满，则调用await方法阻塞；其他线程通过signal通知激活等待中的线程
         * 线程安全
         */
        arrayBlockingQueue.put("test1");
        arrayBlockingQueue.put("test2");
        arrayBlockingQueue.put("test3");
        arrayBlockingQueue.put("test4");

        /**
         * 若已满，直接返回false，不抛异常
         * 线程安全，reentrantLock.lock方法
         */
        arrayBlockingQueue.offer("test1");
        arrayBlockingQueue.offer("test2");
        arrayBlockingQueue.offer("test3");
        arrayBlockingQueue.offer("test4");
        //超过指定时间后，退出等待
        arrayBlockingQueue.offer("test5",10, TimeUnit.SECONDS);


        /**
         * 返回出队列的首元素，若队列为空，则返回null
         */
        arrayBlockingQueue.poll();
        //返回队头元素但不删除；若对垒为空，返回null
        arrayBlockingQueue.peek();
        //阻塞，
        arrayBlockingQueue.take();
        //调用poll方法
        arrayBlockingQueue.remove();

    }
}
