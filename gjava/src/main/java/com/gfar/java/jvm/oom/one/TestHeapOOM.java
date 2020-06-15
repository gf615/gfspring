package com.gfar.java.jvm.oom.one;

import java.util.ArrayList;
import java.util.List;

public class TestHeapOOM {

    public static void main(String[] args) {
        List<Object> objectList = new ArrayList<>();
        while (true){
            objectList.add(new Object());
        }
    }
}
