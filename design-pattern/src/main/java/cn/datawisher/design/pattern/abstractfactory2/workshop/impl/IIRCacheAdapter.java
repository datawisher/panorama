package cn.datawisher.design.pattern.abstractfactory2.workshop.impl;

import cn.datawisher.design.pattern.abstractfactory2.rediscluster.IIR;
import cn.datawisher.design.pattern.abstractfactory2.workshop.ICacheAdapter;

import java.util.concurrent.TimeUnit;

/**
 * @author h407644
 * @date 2022-02-09
 */
public class IIRCacheAdapter implements ICacheAdapter {

    private final IIR iir = new IIR();

    @Override
    public String get(String key) {
        return iir.gain(key);
    }

    @Override
    public void set(String key, String value) {
        iir.set(key, value);
    }

    @Override
    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
        iir.setEx(key, value, timeout, timeUnit);
    }

    @Override
    public void del(String key) {
        iir.delete(key);
    }
}
