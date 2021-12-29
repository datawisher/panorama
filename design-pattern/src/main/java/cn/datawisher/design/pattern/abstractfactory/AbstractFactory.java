package cn.datawisher.design.pattern.abstractfactory;

/**
 * @author h407644
 * @date 2021-12-29
 */
public abstract class AbstractFactory {

    public abstract Phone createPhone(String brand);

    public abstract Computer createComputer(String brand);
}
