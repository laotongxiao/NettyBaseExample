package com.test01;


import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;

public class MyServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if(evt instanceof IdleStateEvent){
            IdleStateEvent event = (IdleStateEvent) evt;
            String eventTyp = null;
            switch (event.state()){
                case READER_IDLE:
                    eventTyp = "读空闲";
                    break;
                case WRITER_IDLE:
                    eventTyp = "写空闲";
                    break;
                case ALL_IDLE:
                    eventTyp = "读写空闲";
                    break;
            }
            System.out.println(ctx.channel().remoteAddress() + "超时事件：" + eventTyp);
        }
    }
}
