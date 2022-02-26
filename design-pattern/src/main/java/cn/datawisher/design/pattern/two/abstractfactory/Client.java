package cn.datawisher.design.pattern.two.abstractfactory;

import cn.datawisher.design.pattern.two.abstractfactory.factory.JDKProxyFactory;
import cn.datawisher.design.pattern.two.abstractfactory.workshop.ICacheAdapter;
import cn.datawisher.design.pattern.two.abstractfactory.workshop.impl.EGMCacheAdapter;

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
