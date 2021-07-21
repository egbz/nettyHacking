package org.egbz.nettyHacking.codec.codec;

import io.netty.channel.CombinedChannelDuplexHandler;

/**
 * @author egbz
 * @date 2021/7/21
 */
public class CombinedByteCharCodec extends
        CombinedChannelDuplexHandler<ByteToCharDecoder, CharToByteEncoder> {

    public CombinedByteCharCodec() {
        super(new ByteToCharDecoder(), new CharToByteEncoder());
    }
}