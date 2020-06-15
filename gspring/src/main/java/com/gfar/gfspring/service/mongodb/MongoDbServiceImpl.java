package com.gfar.gfspring.service.mongodb;

import com.gfar.gfspring.common.MongoDbContext;
import com.gfar.gfspring.common.utils.MongoDbUtils;
import com.gfar.gfspring.dao.mongodb.MongoDbDao;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class MongoDbServiceImpl implements MongoDbService {
    @Autowired
    MongoDbDao mongoDbDao;

    @Autowired
    MongoTemplate mongoTemplate;

    @PostConstruct
    public void init(){
        System.out.println("init===============");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("destroy============");
    }


    @Override
    public void createCollection(String dbName, String collectionName) {
        MongoClient mongoClient = null;
        try {
            mongoClient = MongoDbUtils.getAuthMongoClient(MongoDbContext.mongoUrl,MongoDbContext.mongoPort,MongoDbContext.username,MongoDbContext.password);
            mongoClient.getDatabase(dbName).createCollection(collectionName);
        }finally {
            mongoClient.close();
        }
    }

    @Override
    public void insertDocument(String dbName, String collectionName, int count) {
//        MongoClient mongoClient = null;

//            mongoClient = MongoDbUtils.getAuthMongoClient(MongoDbContext.mongoUrl,MongoDbContext.mongoPort,MongoDbContext.username,MongoDbContext.password);
//            MongoCollection mongoCollection = mongoClient.getDatabase(dbName).getCollection(collectionName);
            Document document;
            for (int i=0;i<count;i++){
                String uuid = getUUId();
                String contextApp =  "app_"+(int)(Math.random()*10);
                if (collectionName.equalsIgnoreCase("contexts")){
                    document = MongoDbUtils.createContextsDocument(uuid,contextApp);
                }else if (collectionName.equalsIgnoreCase("files")){
                    document = MongoDbUtils.createFilesDocument(uuid,contextApp);
                }else if (collectionName.equalsIgnoreCase("converts")){
                    document = MongoDbUtils.createConvertsDocument(uuid,contextApp);
                }else {
                    document = MongoDbUtils.createContextsDocument(uuid,contextApp);
                }
//                mongoDbDao.insertDocumentOne(mongoCollection,document);
                try {
                    mongoTemplate.save(document,collectionName);
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
//            mongoClient.close();
                }
                for (int j =0;j<MongoDbContext.threadSleepTime;j++){
                    System.out.println(j);
                }
            }
    }

    @Override
    public void queryDocument(String dbName, String collectionName, int count) {
        MongoClient mongoClient = null;
        try {
            mongoClient = MongoDbUtils.getAuthMongoClient(MongoDbContext.mongoUrl,MongoDbContext.mongoPort,MongoDbContext.username,MongoDbContext.password);
            MongoCollection mongoCollection = mongoClient.getDatabase(dbName).getCollection(collectionName);
            System.out.println(MongoDbContext.contentsIdList.size());
            String documentId;
            for (int i=0;i<count;i++){
                if (collectionName.equalsIgnoreCase("contexts")){
                    documentId = MongoDbContext.contentsIdList.get(new Random().nextInt(MongoDbContext.contentsIdList.size()));
                }else if (collectionName.equalsIgnoreCase("files")){
                    documentId = MongoDbContext.filesIdList.get(new Random().nextInt(MongoDbContext.contentsIdList.size()));
                }else if (collectionName.equalsIgnoreCase("converts")){
                    documentId = MongoDbContext.convertsIdList.get(new Random().nextInt(MongoDbContext.contentsIdList.size()));
                }else {
                    documentId = MongoDbContext.contentsIdList.get(new Random().nextInt(MongoDbContext.contentsIdList.size()));
                }
                mongoDbDao.queryDocument(mongoCollection,documentId);
            }

        }finally {
            mongoClient.close();
        }
    }

    @Override
    public void updateDocument(String dbName, String collectionName, int count) {
        MongoClient mongoClient = null;
        try {
            mongoClient = MongoDbUtils.getAuthMongoClient(MongoDbContext.mongoUrl,MongoDbContext.mongoPort,MongoDbContext.username,MongoDbContext.password);
            MongoCollection mongoCollection = mongoClient.getDatabase(dbName).getCollection(collectionName);
            String documentId;
            BasicDBObject updateNewOneSql;
            for (int i=0;i<count;i++){
                if (collectionName.equalsIgnoreCase("contexts")){
                    documentId = MongoDbContext.contentsIdList.get(new Random().nextInt(MongoDbContext.contentsIdList.size()));
                    updateNewOneSql = new BasicDBObject("$set", new BasicDBObject("contextFileUrl", "121"));
                }else if (collectionName.equalsIgnoreCase("files")){
                    documentId = MongoDbContext.filesIdList.get(new Random().nextInt(MongoDbContext.contentsIdList.size()));
                    updateNewOneSql = new BasicDBObject("$set", new BasicDBObject("fileTmpPath", "122"));
                }else if (collectionName.equalsIgnoreCase("converts")){
                    documentId = MongoDbContext.convertsIdList.get(new Random().nextInt(MongoDbContext.contentsIdList.size()));
                    updateNewOneSql = new BasicDBObject("$set", new BasicDBObject("convParams", "123"));
                }else {
                    documentId = MongoDbContext.contentsIdList.get(new Random().nextInt(MongoDbContext.contentsIdList.size()));
                    updateNewOneSql = new BasicDBObject("$set", new BasicDBObject("contextFileUrl", "121"));
                }
                BasicDBObject updateOldSql = new BasicDBObject("_id", documentId);
                mongoDbDao.updateDocument(mongoCollection,updateOldSql,updateNewOneSql);
            }
        }finally {
            mongoClient.close();
        }
    }

    @Override
    public void deleteDocument(String dbName, String collectionName, int count) {
        MongoClient mongoClient = null;
        try {
            mongoClient = MongoDbUtils.getAuthMongoClient(MongoDbContext.mongoUrl,MongoDbContext.mongoPort,MongoDbContext.username,MongoDbContext.password);
            MongoCollection mongoCollection = mongoClient.getDatabase(dbName).getCollection(collectionName);
            for (int i=0;i<count;i++){
                String documentId = new Random(count).nextInt()+"";
                mongoDbDao.deleteDocument(mongoCollection,documentId);
            }

        }finally {
            mongoClient.close();
        }
    }

    @Override
    public void getQueryAndUpdateData(String dbName, String collectionName, int count) {
        MongoClient mongoClient = null;
        try {
            mongoClient = MongoDbUtils.getAuthMongoClient(MongoDbContext.mongoUrl,MongoDbContext.mongoPort,MongoDbContext.username,MongoDbContext.password);
            MongoCollection mongoCollection = mongoClient.getDatabase(dbName).getCollection(collectionName);
            List<String> idList = mongoDbDao.getQueryAndUpdateData(mongoCollection,count);
            if (collectionName.equalsIgnoreCase(MongoDbContext.mongoCollectionList.get(0))){
                MongoDbContext.contentsIdList.addAll(idList);
            }else if (collectionName.equalsIgnoreCase(MongoDbContext.mongoCollectionList.get(1))){
                MongoDbContext.filesIdList.addAll(idList);
            }else if (collectionName.equalsIgnoreCase(MongoDbContext.mongoCollectionList.get(2))){
                MongoDbContext.convertsIdList.addAll(idList);
            }else {
                MongoDbContext.contentsIdList.addAll(idList);
            }
        }finally {
            mongoClient.close();
        }
    }

    @Override
    public void deplayTest(String dbName, String collectionName,int count) {
        MongoClient fromMongoClient = null;
        MongoClient toMongoClient = null;
        try {
            fromMongoClient = MongoDbUtils.getAuthMongoClient(MongoDbContext.fromMongoIp,MongoDbContext.mongoPort,MongoDbContext.username,MongoDbContext.password);
            MongoCollection fromMongoCollection = fromMongoClient.getDatabase(dbName).getCollection(collectionName);

            toMongoClient = MongoDbUtils.getAuthMongoClient(MongoDbContext.toMongoIp,MongoDbContext.mongoPort,MongoDbContext.username,MongoDbContext.password);
            MongoCollection toMongoCollection = fromMongoClient.getDatabase(dbName).getCollection(collectionName);


            String contextApp =  "app_"+(int)(Math.random()*10);
            long deplayTotalTime =0;
            for (int i=0;i<count;i++){
                String uuid = getUUId();
                Document document = MongoDbUtils.createContextsDocument(uuid,contextApp);
                mongoDbDao.insertDocumentOne(fromMongoCollection,document);
                long startTime = System.currentTimeMillis();
                while (true){
                    Document slaveDocument = mongoDbDao.findDocumentByUUID(toMongoCollection,uuid);
                    if (slaveDocument != null){
                        break;
                    }
                }
                long endTime = System.currentTimeMillis();
                long onceDeplayTime = (endTime - startTime);
                deplayTotalTime += onceDeplayTime;
            }

            System.out.println("deplayTotalTime="+deplayTotalTime+",avgDeplayTime="+deplayTotalTime/count);

        }finally {
            fromMongoClient.close();
            toMongoClient.close();
        }
    }

    private  String getUUId(){
        return  UUID.randomUUID().toString().replace("-","");
    }

    public MongoDbDao getMongoDbDao() {
        return mongoDbDao;
    }

    public void setMongoDbDao(MongoDbDao mongoDbDao) {
        this.mongoDbDao = mongoDbDao;
    }
}
