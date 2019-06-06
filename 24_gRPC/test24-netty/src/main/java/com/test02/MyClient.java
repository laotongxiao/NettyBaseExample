package com.test02;

import com.test01.MyRequest;
import com.test01.MyResponse;
import com.test01.StudentServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class MyClient {
    public static void main(String[] args){
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 8899).
                usePlaintext().build();
        StudentServiceGrpc.StudentServiceBlockingStub blockingStub = StudentServiceGrpc.
                newBlockingStub(managedChannel);
        MyResponse myResponse = blockingStub.
                getRealNameByUserName(MyRequest.newBuilder().setUserName("zhangsan").build());
        System.out.println(myResponse.getRealName());
    }
}
