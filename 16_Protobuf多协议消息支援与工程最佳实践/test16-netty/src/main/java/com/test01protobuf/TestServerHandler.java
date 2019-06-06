package com.test01protobuf;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class TestServerHandler extends SimpleChannelInboundHandler<MyDataInfo.MyMessage> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo.MyMessage msg) throws Exception {
        MyDataInfo.MyMessage.DataType dataType = msg.getDataType();
        if(dataType == MyDataInfo.MyMessage.DataType.PersonType){
            System.out.println(msg.getPerson().getName());
            System.out.println(msg.getPerson().getAge());
            System.out.println(msg.getPerson().getAddress());
        }else if(dataType == MyDataInfo.MyMessage.DataType.DogType){
            System.out.println(msg.getDog().getName());
            System.out.println(msg.getDog().getAge());
        }else{
            System.out.println(msg.getCat().getName());
            System.out.println(msg.getCat().getCity());
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //cause.printStackTrace();
        ctx.close();
    }


}
