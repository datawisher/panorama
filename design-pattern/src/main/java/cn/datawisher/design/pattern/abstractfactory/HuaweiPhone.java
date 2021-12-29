package cn.datawisher.design.pattern.abstractfactory;

/**
 * @author h407644
 * @date 2021-12-29
 */
public class HuaweiPhone implements Phone{

    @Override
    public String call() {

        return "call somebody by huawei phone.";
    }
}
