package com.gfar.java.basis.thread.signalthread;

public class SignalThread extends Thread {
    @Override
    public void run() {
        for (int i=0;i<100;i++){
            System.out.println("test i="+i);
        }
    }
}
