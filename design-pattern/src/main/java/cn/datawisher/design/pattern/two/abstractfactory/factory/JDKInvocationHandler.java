package cn.datawisher.design.pattern.two.abstractfactory.factory;

import cn.datawisher.design.pattern.two.abstractfactory.workshop.ICacheAdapter;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author h407644
 * @date 2022-02-09
 */
public class JDKInvocationHandler implements InvocationHandler {

    private ICacheAdapter cacheAdapter;

    public JDKInvocationHandler(ICacheAdapter cacheAdapter) {
        this.cacheAdapter = cacheAdapter;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return ICacheAdapter.class.getMethod(method.getName(),
                method.getParameterTypes()).invoke(cacheAdapter, args);
    }
}
