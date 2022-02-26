package cn.datawisher.design.pattern.one.iterator;


/**
 * @author h407644
 * @date 2022-02-26
 */
public interface Collection {

    // 对集合元素对迭代
    public Iterator iterator();

    // 取得集合元素
    public Object get(int i);

    // 向集合添加元素
    public boolean add(Object object);

    // 取得集合大小
    public int size();
}
