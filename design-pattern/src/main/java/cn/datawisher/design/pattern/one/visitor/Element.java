package cn.datawisher.design.pattern.one.visitor;

/**
 * @author h407644
 * @date 2022-04-04
 */
public interface Element {

    void accept(Visitor visitor);
}
