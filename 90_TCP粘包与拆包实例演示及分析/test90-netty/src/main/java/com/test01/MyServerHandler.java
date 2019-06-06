package com.test01;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.charset.Charset;

public class MyServerHandler extends SimpleChannelInboundHandler<ByteBuf> {
    private int count;
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
        System.out.println("服务器一共收到客户端:" + (++ count) + " 次!");
        byte[] bytes = new byte[msg.readableBytes()];
        msg.readBytes(bytes);
        String msgString = new String(bytes, Charset.forName("utf-8"));
        System.out.println("服务器收到客户端10次发来的数据:" +msgString);
        ByteBuf byteBuf = Unpooled.copiedBuffer("Hello World!", Charset.forName("utf-8"));
        ctx.channel().writeAndFlush(byteBuf);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
