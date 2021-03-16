package com.gfar.java.gateway.server.common;

import java.net.ServerSocket;
import java.util.concurrent.ThreadPoolExecutor;

public class GatewayContext {
    private static GateConfiguration configuration = new GateConfiguration();
    private static ThreadPoolExecutor threadPoolExecutor;
    private static ServerSocket serverSocket;

    public static Integer totalRequest = 0;

    public static GateConfiguration getConfiguration() {
        return configuration;
    }

    public static void setConfiguration(GateConfiguration configuration) {
        GatewayContext.configuration = configuration;
    }

    public static ThreadPoolExecutor getThreadPoolExecutor() {
        return threadPoolExecutor;
    }

    public static void setThreadPoolExecutor(ThreadPoolExecutor threadPoolExecutor) {
        GatewayContext.threadPoolExecutor = threadPoolExecutor;
    }

    public static ServerSocket getServerSocket() {
        return serverSocket;
    }

    public static void setServerSocket(ServerSocket serverSocket) {
        GatewayContext.serverSocket = serverSocket;
    }
}
