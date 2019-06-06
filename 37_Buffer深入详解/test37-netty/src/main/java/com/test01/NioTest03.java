package com.test01;

import java.nio.ByteBuffer;

/**
 * Buffer调用asReadOnlyBuffer方法返回一个只读Buffer
 */
public class NioTest03 {
    public static void main(String[] args){
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        for (int i=0; i<byteBuffer.capacity(); i++){
            byteBuffer.put((byte)i);
        }
        ByteBuffer byteBuffer1 = byteBuffer.asReadOnlyBuffer();
        byteBuffer1.flip();
        while (byteBuffer1.hasRemaining()){
            Byte b = byteBuffer1.get();
            System.out.println(b);
        }
    }
}
