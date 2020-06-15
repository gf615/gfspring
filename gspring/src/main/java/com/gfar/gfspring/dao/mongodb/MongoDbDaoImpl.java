package com.gfar.gfspring.dao.mongodb;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class MongoDbDaoImpl implements MongoDbDao {

    public List<String> getQueryAndUpdateData(MongoCollection collection, int totalCount) {
        List<String> idList = new ArrayList<>();
        MongoCursor mongoCursor = collection.find().projection(new BasicDBObject().append("_id", 1)).iterator();
        for (int index = 0; index<totalCount; index++){
            if (mongoCursor.hasNext()){
                Document result = (Document)mongoCursor.next();
                idList.add(result.get("_id").toString());
            }
        }
        return idList;
    }

    public String insertDocument(MongoCollection collection,List<Document> documents) {
        collection.insertMany(documents);
        return "";
    }
    public String insertDocumentOne(MongoCollection collection,Document document) {
        collection.insertOne(document);
        return "";
    }

    public void deleteDocument(MongoCollection collection,String documentId) {
        BasicDBObject delSql = new BasicDBObject("_id", documentId);
        collection.deleteOne(delSql);
    }

    public void updateDocument(MongoCollection collection,BasicDBObject updateOldSql,BasicDBObject updateNewOneSql) {
        collection.updateOne(updateOldSql,updateNewOneSql);
    }

    public Document queryDocument(MongoCollection collection,String documentId) {
        BasicDBObject querySql = new BasicDBObject("_id", documentId);
        FindIterable<Document> queryRst = collection.find(querySql);
        MongoCursor<Document> cursor = queryRst.iterator();
        if (cursor.hasNext()){
            return cursor.next();
        }
        return null;
    }

    @Override
    public Document findDocumentByUUID(MongoCollection collection, String uuid) {
        BasicDBObject querySql = new BasicDBObject("uuid", uuid);
        FindIterable<Document> queryRst = collection.find(querySql);
        MongoCursor<Document> cursor = queryRst.iterator();
        if (cursor.hasNext()){
            return cursor.next();
        }
        return null;
    }
}
