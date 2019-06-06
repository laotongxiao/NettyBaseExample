package com.test02;


import com.test01.StreamRequest;
import com.test01.StreamResponse;
import com.test01.StudentServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.time.LocalDateTime;


public class MyClient {
    public static void main(String[] args){
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 8899).
                usePlaintext().build();

        StudentServiceGrpc.StudentServiceStub stub = StudentServiceGrpc.newStub(managedChannel);
        StreamObserver<StreamRequest> requestStreamObserver = stub.bitalk(new StreamObserver<StreamResponse>(){
            @Override
            public void onNext(StreamResponse value) {
                System.out.println(value.getResponseInfo());
            }

            @Override
            public void onError(Throwable t) {
                t.getMessage();
            }

            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }
        });

        for(int i =0 ; i<10 ; i++){
            requestStreamObserver.onNext(StreamRequest.newBuilder().setRequestInfo(LocalDateTime.now().toString()).build());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            Thread.sleep(50000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
