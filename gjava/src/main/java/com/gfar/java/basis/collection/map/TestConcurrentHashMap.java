package com.gfar.java.basis.collection.map;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class TestConcurrentHashMap {
    public static void main(String[] args) {

        /**
         * jdk1.7，数组+链表方式实现
         * jdk1.8，数组+链表/红黑树方式实现
         */
        HashMap hashMap = new HashMap();
        hashMap.put("key1","test1");

        /**
         * jdk1.7，segment+数组+链表方式实现+ReentrantLock
         * jdk1.8，数组+链表/红黑树+Node+CAS
         */
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put("key1","test1");
    }
}
