package com.gfar.java.basis.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class TestServerSocket {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(9999));
        serverSocketChannel.configureBlocking(false);

        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (!Thread.currentThread().isInterrupted()){
            selector.select();
            Set<SelectionKey> keySet = selector.selectedKeys();
            Iterator<SelectionKey> selectionKeyIterator = keySet.iterator();
            while (selectionKeyIterator.hasNext()){
                SelectionKey key = selectionKeyIterator.next();
                if (!key.isValid()){
                    continue;
                }
                if (key.isAcceptable()){
                    doAccept(key);
                }
                if (key.isReadable()){
                    doRead(key);
                }
                if (key.isWritable()){
                    doWrite(key);
                }
            }

        }
    }



    private static void doAccept(SelectionKey key) throws IOException {
        ServerSocketChannel serverSocketChannel = (ServerSocketChannel)key.channel();
        SocketChannel socketChannel = serverSocketChannel.accept();

    }


    private static void doRead(SelectionKey key) {
    }
    private static void doWrite(SelectionKey key) {
    }
}
