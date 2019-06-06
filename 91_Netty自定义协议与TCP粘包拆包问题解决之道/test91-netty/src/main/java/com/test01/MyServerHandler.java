package com.test01;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.charset.Charset;

public class MyServerHandler extends SimpleChannelInboundHandler<PersonProtocol> {
    private int count;
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, PersonProtocol msg) throws Exception {
        int length = msg.getLength();
        byte[] content = msg.getContent();
        String contentString = new String(content, Charset.forName("utf-8"));
        System.out.println("长度:" + length);
        System.out.println("内容:" + contentString);
        System.out.println("服务器接收到客户端请求消息数量:" + (++ this.count));
        System.out.println("-----------");
        String responseString = "Hello World!";
        PersonProtocol personProtocol = new PersonProtocol();
        personProtocol.setLength(responseString.getBytes(Charset.forName("utf-8")).length);
        personProtocol.setContent(responseString.getBytes(Charset.forName("utf-8")));
        ctx.channel().writeAndFlush(personProtocol);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
