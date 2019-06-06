package com.test02;

import com.test01.MyRequest;
import com.test01.MyResponse;
import com.test01.StudentServiceGrpc;
import io.grpc.stub.StreamObserver;

public class StudentServiceImpl extends StudentServiceGrpc.StudentServiceImplBase {
    @Override
    public void getRealNameByUserName(MyRequest request, StreamObserver<MyResponse> responseObserver) {
        System.out.println("接收到客户端的信息:" + request.getUserName());
        responseObserver.onNext(MyResponse.newBuilder().setRealName("张三").build());
        responseObserver.onCompleted();
    }
}
