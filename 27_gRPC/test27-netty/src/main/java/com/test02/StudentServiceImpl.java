package com.test02;



import com.test01.StreamRequest;
import com.test01.StreamResponse;
import com.test01.StudentServiceGrpc;
import io.grpc.stub.StreamObserver;

import java.util.UUID;


public class StudentServiceImpl extends StudentServiceGrpc.StudentServiceImplBase {

    @Override
    public StreamObserver<StreamRequest> bitalk(StreamObserver<StreamResponse> responseObserver) {
        return new StreamObserver<StreamRequest>() {
            @Override
            public void onNext(StreamRequest value) {
                System.out.println(value.getRequestInfo());
                responseObserver.onNext(StreamResponse.newBuilder().setResponseInfo(UUID.randomUUID().toString()).build());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println(t.getMessage());
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }
}
