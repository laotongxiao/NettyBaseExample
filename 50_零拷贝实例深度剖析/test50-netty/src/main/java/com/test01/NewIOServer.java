package com.test01;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * 当断开客户端连接时,socket关没有马上关闭,别的客户客户端连接时就是提示品占用,而解决这样的问题就是
 * serverSocket.setReuseAddress(true);表示time wait时间等待再
 * serverSocket.bind(inetSocketAddress)
 *
 * byteBuffer.rewind()是把position = 0 mark =-1 这样就可以再读把之前的byteBuffer复盖掉
 */
public class NewIOServer {
    public static void main(String[] args) throws Exception{
        InetSocketAddress inetSocketAddress = new InetSocketAddress(8899);
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        ServerSocket serverSocket =serverSocketChannel.socket();
        serverSocket.setReuseAddress(true);
        serverSocket.bind(inetSocketAddress);
        ByteBuffer byteBuffer = ByteBuffer.allocate(4096);
        while (true){
            SocketChannel socketChannel = serverSocketChannel.accept();
            socketChannel.configureBlocking(true);
            int readCount = 0;
            long countLength = 0;
            while (-1 != readCount){
                try {
                    readCount = socketChannel.read(byteBuffer);
                    System.out.println("readCount:----" + readCount);
                    countLength += readCount;
                } catch (Exception ex){
                    ex.printStackTrace();
                }
                byteBuffer.rewind();
            }
            System.out.println("countLength:-----------" + countLength);
        }
    }
}
