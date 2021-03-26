package com.gfar.java.basis.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TestReadWriteLock {
    public static void main(String[] args) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        reentrantReadWriteLock.readLock().lock();
        System.out.println(123);
        reentrantReadWriteLock.readLock().unlock();


    }

}
