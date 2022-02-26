package cn.datawisher.design.pattern.one.abstractfactory;

/**
 * @author h407644
 * @date 2021-12-29
 */
public class AbstractFactoryDemo {

    public static void main(String[] args) {

        AbstractFactory phoneFactory = new PhoneFactory();
        Phone huaweiPhone = phoneFactory.createPhone("Huawei");
        Phone xiaomiPhone = phoneFactory.createPhone("Xiaomi");
        System.err.println(huaweiPhone.call());
        System.err.println(xiaomiPhone.call());

        AbstractFactory computerFactory = new ComputerFactory();
        Computer huaweiComputer = computerFactory.createComputer("Huawei");
        Computer xiaomiComputer = computerFactory.createComputer("Xiaomi");
        System.err.println(huaweiComputer.internet());
        System.err.println(xiaomiComputer.internet());
    }
}
