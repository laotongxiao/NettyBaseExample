package com.test01;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;

/**
 * 内存映射文件即对内存MappedByteBuffer修改就等于直接修改件，不用再写入文件
 */
public class NioTest01 {
    public static void main(String[] args) throws Exception{
        RandomAccessFile randomAccessFile = new RandomAccessFile("NioTest01.txt", "rw");

        FileChannel fileChannel = randomAccessFile.getChannel();
        MappedByteBuffer mappedByteBuffer = fileChannel.map(MapMode.READ_WRITE,0,5);
        mappedByteBuffer.put(0,(byte)'A');
        mappedByteBuffer.put(3,(byte)'B');
        randomAccessFile.close();
    }
}
