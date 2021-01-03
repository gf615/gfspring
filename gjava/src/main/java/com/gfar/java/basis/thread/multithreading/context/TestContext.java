package com.gfar.java.basis.thread.multithreading.context;

import com.gfar.java.basis.thread.multithreading.bean.DataBean;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TestContext {
    public static Map<String, DataBean> userBeanMap = new ConcurrentHashMap<>();
}
