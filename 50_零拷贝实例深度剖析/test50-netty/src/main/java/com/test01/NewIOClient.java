package com.test01;

import java.io.FileInputStream;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

/**
 * fileChannel.transferTo(0, fileChannel.size(), socketChannel);从文件系统的缓存(内核空间的内存,不是磁盘)中
 * 将字节直接传递给目标Channel,而不是实际的拷贝它们
 */
public class NewIOClient {
    public static void main(String[] args) throws Exception{
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress(8899));
        socketChannel.configureBlocking(true);

        String fileString = "H:\\lao.txt";
        FileChannel fileChannel = new FileInputStream(fileString).getChannel();
        long startTime = System.currentTimeMillis();
        long transferCount = fileChannel.transferTo(0, fileChannel.size(), socketChannel);
        System.out.println("发送总字节数:" + transferCount + " 耗时:" + (System.currentTimeMillis()-startTime));
        fileChannel.close();
        socketChannel.close();
    }
}
