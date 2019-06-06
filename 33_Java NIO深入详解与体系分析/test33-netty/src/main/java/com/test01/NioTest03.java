package com.test01;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 以程序为参照物
 * 把数据读入程序为InputStream
 * 把数据从程序读出为OutputStream
 * Buffer即内存块操作只能是字节用put get 而且一次只能读一个字节也就是一个字符
 * fileChannel.read(byteBuffer);如果是读read:是把信息从Channel读到Buffer中再从Buffer中获取信息
 * fileChannel.write(byteBuffer);如果是写write:是把信息放到Buffer再写Channel中
 *
 */
public class NioTest03 {
    public static void main(String[] args) throws Exception{
        FileOutputStream fileOutputStream = new FileOutputStream("NioTest02.txt");
        FileChannel fileChannel = fileOutputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        byte[] message = "Hello word wellcome!".getBytes();
        for (int i=0; i<message.length; i++){
            byteBuffer.put(message[i]);
        }

        byteBuffer.flip();

        fileChannel.write(byteBuffer);
        fileOutputStream.close();
    }
}
