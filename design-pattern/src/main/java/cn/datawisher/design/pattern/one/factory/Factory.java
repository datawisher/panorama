package cn.datawisher.design.pattern.one.factory;

/**
 * @author h407644
 * @date 2021-12-29
 */
public class Factory {

    public Phone createPhone(String phoneName) {
        if ("Huawei".equals(phoneName)) {
            return new HuaweiPhone();
        } else if ("Xiaomi".equals(phoneName)) {
            return new XiaomiPhone();
        } else {
            return null;
        }
    }
}
