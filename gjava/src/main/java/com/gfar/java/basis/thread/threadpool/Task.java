package com.gfar.java.basis.thread.threadpool;

public class Task implements Runnable {
    String taskName;
    public Task(String taskName){
        this.taskName = taskName;
    }
    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        for (int i=0;i<5;i++){
            System.out.println("thread = "+threadName+",taskName="+taskName+",test a="+i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return;
    }
}
