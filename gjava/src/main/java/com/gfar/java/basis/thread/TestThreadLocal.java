package com.gfar.java.basis.thread;

import java.util.UUID;

public class TestThreadLocal {
    private static ThreadLocal threadLocal = new ThreadLocal();
    public static void main(String[] args) throws InterruptedException {
        for (int i =0;i<1000000;i++){
            new Thread(()-> {
                threadLocal.set("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
            }).start();
        }

        System.out.println("stop==============");

        Thread.sleep(100000);
    }
}
