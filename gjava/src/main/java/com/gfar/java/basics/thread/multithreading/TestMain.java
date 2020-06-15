package com.gfar.java.basics.thread.multithreading;

import com.gfar.java.basics.thread.multithreading.bean.DataBean;
import com.gfar.java.basics.thread.multithreading.context.TestContext;

import java.util.Map;

public class TestMain {
    public static void main(String[] args) throws InterruptedException {
        ProductThread.startProduct();

        while (true){
            int count = 0;
            Map<String, DataBean> dataBeanMap =  TestContext.userBeanMap;
            for (Map.Entry<String,DataBean> entry : dataBeanMap.entrySet()){
                count += entry.getValue().getUserVOList().size();
            }
            System.out.println("count================="+count);

            Thread.sleep(1000);
        }
    }
}
