package com.gfar.java.basis.thread.signalthread;

public class TestRunable {
    public static void main(String[] args) {
        SignalRunThread signalRunThread = new SignalRunThread();
        Thread thread = new Thread(signalRunThread);
        thread.start();
    }
}
