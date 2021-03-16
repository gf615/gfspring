package com.gfar.gfspring.common.utils;

import com.mongodb.*;
import org.bson.Document;

import java.util.*;

public class MongoDbUtils {
    public static MongoClient getMongoClient(String ip, int port){
        return new MongoClient(ip,port);
    }

    public static MongoClient getAuthMongoClient(String ip,int port,String userName,String password){
        MongoClientOptions.Builder builder = MongoClientOptions.builder(); //可以通过builder做各种详细配置
        MongoClientOptions myOptions = builder.build();
        ArrayList<ServerAddress> serverAddressList = new ArrayList();
        ServerAddress record1 = new ServerAddress("172.31.132.218", 30007); //IP、端口
        ServerAddress record2 = new ServerAddress("172.31.132.218", 30017); //IP、端口
        serverAddressList.add(record1);
        serverAddressList.add(record2);

        //用户名、默认库名、密码
        MongoCredential credential = MongoCredential.createCredential(userName, "admin", password.toCharArray());
        return new MongoClient(serverAddressList, credential, myOptions);
    }

    public static Document createContextsDocument(String uuid,String contextApp){

        Document document = new Document();
        Map<String,Object> previews = new HashMap<>();
        previews.put("swf","http://test.download.cycore.cn/test/test_txt868b1fd0-ac5c-4bda-b335-84af1cdf9d74.swf");
        previews.put("html","http://test.download.cycore.cn/test/test_txt5458a5ca-8252-4e7a-885c-c4296504fc87.html");

        Map<String,Object> contextThumbnails = new HashMap<>();
        contextThumbnails.put("swf","http://test.download.cycore.cn/test/test_txt868b1fd0-ac5c-4bda-b335-84af1cdf9d74.swf");
        contextThumbnails.put("html","http://test.download.cycore.cn/test/test_txt5458a5ca-8252-4e7a-885c-c4296504fc87.html");

        document.append("contextApp",contextApp)
                .append("contextId",uuid)
                .append("contextIsChunk",false)
                .append("contextIsChunk","")
                .append("contextFileId","")
                .append("contextFilePath","test/"+contextApp+"/test.swf")
                .append("contextFileUrl","")
                .append("contextFileHost","http://test.download.cycore.cn")
                .append("contextContainerName","")
                .append("contextContainer",contextApp)
                .append("contextStorgeType","")
                .append("contextStorge","")
                .append("contextMonitor","")
                .append("contextStatus",1)
                .append("contextMD5","")
                .append("contextLength",0)
                .append("contextCallbackMethod","GET")
                .append("contextCallbackUrl","")
                .append("contextCallbackProtocol","HTTP")
                .append("contextCallbackParams","")
                .append("contextCallbackResponse","")
                .append("contextCallbackStatus",2)
                .append("contextCallbackTime",new Date())
                .append("contextBeginTime",new Date())
                .append("contextUploadTime",new Date())
                .append("contextEndTime",new Date())
                .append("contextConvTime",new Date())
                .append("contextMetadata","")
                .append("contextFilename","test.swf")
                .append("contextEncrypted",false)
                .append("contextContentEncryptedUrl","")
                .append("contextReskey","")
                .append("contextPreviews",previews)
                .append("contextThumbnails",contextThumbnails)
                .append("contextIllegal","")
                .append("contextFrom","")
                .append("contextSafetyLevel","");
       return document;
    }

    public static Document createFilesDocument(String uuid,String contextApp){
        Document document = new Document();
        document.append("uuid",uuid)
                .append("fileContainer",contextApp)
                .append("filePath","zhkt/service/upload/"+uuid+"/5m1575365955676.docx"   )
                .append("fileHost","http://test.download.cycore.cn")
                .append("fileExt","docx")
                .append("fileSize",0)
                .append("fileMD5",contextApp)
                .append("fileStorge",0)
                .append("fileTmpPath","")
                .append("fileUploadErrorMsg","")
                .append("fileUploadServerIP","127.0.0.1")
                .append("fileStatus",0)
                .append("fileCreateTime",new Date())
                .append("fileUploadedTime",new Date())
                .append("fileMetadata","")
                .append("filename","")
                .append("fileEncrypted","")
                .append("fileContentEncryptedUrl","")
                .append("fileReskey","");
        return document;
    }

    public static Document createConvertsDocument(String uuid,String contextApp){
        Document document = new Document();
        document.append("uuid",uuid)
                .append("convApp",contextApp)
                .append("convContext",contextApp)
                .append("convTaskId",uuid)
                .append("convType",11)
                .append("convParams","")
                .append("convResults","\"{\\\"filepath\\\":\\\"cyejiaxiao/aaa_txt4f6b3563-eeec-41f9-ba3a-b35186c34a5c.png\\\",\\\"encrypted\\\":false,\\\"downloadHost\\\":\\\"http://test.download.cycore.cn\\\",\\\"length\\\":1566,\\\"contextId\\\":\\\"5c9a227196bd877504a32b2a\\\",\\\"url\\\":\\\"http://test.download.cycore.cn/cyejiaxiao/aaa_txt4f6b3563-eeec-41f9-ba3a-b35186c34a5c.png\\\",\\\"status\\\":2,\\\"md5\\\":\\\"7605f883571acca71a3682cff70be0d5\\\"}\"")
                .append("convFiles","")
                .append("convStatus",0)
                .append("convProgress",100)
                .append("convCallbackUrl","192.168.62.69:7890/test/callback")
                .append("convCallbackMethod","POST")
                .append("convCallbackProtocol","HTTP")
                .append("convCallbackParams","key=1&value=2")
                .append("convCallbackHeaders","")
                .append("convCallbackResponse","I/O error on GET request for \\\"http://192.168.62.69:7890/test/callback?contextId=5575557ae4b024259460e814&convId=5575557ae4b024259460e816&convStatus=5&convResuts=")
                .append("convSendResponse",contextApp)
                .append("convCallbackStatus",0)
                .append("convCallbackTime",new Date())
                .append("convCreateTime",new Date())
                .append("convBeginTime",new Date())
                .append("convEndTime",new Date())
                .append("convRole",contextApp);
        return document;
    }


}
