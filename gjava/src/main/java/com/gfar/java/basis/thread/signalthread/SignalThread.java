package com.gfar.java.basis.thread.signalthread;

public class SignalThread {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<1000;i++){
                    System.out.println("test="+i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"Test111");

        thread.start();
    }
}
