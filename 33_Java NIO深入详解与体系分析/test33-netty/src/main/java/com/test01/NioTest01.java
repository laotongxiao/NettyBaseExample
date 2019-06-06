package com.test01;

import java.nio.IntBuffer;
import java.security.SecureRandom;

/**
 * allocate 分配
 * capacity 容量
 * secure   安全
 * hasRemaining 有剩余
 * flip 反转
 *
 * limit    限制
 * position  位置
 * mark 标记
 */
public class NioTest01 {
    public static void main(String[] args){
        IntBuffer intBuffer = IntBuffer.allocate(10);
        for(int i=0; i<intBuffer.capacity(); i++){
            int randomNumber = new SecureRandom().nextInt(20);
            intBuffer.put(randomNumber);
        }

        intBuffer.flip();

        while (intBuffer.hasRemaining()){
            System.out.println(intBuffer.get());
        }
    }
}
