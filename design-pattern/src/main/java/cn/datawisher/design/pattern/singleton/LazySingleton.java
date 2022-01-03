package cn.datawisher.design.pattern.singleton;

/**
 * 懒汉单例
 *
 * @author h407644
 * @date 2022-01-03
 */
public class LazySingleton {

    private static LazySingleton instance;

    private LazySingleton() {
    }

    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
