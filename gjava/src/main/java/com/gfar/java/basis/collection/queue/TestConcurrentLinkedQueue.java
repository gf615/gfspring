package com.gfar.java.basis.collection.queue;

import java.util.concurrent.ConcurrentLinkedQueue;

public class TestConcurrentLinkedQueue {
    public static void main(String[] args) {
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
        concurrentLinkedQueue.add("test1");
        concurrentLinkedQueue.offer("test2");

        concurrentLinkedQueue.peek();
        concurrentLinkedQueue.poll();

    }
}
