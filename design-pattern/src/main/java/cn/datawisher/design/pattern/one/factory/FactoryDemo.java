package cn.datawisher.design.pattern.one.factory;

/**
 * @author h407644
 * @date 2021-12-29
 */
public class FactoryDemo {

    public static void main(String[] args) {
        Factory factory = new Factory();
        Phone huawei = factory.createPhone("Huawei");
        Phone xiaomi = factory.createPhone("Xiaomi");
        System.err.println(huawei.brand());
        System.err.println(xiaomi.brand());
    }
}
