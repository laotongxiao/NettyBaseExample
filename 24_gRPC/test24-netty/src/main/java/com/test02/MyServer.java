package com.test02;

import io.grpc.Server;
import io.grpc.ServerBuilder;


public class MyServer {
    private Server server;
    private void start() throws Exception{
        this.server = ServerBuilder.forPort(8899).addService(new StudentServiceImpl()).build().start();
        System.out.println("server started!");
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("关闭jvm!");
            MyServer.this.stop();
        }));
    }
    private void stop(){
        if(null != this.server){
            this.server.shutdown();
        }
    }
    private void awaitTermination() throws Exception{
        if(null != this.server){
            this.server.awaitTermination();
        }
    }
    public static void main(String[] args) throws Exception{
        MyServer myServer = new MyServer();
        myServer.start();
        myServer.awaitTermination();
    }
}
