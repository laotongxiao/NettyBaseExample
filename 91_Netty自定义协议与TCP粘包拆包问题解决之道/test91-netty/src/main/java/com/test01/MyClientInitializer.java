package com.test01;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

public class MyClientInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline channelPipeline = ch.pipeline();
        channelPipeline.addLast(new MyPersonProtocolDecoder());
        channelPipeline.addLast(new MyPersonProtocolEncoder());
        channelPipeline.addLast(new MyClientHandler());
    }
}
