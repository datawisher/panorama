package cn.datawisher.design.pattern.abstractfactory2;

import cn.datawisher.design.pattern.abstractfactory2.factory.JDKProxyFactory;
import cn.datawisher.design.pattern.abstractfactory2.workshop.ICacheAdapter;
import cn.datawisher.design.pattern.abstractfactory2.workshop.impl.EGMCacheAdapter;

/**
 * @author h407644
 * @date 2022-02-09
 */
public class Client {

    public static void main(String[] args) throws Exception {
        ICacheAdapter proxy = JDKProxyFactory.getProxy(ICacheAdapter.class, EGMCacheAdapter.class);
        proxy.set("a","1");
        String a = proxy.get("a");
        System.out.println("a = " + a);
    }
}
