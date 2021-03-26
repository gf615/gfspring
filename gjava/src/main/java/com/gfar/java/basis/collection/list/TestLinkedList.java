package com.gfar.java.basis.collection.list;

import java.util.LinkedList;

/**
 * 1、创建，使用默认构造函数
 * 2、对象，有两个属性，last和size
 * 3、元素类型：Node<E>：三个属性，item：E、next：Node、pre：Node
 * 4、添加元素（不指定index），添加到last数据后面
 * 5、添加元素（指定index，找到指定位置），先和size比较，在前部分还是在后部分。若在前部分，for循环到index查找；若在后部分，从index开始循环。
 * 6、添加元素（指定index），若index大于size，则越界异常
 * 6.1 删除元素，找出元素，修改指针引用
 * 7、非线程安全
 */
public class TestLinkedList {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add("test1");
        linkedList.add(1,"test2");
        linkedList.remove(1);


        System.out.println(linkedList.toString());
    }
}
