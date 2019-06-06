package com.test01;

import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * 给文件加锁
 */
public class NioTest02 {
    public static void main(String[] args) throws Exception{
        RandomAccessFile randomAccessFile = new RandomAccessFile("NioTest02.txt", "rw");
        FileChannel fileChannel = randomAccessFile.getChannel();
        FileLock fileLock = fileChannel.lock(3, 6 ,true);
        System.out.println(fileLock.isValid());
        System.out.println(fileLock.isShared());
        fileLock.release();
        randomAccessFile.close();
    }
}
