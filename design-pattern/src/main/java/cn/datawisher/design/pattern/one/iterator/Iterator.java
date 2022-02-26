package cn.datawisher.design.pattern.one.iterator;

/**
 * @author h407644
 * @date 2022-02-26
 */
public interface Iterator {
    // 指针前移
    public Object previous();
    // 指针后移
    public Object next();
    public boolean hasNext();
}
