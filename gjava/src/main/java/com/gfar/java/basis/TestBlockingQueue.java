package com.gfar.java.basis;

import java.util.concurrent.ArrayBlockingQueue;

public class TestBlockingQueue {
    public static void main(String[] args) {
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue(3);
        blockingQueue.add("test1");
        System.out.println("1====");
        blockingQueue.add("test2");
        System.out.println("2====");
        blockingQueue.add("test3");
        System.out.println("3====");
        blockingQueue.add("test4");
        System.out.println("4====");

    }
}
