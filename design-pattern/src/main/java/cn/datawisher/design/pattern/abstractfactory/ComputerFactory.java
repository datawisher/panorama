package cn.datawisher.design.pattern.abstractfactory;

/**
 * @author h407644
 * @date 2021-12-29
 */
public class ComputerFactory extends AbstractFactory {

    @Override
    public Phone createPhone(String brand) {
        return null;
    }

    @Override
    public Computer createComputer(String brand) {
        if ("Huawei".equals(brand)) {
            return new HuaweiComputer();
        } else if ("Xiaomi".equals(brand)) {
            return new XiaomiComputer();
        } else {
            return null;
        }
    }
}
