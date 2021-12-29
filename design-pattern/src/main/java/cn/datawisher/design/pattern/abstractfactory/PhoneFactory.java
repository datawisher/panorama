package cn.datawisher.design.pattern.abstractfactory;

/**
 * @author h407644
 * @date 2021-12-29
 */
public class PhoneFactory extends AbstractFactory {

    @Override
    public Phone createPhone(String brand) {
        if ("Huawei".equals(brand)) {
            return new HuaweiPhone();
        } else if ("Xiaomi".equals(brand)) {
            return new XiaomiPhone();
        } else {
            return null;
        }
    }

    @Override
    public Computer createComputer(String brand) {
        return null;
    }
}
