package com.test01;

import java.nio.ByteBuffer;

public class NioTest01 {
    public static void main(String[] args){
        ByteBuffer byteBuffer = ByteBuffer.allocate(100);
        byteBuffer.putInt(1);
        byteBuffer.putShort((short) 20);
        byteBuffer.putLong(300000L);
        byteBuffer.putChar('你');

        byteBuffer.flip();
        System.out.println(byteBuffer.getInt());
        System.out.println(byteBuffer.getShort());
        System.out.println(byteBuffer.getLong());
        System.out.println(byteBuffer.getChar());
    }
}
