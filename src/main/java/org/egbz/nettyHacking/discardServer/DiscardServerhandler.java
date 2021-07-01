package org.egbz.nettyHacking.discardServer;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

/**
 * Handles a server-side channel
 * @author egbz
 * @date 2021/6/30
 */
public class DiscardServerhandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        // Discard the received data silently
//        ((ByteBuf) msg).release();

        ByteBuf in = (ByteBuf) msg;
        try {
            while (in.isReadable()) {
                // 打印收到的消息
                System.out.print((char) in.readByte());
                System.out.flush();
            }
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        // Close the connection when an exception is raised
        cause.printStackTrace();
        ctx.close();
    }


}
