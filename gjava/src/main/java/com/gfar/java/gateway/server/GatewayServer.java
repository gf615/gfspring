package com.gfar.java.gateway.server;

import com.gfar.java.gateway.server.common.GatewayContext;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class GatewayServer {
    public static void main(String[] args) {
        initContext();
        initCommon();
        initService();
        initConnector();
    }


    //初始化上下文
    private static void initContext() {
        readConfigure();
    }

    //读取文件配置
    private static void readConfigure() {
        try {
            InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("configure.cfg");
            Properties properties = new Properties();
            properties.load(inputStream);

            String coreThreadSize = properties.getProperty("coreThreadSize");
            String maxThreadSize = properties.getProperty("maxThreadSize");
            String workQueueSize = properties.getProperty("workQueueSize");
            String threadTimeOut = properties.getProperty("threadTimeOut");
            if (coreThreadSize != null && !"".equals(coreThreadSize)){
                GatewayContext.getConfiguration().setCoreThreadSize(Integer.valueOf(coreThreadSize));
            }else {
                GatewayContext.getConfiguration().setCoreThreadSize(5);
            }

            if (maxThreadSize != null && !"".equals(maxThreadSize)){
                GatewayContext.getConfiguration().setMaxThreadSize(Integer.valueOf(maxThreadSize));
            }else {
                GatewayContext.getConfiguration().setMaxThreadSize(20);
            }

            if (workQueueSize != null && !"".equals(workQueueSize)){
                GatewayContext.getConfiguration().setWorkQueueSize(Integer.valueOf(workQueueSize));
            }else {
                GatewayContext.getConfiguration().setWorkQueueSize(100);
            }

            if (threadTimeOut != null && !"".equals(threadTimeOut)){
                GatewayContext.getConfiguration().setThreadTimeOut(Integer.valueOf(threadTimeOut));
            }else {
                GatewayContext.getConfiguration().setThreadTimeOut(100);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void initCommon() {
        Integer coreThreadSize = GatewayContext.getConfiguration().getCoreThreadSize();
        Integer maxThreadSize = GatewayContext.getConfiguration().getMaxThreadSize();
        Integer workQueueSize = GatewayContext.getConfiguration().getWorkQueueSize();
        Integer threadTimeOut = GatewayContext.getConfiguration().getThreadTimeOut();

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(coreThreadSize,maxThreadSize,threadTimeOut, TimeUnit.SECONDS,new ArrayBlockingQueue<>(workQueueSize));
        GatewayContext.setThreadPoolExecutor(threadPoolExecutor);
    }

    private static void initService() {
        try {
            ServerSocket serverSocket = new ServerSocket(9090);
            GatewayContext.setServerSocket(serverSocket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void initConnector() {
        ServerSocket serverSocket = GatewayContext.getServerSocket();
        while (true){
            try {
                Socket socket = serverSocket.accept();
                GatewayContext.totalRequest++;
                System.out.println("totalRequest="+GatewayContext.totalRequest);
                System.out.println("a new socket");
                Thread busiThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            InputStream inputStream = socket.getInputStream();
                            byte[] readerCache = new byte[8192];
                            StringBuffer stringBuffer = new StringBuffer(8192);
                            while (true){
                                int readLength = inputStream.read(readerCache);
                                if (readLength <= 0){
                                    break;
                                }
                               String msg = new String(readerCache);
                                stringBuffer.append(msg);
                            }

                            Thread.sleep(1000);
                            System.out.println(" server receive message = " + new String(stringBuffer));

                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }finally {
                            try {
                                socket.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
                busiThread.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
