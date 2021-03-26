package com.gfar.java.basis.cas;

import java.util.concurrent.atomic.AtomicInteger;

public class TestCas {

    public static void main(String[] args) {
        AtomicInteger atomicInteger =  new AtomicInteger();
        atomicInteger.getAndIncrement();
        System.out.println(atomicInteger.get());
    }
}
