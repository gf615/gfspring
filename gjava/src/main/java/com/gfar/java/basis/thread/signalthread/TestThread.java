package com.gfar.java.basis.thread.signalthread;


public class TestThread {
    public static void main(String[] args) {
        Thread thread = new SignalThread();
        thread.start();
    }
}
