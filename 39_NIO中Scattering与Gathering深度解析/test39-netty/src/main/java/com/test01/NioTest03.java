package com.test01;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

/**
 * scattering   分散
 * gathering    集合
 * buffer数组分类存放操作,比如协议的头部分,数据部分把它分开存放很有用
 * Arrays.asList(byteBuffers).stream() 是把byteBuffers转成一个集合并获取到流对象
 */
public class NioTest03 {
    public static void main(String[] args) throws Exception{
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress address = new InetSocketAddress(8899);
        serverSocketChannel.socket().bind(address);
        /**
         * 这个地方是堵塞的，没有客户端连接就停在这
         */
        SocketChannel socketChannel = serverSocketChannel.accept();

        int messaglength = 2 + 3 + 4;
        ByteBuffer[] byteBuffers = new ByteBuffer[3];
        byteBuffers[0] = ByteBuffer.allocate(2);
        byteBuffers[1] = ByteBuffer.allocate(3);
        byteBuffers[2] = ByteBuffer.allocate(4);
        while (true){

            int bytesRead = 0;
            while (bytesRead < messaglength){
                /**
                 * read这个地方是堵塞的，没有读到数据就停在这
                 */
                long r = socketChannel.read(byteBuffers);
                bytesRead += r;
                System.out.println("bytesRead:" + bytesRead);
                Arrays.asList(byteBuffers).stream().forEach(byteBuffer -> {
                    System.out.println("读数据buffer状态---------");
                    System.out.println("position:" + byteBuffer.position());
                    System.out.println("limit:" + byteBuffer.limit());
                });
            }

            Arrays.asList(byteBuffers).forEach(byteBuffer -> {
                byteBuffer.flip();
            });

            int bytesWrite = 0;
            while (bytesWrite < messaglength){
                long r = socketChannel.write(byteBuffers);
                bytesWrite += r;
                System.out.println("bytesWrite:" + bytesWrite);
                Arrays.asList(byteBuffers).stream().forEach(byteBuffer -> {
                    System.out.println("写数据buffer状态---------");
                    System.out.println("position:" + byteBuffer.position());
                    System.out.println("limit:" + byteBuffer.limit());
                });
            }

            Arrays.asList(byteBuffers).forEach(byteBuffer -> {
                byteBuffer.clear();
            });

            System.out.println("bytesRead:" + bytesRead + " " + "bytesWrite:" + bytesWrite + " " + "messageLength:" + messaglength);
        }

    }
}
