package org.egbz.nettyHacking.time;

import java.util.Date;

/**
 * @author egbz
 * @date 2021/7/3
 */
public class UnixTime {

    private final long value;

    public UnixTime(long value) {
        this.value = value;
    }

    public UnixTime() {
        this(System.currentTimeMillis() / 1000L + 2208988800L);
    }

    public long value() {
        return value;
    }

    @Override
    public String toString() {
        return new Date((value() - 2208988800L) * 1000L).toString();
    }
}
