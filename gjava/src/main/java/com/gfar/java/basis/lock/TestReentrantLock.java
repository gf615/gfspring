package com.gfar.java.basis.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 *
 */
public class TestReentrantLock {
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        System.out.println();
        reentrantLock.unlock();
    }
}
