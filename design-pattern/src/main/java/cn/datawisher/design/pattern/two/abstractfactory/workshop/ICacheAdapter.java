package cn.datawisher.design.pattern.two.abstractfactory.workshop;

import java.util.concurrent.TimeUnit;

/**
 * @author h407644
 * @date 2022-02-09
 */
public interface ICacheAdapter {

    String get(String key);
    void set(String key, String value);
    void set(String key, String value, long timeout, TimeUnit timeUnit);
    void del(String key);
}
