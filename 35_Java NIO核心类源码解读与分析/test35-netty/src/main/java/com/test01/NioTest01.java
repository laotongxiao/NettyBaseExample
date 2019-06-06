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
 * 了解上面三个值的工作原理就能很好的对Buffer内存块读写操作，明确读写到那个位置
 */
public class NioTest01 {
    public static void main(String[] args){
        IntBuffer intBuffer = IntBuffer.allocate(10);
        System.out.println("分配内存空间即Buffer----------");
        System.out.println("capacity:" + intBuffer.capacity());
        System.out.println("position:" + intBuffer.position());
        System.out.println("limit:" + intBuffer.limit());
        System.out.println("使用内存空间即Buffer----------");
        for(int i=0; i<5; i++){
            int randomNumber = new SecureRandom().nextInt(20);
            intBuffer.put(randomNumber);
            System.out.println("capacity:" + intBuffer.capacity());
            System.out.println("position:" + intBuffer.position());
            System.out.println("limit:" + intBuffer.limit());
            System.out.println("-----------");
        }

        intBuffer.flip();
        System.out.println("反转内存空间即Buffer读写状态----------");
        System.out.println("capacity:" + intBuffer.capacity());
        System.out.println("position:" + intBuffer.position());
        System.out.println("limit:" + intBuffer.limit());
        System.out.println("反转后使用内存空间即Buffer----------");
        while (intBuffer.hasRemaining()){
            intBuffer.get();
            System.out.println("capacity:" + intBuffer.capacity());
            System.out.println("position:" + intBuffer.position());
            System.out.println("limit:" + intBuffer.limit());
            System.out.println("-----------");
        }
    }
}
