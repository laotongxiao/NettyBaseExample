package com.test02;



import com.test01.StudentRequest;
import com.test01.StudentResponse;
import com.test01.StudentResponseList;
import com.test01.StudentServiceGrpc;
import io.grpc.stub.StreamObserver;


public class StudentServiceImpl extends StudentServiceGrpc.StudentServiceImplBase {
    @Override
    public StreamObserver<StudentRequest> getStudentsByAges(StreamObserver<StudentResponseList> responseObserver) {
        return new StreamObserver<StudentRequest>() {
            @Override
            public void onNext(StudentRequest value) {

                System.out.println("onNext" + value.getAge());
            }

            @Override
            public void onError(Throwable t) {

                System.out.println(t.getMessage());
            }

            @Override
            public void onCompleted() {
                StudentResponse studentResponse = StudentResponse.newBuilder().setName("张三").setArg(20).setCity("北京").build();
                StudentResponse studentResponse2 = StudentResponse.newBuilder().setName("李四").setArg(30).setCity("广州").build();
                StudentResponseList studentResponseList = StudentResponseList.newBuilder().addStudentResponse(studentResponse).addStudentResponse(studentResponse2).build();
                responseObserver.onNext(studentResponseList);
                responseObserver.onCompleted();

            }
        };
    }
}
