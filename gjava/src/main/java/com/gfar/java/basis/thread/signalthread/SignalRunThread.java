package com.gfar.java.basis.thread.signalthread;

public class SignalRunThread implements Runnable {
    @Override
    public void run() {
        for (int i=0;i<100;i++){
            System.out.println("test a="+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
