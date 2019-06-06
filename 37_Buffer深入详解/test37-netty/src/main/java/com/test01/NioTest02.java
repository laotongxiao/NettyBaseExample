package com.test01;

import java.nio.ByteBuffer;

/**
 * byteBuffer1 为 byteBuffer一个块的快照
 */
public class NioTest02 {
    public static void main(String[] args){
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        for(int i=0; i<byteBuffer.capacity(); i++){
            byteBuffer.put((byte)i);
        }
        byteBuffer.position(2);
        byteBuffer.limit(6);
        ByteBuffer byteBuffer1 = byteBuffer.slice();

        for (int i=0; i<byteBuffer1.capacity(); i++){
            byte b = byteBuffer1.get();
            b *=2;
            byteBuffer1.put(i,b);
        }

        byteBuffer.position(0);
        byteBuffer.limit(10);
        while (byteBuffer.hasRemaining()){
            System.out.println(byteBuffer.get());
        }
    }
}
