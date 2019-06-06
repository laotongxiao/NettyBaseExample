package com.test01;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * 用register办法把channel  注册到selector上 会导致一个key加到set key集合中	key增加是出事件驱动，人为不能操作
 * selector.select()它是一直阻塞，监听事件发生 它返回的是一个它关注事件的数量
 */
public class NioTest01 {
    public static void main(String[] args) throws Exception{
        int[] ports = new int[5];
        ports[0] = 5000;
        ports[1] = 5001;
        ports[2] = 5002;
        ports[3] = 5003;
        ports[4] = 5004;

        Selector selector = Selector.open();
        for (int i=0; i<ports.length; ++i){
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            ServerSocket serverSocket = serverSocketChannel.socket();
            InetSocketAddress address = new InetSocketAddress(ports[i]);
            serverSocket.bind(address);

            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("临时听端口:" + ports[i]);
        }

        while (true){
            int number = selector.select();
            System.out.println("number:" +number);
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            System.out.println("selectionKeys:" + selectionKeys);
            Iterator<SelectionKey> ite = selectionKeys.iterator();
            while (ite.hasNext()){
                SelectionKey selectionKey = ite.next();
                if (selectionKey.isAcceptable()){
                    /**
                     * 从selectionKey 中取得ServerChannel
                     * serverSocketChannel.accept()取得socketChannel
                     * 例如:因为一旦建起accept 8899连接,系统就会自动分配一个端口与客户端进行数据传送而不是8899端口
                     * 所以要取得socketChannel真实的通道
                     */
                    ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ);

                    ite.remove();
                    System.out.println("获得客户端连接:" + socketChannel);
                } else if(selectionKey.isReadable()){
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                    int bytesRead = 0;
                    while (true){
                        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
                        byteBuffer.clear();
                        int read = socketChannel.read(byteBuffer);
                        if (read <=0){
                            break;
                        }
                        byteBuffer.flip();
                        socketChannel.write(byteBuffer);
                        bytesRead += read;
                        System.out.println("读取:" + bytesRead + "来自于:" + socketChannel);
                        ite.remove();
                    }
                }
            }
        }
    }
}
