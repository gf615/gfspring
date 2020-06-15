package com.gfar.gfspring;

import com.gfar.gfspring.common.MongoDbContext;
import com.gfar.gfspring.service.mongodb.MongoDbService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GfsrpingMain {
    static MongoDbService mongoDbService;
    public static void main(String[] args) {
        String configurationPath = "conf/applicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(configurationPath);
        mongoDbService = applicationContext.getBean(MongoDbService.class);
        //start
        start();
    }

    static void start(){
        if (MongoDbContext.methodName.equalsIgnoreCase(MongoDbContext.testOneCollectionInsert)){
            //单库单表插入
            testOneCollectionInsert();
        }else if(MongoDbContext.methodName.equalsIgnoreCase(MongoDbContext.testThreeCollectionInsert)){
            //单库多表插入
            testThreeCollectionInsert();
        }else if(MongoDbContext.methodName.equalsIgnoreCase(MongoDbContext.testCollectionInsertUnderOthers)){
            //单库单表：插入，查询，更新，删除
            loadQueryAndUpdateAndDeleteIdList();
            testCollectionInsertUnderOthers();
        }else if(MongoDbContext.methodName.equalsIgnoreCase(MongoDbContext.testThreeCollectionInsertUnderOthers)){
            //单库多表：插入，查询，更新，删除
            loadManyCollectionQueryAndUpdateAndDeleteIdList();
            testThreeCollectionInsertUnderOthers();
        }else if(MongoDbContext.methodName.equalsIgnoreCase(MongoDbContext.querySlaveDbOnCollection)){
            //单表查询
            loadQueryAndUpdateAndDeleteIdList();
            querySlaveDbOnCollection();
        }else if(MongoDbContext.methodName.equalsIgnoreCase(MongoDbContext.querySlaveDbThreeCollection)){
            //多表查询
            loadManyCollectionQueryAndUpdateAndDeleteIdList();
            querySlaveDbThreeCollection();
        }

    }

    //加载数据
    static void loadQueryAndUpdateAndDeleteIdList(){
        mongoDbService.getQueryAndUpdateData(MongoDbContext.mongoDbName,MongoDbContext.mongoCollectionList.get(0),MongoDbContext.loadDocumentCount);
    }

    //加载数据
    static void loadManyCollectionQueryAndUpdateAndDeleteIdList(){
        for (String collectionName:MongoDbContext.mongoCollectionList){
            mongoDbService.getQueryAndUpdateData(MongoDbContext.mongoDbName,collectionName,MongoDbContext.loadDocumentCount);
        }
    }

    //1.单表插入：1个线程插入，5个线程插入，10个线程插入
    static void testOneCollectionInsert(){
        String dbName = MongoDbContext.mongoDbName;
        String collectionName = "contexts";
        int threadCount = MongoDbContext.threadCount;
        int documentCounts = MongoDbContext.documentsCountsThread;
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        for (int i=0;i<threadCount;i++){
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    mongoDbService.insertDocument(dbName,collectionName,documentCounts);
                }
            });
        }
        executorService.shutdown();
    }

    //2.单表插入，同时查询、更新、删除：1个线程；5个线程，10个线程
    static void testCollectionInsertUnderOthers(){
        String dbName = MongoDbContext.mongoDbName;
        String collectionName = MongoDbContext.mongoCollectionList.get(0);
        int threadCount = MongoDbContext.threadCount;
        int documentCounts = MongoDbContext.documentsCountsThread;
        //插入
        ExecutorService insertExecutorService = Executors.newFixedThreadPool(threadCount);
        for (int i=0;i<threadCount;i++){
            insertExecutorService.execute(new Runnable() {
                @Override
                public void run() {
                    mongoDbService.insertDocument(dbName,collectionName,documentCounts);
                }
            });
        }
        insertExecutorService.shutdown();

        //查询
        ExecutorService queryExecutorService = Executors.newFixedThreadPool(threadCount);
        for (int i=0;i<threadCount;i++){
            queryExecutorService.execute(new Runnable() {
                @Override
                public void run() {
                    mongoDbService.queryDocument(dbName,collectionName,documentCounts);
                }
            });
        }
        queryExecutorService.shutdown();

        //删除
        ExecutorService delExecutorService = Executors.newFixedThreadPool(threadCount);
        for (int i=0;i<threadCount;i++){
            delExecutorService.execute(new Runnable() {
                @Override
                public void run() {
                    mongoDbService.deleteDocument(dbName,collectionName,documentCounts);
                }
            });
        }
        delExecutorService.shutdown();

        //更新
        ExecutorService updateExecutorService = Executors.newFixedThreadPool(threadCount);
        for (int i=0;i<threadCount;i++){
            updateExecutorService.execute(new Runnable() {
                @Override
                public void run() {
                    mongoDbService.updateDocument(dbName,collectionName,documentCounts);
                }
            });
        }
        updateExecutorService.shutdown();
    }

    //3.多张表插入：1个线程插入，5个线程插入，10个线程插入
    static void testThreeCollectionInsert(){
        String dbName = MongoDbContext.mongoDbName;
        int threadCount = MongoDbContext.threadCount;
        int documentCounts = MongoDbContext.documentsCountsThread;

        for (String collectionName : MongoDbContext.mongoCollectionList){
            ExecutorService executorService1 = Executors.newFixedThreadPool(threadCount);
            for (int i=0;i<threadCount;i++){
                executorService1.execute(new Runnable() {
                    @Override
                    public void run() {
                        mongoDbService.insertDocument(dbName,collectionName,documentCounts);
                    }
                });
            }
            executorService1.shutdown();
        }
    }



    //4.多表插入，同时查询、更新、删除：1个线程，5个线程，10个线程
    static void testThreeCollectionInsertUnderOthers(){
        String dbName = MongoDbContext.mongoDbName;
        int threadCount = MongoDbContext.threadCount;
        int documentCounts = MongoDbContext.documentsCountsThread;


        for (String collectionName : MongoDbContext.mongoCollectionList){
            //插入
            ExecutorService insertExecutorService1 = Executors.newFixedThreadPool(threadCount);
            for (int i=0;i<threadCount;i++){
                insertExecutorService1.execute(new Runnable() {
                    @Override
                    public void run() {
                        mongoDbService.insertDocument(dbName,collectionName,documentCounts);
                    }
                });
            }
            insertExecutorService1.shutdown();

            //查询
            ExecutorService queryExecutorService1 = Executors.newFixedThreadPool(threadCount);
            for (int i=0;i<threadCount;i++){
                queryExecutorService1.execute(new Runnable() {
                    @Override
                    public void run() {
                        mongoDbService.queryDocument(dbName,collectionName,documentCounts);
                    }
                });
            }
            queryExecutorService1.shutdown();

            //删除
            ExecutorService delExecutorService1 = Executors.newFixedThreadPool(threadCount);
            for (int i=0;i<threadCount;i++){
                delExecutorService1.execute(new Runnable() {
                    @Override
                    public void run() {
                        mongoDbService.deleteDocument(dbName,collectionName,documentCounts);
                    }
                });
            }
            delExecutorService1.shutdown();

            //更新
            ExecutorService updateExecutorService1 = Executors.newFixedThreadPool(threadCount);
            for (int i=0;i<threadCount;i++){
                updateExecutorService1.execute(new Runnable() {
                    @Override
                    public void run() {
                        mongoDbService.updateDocument(dbName,collectionName,documentCounts);
                    }
                });
            }
            updateExecutorService1.shutdown();
        }
    }

    static void querySlaveDbOnCollection() {
        String dbName = MongoDbContext.mongoDbName;
        int threadCount = MongoDbContext.threadCount;
        int documentCounts = MongoDbContext.documentsCountsThread;
        //查询
        ExecutorService queryExecutorService1 = Executors.newFixedThreadPool(threadCount);
        for (int i = 0; i < threadCount; i++) {
            queryExecutorService1.execute(new Runnable() {
                @Override
                public void run() {
                    mongoDbService.queryDocument(dbName, MongoDbContext.mongoCollectionList.get(0), documentCounts);
                }
            });
        }
        queryExecutorService1.shutdown();
    }

    static void querySlaveDbThreeCollection() {
        String dbName = MongoDbContext.mongoDbName;
        int threadCount = MongoDbContext.threadCount;
        int documentCounts = MongoDbContext.documentsCountsThread;

        for (String collectionName : MongoDbContext.mongoCollectionList) {
            //查询
            ExecutorService queryExecutorService1 = Executors.newFixedThreadPool(threadCount);
            for (int i = 0; i < threadCount; i++) {
                queryExecutorService1.execute(new Runnable() {
                    @Override
                    public void run() {
                        mongoDbService.queryDocument(dbName, collectionName, documentCounts);
                    }
                });
            }
            queryExecutorService1.shutdown();
        }
    }
}
