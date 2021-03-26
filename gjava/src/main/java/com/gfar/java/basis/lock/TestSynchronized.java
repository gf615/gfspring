package com.gfar.java.basis.lock;

public class TestSynchronized {
    private static Object lock1 = new Object();
    private static Object lock2 = new Object();
    public static void main(String[] args) {

    }


    public static synchronized void sync1(){
        System.out.println(123);
    }


    public static void sync2(){
        synchronized (lock1){
            System.out.println(234);
        }
    }

    public static void sync3(){
        synchronized (lock2){
            try{
                System.out.println(345);
            }catch (Exception e){
                System.out.println(456);
            }
        }
    }
}
