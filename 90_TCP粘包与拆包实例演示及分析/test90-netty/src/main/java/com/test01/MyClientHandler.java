package com.test01;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.charset.Charset;

/**
 * byte[] 注意一定要小写，为基本数据类型
 */
public class MyClientHandler extends SimpleChannelInboundHandler<ByteBuf> {
    private int count;
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
        System.out.println("输出：" + (++ this.count) + " 次！");
        byte[] bytes = new byte[msg.readableBytes()];
        msg.readBytes(bytes);
        String msgString = new String(bytes, Charset.forName("utf-8"));
        System.out.println("服务器返加数据:" + msgString);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        for(int i=0; i<10; i++){
            ByteBuf msg = Unpooled.copiedBuffer("lao tong xiao", Charset.forName("utf-8"));
            ctx.channel().writeAndFlush(msg);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
