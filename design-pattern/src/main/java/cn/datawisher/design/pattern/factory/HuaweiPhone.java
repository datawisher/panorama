package cn.datawisher.design.pattern.factory;

/**
 * @author h407644
 * @date 2021-12-29
 */
public class HuaweiPhone implements Phone{
    @Override
    public String brand() {
        return "this is a huawei phone.";
    }
}