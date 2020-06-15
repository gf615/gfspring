package com.gfar.java.jvm.oom.two;

/**
 * 测试GC后，循环引用的对象是否被回收，间接的验证了jvm没有使用引用计数算法作为gc算法
 */
public class ReferenceCountingGc {
    public  Object instance = null;
    private static final int _1MB = 1024*1024;
    private byte[] bigSize = new byte[2 * _1MB];

    public static void testGC(){
        for (int i=0;i<10;i++){
            ReferenceCountingGc objA = new ReferenceCountingGc();
            ReferenceCountingGc objB = new ReferenceCountingGc();
            objA.instance = objB;
            objB.instance = objA;

            objA = null;
            objB = null;

            System.gc();
        }
    }

    public static void main(String[] args) {
        testGC();
    }
}
