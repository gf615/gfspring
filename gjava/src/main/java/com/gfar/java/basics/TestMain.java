package com.gfar.java.basics;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestMain {
    public static void main(String[] args) {
        StringBuilder indexName = new StringBuilder();
        Date date = new Date();
        System.currentTimeMillis();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        indexName.append(formatter.format((long)1587609733));

        System.out.println(indexName);
    }
}
