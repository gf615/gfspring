package com.gfar.java.basis.string;

import java.util.concurrent.locks.ReentrantLock;

public class TestString {
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        /**
         * 1.编译后，字符串+操作，会优化成stringBuilder.append()操作。
         * 2.append方法扩容逻辑：value 字符数组，默认大小16
         *  2.1，若count+str.length >value.length，就扩容
         *  2.2，对value.length扩为2倍+2.若可以存放，则此值为新的容量；若不能存放，则容量为count+str.length
         */
        String a = "123";
        String b = "456";
        String c = a + b;
        System.out.println(c);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("123");
        stringBuilder.append("456");
        System.out.println(stringBuilder.toString());

        /**
         * 扩容逻辑和stringBuffer扩容逻辑一样，见上述描述
         * 线程安全，append方法使用synchronized修饰
         */
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("abc");
        stringBuffer.append("efg");
        System.out.println(stringBuffer.toString());
    }
}
