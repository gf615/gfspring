package com.gfar.gaggregationimsdk.aggregationimserversdk.utils;

public class ConversationIdUtils {
    public static void main(String[] args) {
        System.out.println(generateConversationId("35839458775731","35839450770354:2"));
        System.out.println(generateConversationId("35839450770354:2","35839458775731"));
    }
    public static String generateConversationId(String fromUserId,String toUserId){
        if (fromUserId.compareTo(toUserId) >= 0){
            return toUserId+" "+fromUserId;
        }else {
            return fromUserId+" "+toUserId;
        }
    }
}
