package com.gfar.gfspring.service.mongodb;

public interface MongoDbService {
    void createCollection(String dbName,String collectionName);
    void insertDocument(String dbName, String collectionName, int count);
    void queryDocument(String dbName,String collectionName, int count);
    void updateDocument(String dbName,String collectionName, int count);
    void deleteDocument(String dbName,String collectionName, int count);
    void getQueryAndUpdateData(String dbName,String collectionName, int count);
    void deplayTest(String dbName,String collectionName,int count);
}
