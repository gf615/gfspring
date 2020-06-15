package com.gfar.java.basics.thread.multithreading;

import com.gfar.java.basics.thread.multithreading.bean.DataBean;
import com.gfar.java.basics.thread.multithreading.bean.UserVO;
import com.gfar.java.basics.thread.multithreading.context.TestContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProductThread {
    private static int size = 10;
    private static ExecutorService executorService = Executors.newFixedThreadPool(size);
    private static List<String> userIdList = new ArrayList<>();
    private static Random random = new Random(1);
    public static void startProduct() {
        for (int i=0;i<10;i++){
            userIdList.add(UUID.randomUUID().toString());
        }

        for (int i=0;i<size;i++){
            executorService.execute(()->{
                for (int j=0;j<10000;j++){
                    System.out.println(Thread.currentThread().getName()+Thread.currentThread().getId());
                    UserVO userVO = new UserVO();
                    userVO.setAddress("123");
                    String fromUserId = userIdList.get(random.nextInt(10));
                    String toUserId = userIdList.get(random.nextInt(10));
                    userVO.setUserId(fromUserId);
                    userVO.setName("测试"+fromUserId);
                    String conversationId = ConversationIdUtils.generateConversationId(fromUserId,toUserId);
                    System.out.println(conversationId);
                    DataBean dataBean = TestContext.userBeanMap.get(conversationId);
                    if (dataBean == null){
                        dataBean = new DataBean();
                        dataBean.setSyncTime(System.currentTimeMillis());
                    }
                    dataBean.setLastUser(userVO);
                    dataBean.getUserVOList().add(userVO);
                    TestContext.userBeanMap.put(conversationId,dataBean);
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
