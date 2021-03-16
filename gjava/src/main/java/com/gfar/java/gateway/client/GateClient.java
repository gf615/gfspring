package com.gfar.java.gateway.client;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class GateClient {
    public static void main(String[] args) {
        try {
            for (int i = 1;i<=13;i++){
                Socket socket = new Socket("127.0.0.1",9090);
                OutputStream outputStream = socket.getOutputStream();
                PrintWriter printWriter = new PrintWriter(outputStream);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                printWriter.write("test"+i);
                printWriter.flush();

                System.out.println("req i="+i);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
