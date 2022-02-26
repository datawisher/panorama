package cn.datawisher.design.pattern.one.singleton;

/**
 * 饿汉单例
 *
 * @author h407644
 * @date 2022-01-03
 */
public class HungrySingleton {

    private static HungrySingleton instance = new HungrySingleton();

    private HungrySingleton() {
    }

    public static HungrySingleton getInstance() {
        return instance;
    }
}
