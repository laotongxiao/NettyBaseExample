package com.test01;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 传统IO如何切换到Nio
 */
public class NioTest02 {
    public static void main(String[] args) throws Exception{
        FileInputStream fileInputStream = new FileInputStream("NioTest02.txt");
        FileChannel fileChannel = fileInputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        fileChannel.read(byteBuffer);

        byteBuffer.flip();

        while (byteBuffer.hasRemaining()){
            byte b = byteBuffer.get();
            System.out.println("Char:" + (char)b);
        }

        fileInputStream.close();
    }
}
