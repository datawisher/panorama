package cn.datawisher.design.pattern.abstractfactory2.workshop.impl;

import cn.datawisher.design.pattern.abstractfactory2.rediscluster.EGM;
import cn.datawisher.design.pattern.abstractfactory2.workshop.ICacheAdapter;

import java.util.concurrent.TimeUnit;

/**
 * @author h407644
 * @date 2022-02-09
 */
public class EGMCacheAdapter implements ICacheAdapter {

    private final EGM egm = new EGM();

    @Override
    public String get(String key) {
        return egm.gain(key);
    }

    @Override
    public void set(String key, String value) {
        egm.set(key, value);
    }

    @Override
    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
        egm.setEx(key, value, timeout, timeUnit);
    }

    @Override
    public void del(String key) {
        egm.delete(key);
    }
}
