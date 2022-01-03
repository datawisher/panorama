package cn.datawisher.design.pattern.singleton;

/**
 * 静态内部类
 *
 * @author h407644
 * @date 2022-01-03
 */
public class Singleton {

    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    private Singleton() {}

    public static final Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
