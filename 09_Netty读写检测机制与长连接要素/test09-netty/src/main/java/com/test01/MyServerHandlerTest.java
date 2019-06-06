package com.test01;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.logging.SocketHandler;

public class MyServerHandlerTest extends SimpleChannelInboundHandler<SocketHandler> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, SocketHandler msg) throws Exception {

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
