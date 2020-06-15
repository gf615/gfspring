package com.gfar.gfspring;

import com.gfar.gfspring.common.MongoDbContext;
import com.gfar.gfspring.service.mongodb.MongoDbService;
import com.gfar.gfspring.service.mongodb.MongoDbServiceImpl;

public class DelayTestMain {
    static MongoDbService mongoDbService = new MongoDbServiceImpl();
    public static void main(String[] args) {
        mongoDbService.deplayTest(MongoDbContext.mongoDbName,MongoDbContext.mongoCollectionList.get(0),10);
    }
}
