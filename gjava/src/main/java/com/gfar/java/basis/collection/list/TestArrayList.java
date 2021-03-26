package com.gfar.java.basis.collection.list;

import java.util.ArrayList;

/**
 * 1、底层使用object[] 存储，初始化大小0
 * 2、add方法，若为0或小于10，则初始化大小为10
 * 2.1 add方法，直接使用下标赋值
 * 2.2 remove方法，删除需移动数据
 * 3、若需要扩容，则扩容到当前大小的1.5倍
 * 4、非线程安全
 * 5、contains方法，循环变量数组，调用equals方法比较
 */
public class TestArrayList {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(0,"test0");
        arrayList.add(1,"test1");
        arrayList.add(2,"test2");
        arrayList.add(1,"test11");
        arrayList.add(4,"test11");
        arrayList.remove(2);
        arrayList.contains("test0");
        System.out.println(arrayList.toString());

    }
}
