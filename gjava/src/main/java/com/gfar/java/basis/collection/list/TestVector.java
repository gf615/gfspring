package com.gfar.java.basis.collection.list;

import java.util.Vector;

/**
 * 1、object数组存储，默认10个大小
 * 2、和ArrayList相同的扩容方式
 * 3、方法都有synchronized修饰
 * 4、
 */
public class TestVector {
    public static void main(String[] args) {
        Vector vector = new Vector();
        vector.add("test");
        vector.remove("test");

        System.out.println(vector.toString());
    }
}
