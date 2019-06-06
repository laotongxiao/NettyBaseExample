package com.test01;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * I只是为了分析read是一次从Buffer中读capacity个字节即allocate分配容量
 * break;是退出循环不再运行byteBuffer.flip();下的的语句
 */
public class NioTest01 {
    public static void main(String[] args) throws Exception{
        FileInputStream fileInputStream = new FileInputStream("Input.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("Output.txt");
        FileChannel inputChannel = fileInputStream.getChannel();
        FileChannel outputChannel = fileOutputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(8);
        int i=0;
        while (true){
            byteBuffer.clear();
            i++;
            int red = inputChannel.read(byteBuffer);
            if (red == -1){
                System.out.println("说明只到文件末才输出!");
                i--;
                break;
            }
            byteBuffer.flip();
            outputChannel.write(byteBuffer);
        }
        System.out.println("count i:" + i);
        fileInputStream.close();
        fileOutputStream.close();
    }
}
