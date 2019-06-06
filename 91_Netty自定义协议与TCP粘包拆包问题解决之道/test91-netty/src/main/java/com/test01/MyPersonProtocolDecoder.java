package com.test01;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

public class MyPersonProtocolDecoder extends ReplayingDecoder<PersonProtocol> {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        System.out.println("MyPersonProtoclDecoder Decoder invoked!");
        int length = in.readInt();
        byte[] content = new byte[length];
        in.readBytes(content);
        PersonProtocol personProtocol = new PersonProtocol();
        personProtocol.setLength(length);
        personProtocol.setContent(content);
        out.add(personProtocol);
    }
}
