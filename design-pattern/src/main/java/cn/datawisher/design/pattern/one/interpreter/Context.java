package cn.datawisher.design.pattern.one.interpreter;

import java.util.HashMap;

/**
 * @author h407644
 * @date 2022-04-04
 */
public class Context {
    private HashMap map = new HashMap();
    public void assign(String key, String value) {
        // 在环境类中设值
    }

    public String get(String key) {
        // 获取存储在环境类中的值
        return "";
    }
}
