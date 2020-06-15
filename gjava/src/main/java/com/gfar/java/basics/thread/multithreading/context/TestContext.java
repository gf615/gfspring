package com.gfar.java.basics.thread.multithreading.context;

import com.gfar.java.basics.thread.multithreading.bean.DataBean;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TestContext {
    public static Map<String, DataBean> userBeanMap = new ConcurrentHashMap<>();
}
