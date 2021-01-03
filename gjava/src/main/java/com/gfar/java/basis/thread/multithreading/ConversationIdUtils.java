package com.gfar.java.basis.thread.multithreading;

/**
 * 单聊，根据发送和接收用户生成会话Id
 */
public class ConversationIdUtils {
    //通过比较
    public static String generateConversationId(String fromUserId,String toUserId){
        if (fromUserId.compareTo(toUserId) >= 0){
            return toUserId + " " + fromUserId;
        }else {
            return fromUserId + " " + toUserId;
        }
    }
}
