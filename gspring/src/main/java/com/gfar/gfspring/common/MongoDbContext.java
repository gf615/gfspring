package com.gfar.gfspring.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//@PropertySource(value = "classpath:mongodb-configuration.properties")
@Component
public class MongoDbContext {
    public static List<String> contentsIdList = new ArrayList<>(1000000);
    public static List<String> filesIdList = new ArrayList<>(1000000);
    public static List<String> convertsIdList = new ArrayList<>(1000000);

    public static String testOneCollectionInsert = "testOneCollectionInsert";
    public static String testThreeCollectionInsert = "testThreeCollectionInsert";
    public static String testCollectionInsertUnderOthers = "testCollectionInsertUnderOthers";
    public static String testThreeCollectionInsertUnderOthers = "testThreeCollectionInsertUnderOthers";
    public static String querySlaveDbOnCollection = "querySlaveDbOnCollection";
    public static String querySlaveDbThreeCollection = "querySlaveDbThreeCollection";

    public static String methodNameParam = "methodName";
    public static String threadCountParam = "threadCount";
    public static String documentsCountsThreadParam = "documentsCountsThread";
    public static String mongoUrlParam = "mongoUrl";
    public static String loadDocumentCountParam = "loadDocumentCount";

    public static int mongoPort = 30007;
    public static String username = "root";
    public static String password = "1qazWSX";
    public static String mongoDbName = "cystorage";
    public static List<String> mongoCollectionList = new ArrayList(){{
        this.add("contexts");
        this.add("files");
        this.add("converts");
    }};
    public static String fromMongoIp = "172.31.132.218";
    public static String toMongoIp = "172.31.132.189";

    public static String methodName = "";
    public static int threadCount = 1;
    public static int documentsCountsThread = 0;
    public static String mongoUrl = "";
    public static int loadDocumentCount = 0;
    public static int threadSleepTime = 0;


    @Value("${methodName}")
    public void setMethodName(String methodName) {
        MongoDbContext.methodName = methodName;
    }

    @Value("${threadCount}")
    public void setThreadCount(int threadCount) {
        MongoDbContext.threadCount = threadCount;
    }

    @Value("${documentsCountsThread}")
    public void setDocumentsCountsThread(int documentsCountsThread) {
        MongoDbContext.documentsCountsThread = documentsCountsThread;
    }

    @Value("${mongoUrl}")
    public void setMongoUrl(String mongoUrl) {
        MongoDbContext.mongoUrl = mongoUrl;
    }

    @Value("${loadDocumentCount}")
    public void setLoadDocumentCount(int loadDocumentCount) {
        MongoDbContext.loadDocumentCount = loadDocumentCount;
    }


    @Value("${threadSleepTime}")
    public void setThreadSleepTime(int threadSleepTime) {
        MongoDbContext.threadSleepTime = threadSleepTime;
    }
}
