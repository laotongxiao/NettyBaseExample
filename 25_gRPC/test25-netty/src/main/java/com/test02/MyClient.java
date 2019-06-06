package com.test02;


import com.test01.StudentRequest;
import com.test01.StudentResponse;
import com.test01.StudentServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Iterator;

public class MyClient {
    public static void main(String[] args){
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 8899).
                usePlaintext().build();
        StudentServiceGrpc.StudentServiceBlockingStub blockingStub = StudentServiceGrpc.
                newBlockingStub(managedChannel);
        Iterator<StudentResponse> iter = blockingStub.
                getStudentsByAge(StudentRequest.newBuilder().setAge(20).build());
        while (iter.hasNext()){
            StudentResponse studentResponse = iter.next();
            System.out.println(studentResponse.getName() + " " + studentResponse.getArg() + " " + studentResponse.getCity());
        }
    }
}
