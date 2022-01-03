package cn.datawisher.design.pattern.singleton;

/**
 * @author h407644
 * @date 2022-01-03
 */
public class SingletonDemo {

    public static void main(String[] args) {
        HungrySingleton hungrySingleton = HungrySingleton.getInstance();
        System.err.println(hungrySingleton);

        LazySingleton lazySingleton = LazySingleton.getInstance();
        System.err.println(lazySingleton);

        Singleton singleton = Singleton.getInstance();
        System.err.println(singleton);

        Lock2Singleton lock2Singleton = Lock2Singleton.getInstance();
        System.err.println(lock2Singleton);

    }
}
