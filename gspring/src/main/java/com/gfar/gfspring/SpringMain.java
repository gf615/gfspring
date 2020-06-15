package com.gfar.gfspring;

import com.gfar.gfspring.common.MongoDbContext;
import com.gfar.gfspring.service.mongodb.MongoDbService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {
    private static MongoDbService mongoDbService;
    public static void main(String[] args) {
        String configurationPath = "conf/applicationContext.xml";
        //启动容器，过程很复杂。
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(configurationPath);
        //applicationContext.getBean起到了工厂的作用，把实现和接口分离
        mongoDbService = applicationContext.getBean(MongoDbService.class);
        System.out.println(MongoDbContext.methodName);
    }
}
