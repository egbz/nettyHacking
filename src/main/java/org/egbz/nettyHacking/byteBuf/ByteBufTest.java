package org.egbz.nettyHacking.byteBuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @author egbz
 * @date 2021/7/11
 */
public class ByteBufTest {
    private void getTest() {
        Charset utf8 = StandardCharsets.UTF_8;
        ByteBuf buf = Unpooled.copiedBuffer("Netty in Action rocks!", utf8);
        System.out.println((char)buf.getByte(0));

        int readerIndex = buf.readerIndex();
        int writerIndex = buf.writerIndex();
        buf.setByte(0, (byte)'B');

        System.out.println((char) buf.getByte(0));
        System.out.println("readerIndex: " + buf.readerIndex());
        System.out.println("writerIndex: " + buf.writerIndex());
    }

    private void readTest() {
        Charset utf8 = StandardCharsets.UTF_8;
        ByteBuf buf = Unpooled.copiedBuffer("Netty in Action rocks!", utf8);
        System.out.println((char)buf.readByte());

        buf.writeByte((byte)'?');
        System.out.println("readerIndex: " + buf.readerIndex());
        System.out.println("writerIndex: " + buf.writerIndex());
    }

    public static void main(String[] args) {
        ByteBufTest o = new ByteBufTest();

        o.getTest();
//        o.readTest();
    }
}
