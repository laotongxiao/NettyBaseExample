package com.test02;


import com.test01.StudentRequest;
import com.test01.StudentResponse;
import com.test01.StudentServiceGrpc;
import io.grpc.stub.StreamObserver;


public class StudentServiceImpl extends StudentServiceGrpc.StudentServiceImplBase {

    @Override
    public void getStudentsByAge(StudentRequest request, StreamObserver<StudentResponse> responseObserver) {
        System.out.println("接收到客户端的信息:" + request.getAge());
        responseObserver.onNext(StudentResponse.newBuilder().setName("张三").setArg(20).setCity("北京").build());
        responseObserver.onNext(StudentResponse.newBuilder().setName("李四").setArg(30).setCity("上海").build());
        responseObserver.onNext(StudentResponse.newBuilder().setName("王五").setArg(40).setCity("广州").build());
        responseObserver.onNext(StudentResponse.newBuilder().setName("赵六").setArg(50).setCity("深圳").build());
        responseObserver.onCompleted();
    }
}
