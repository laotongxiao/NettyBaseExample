package com.test01;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.omg.PortableInterceptor.ServerRequestInfo;

import java.nio.charset.Charset;

public class MyClientHandler extends SimpleChannelInboundHandler<PersonProtocol> {
    private int count;
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, PersonProtocol msg) throws Exception {
        int length = msg.getLength();
        byte[] content = msg.getContent();
        String contentString = new String(content, Charset.forName("utf-8"));
        System.out.println("长度:" + length);
        System.out.println("内容:" + contentString);
        System.out.println("客户端接收到服务器响应消息的数量:" + (++ this.count));
        System.out.println("---------------");
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        for(int i=0; i<10; i++){
            String msgString = "laotongxiao to nihao!";
            PersonProtocol msgPersonProtocol = new PersonProtocol();
            msgPersonProtocol.setLength(msgString.getBytes(Charset.forName("utf-8")).length);
            msgPersonProtocol.setContent(msgString.getBytes(Charset.forName("utf-8")));
            ctx.channel().writeAndFlush(msgPersonProtocol);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
