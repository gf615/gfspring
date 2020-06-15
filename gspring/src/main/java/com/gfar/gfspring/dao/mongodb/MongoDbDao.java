package com.gfar.gfspring.dao.mongodb;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.List;

public interface MongoDbDao {
    List<String> getQueryAndUpdateData(MongoCollection collection, int totalCount);
    String insertDocument(MongoCollection collection,List<Document> documents);
    String insertDocumentOne(MongoCollection collection,Document document);
    void deleteDocument(MongoCollection collection,String documentId);
    void updateDocument(MongoCollection collection, BasicDBObject updateOldSql, BasicDBObject updateNewOneSql);
    Document queryDocument(MongoCollection collection,String documentId);
    Document findDocumentByUUID(MongoCollection collection,String uuid);
}
