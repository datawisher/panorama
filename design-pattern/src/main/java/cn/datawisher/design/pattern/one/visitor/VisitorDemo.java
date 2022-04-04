package cn.datawisher.design.pattern.one.visitor;

/**
 * @author h407644
 * @date 2022-04-04
 */
public class VisitorDemo {
    public static void main(String[] args) {
        Element element = new ProjectElement("mobike", "share bicycle");
        element.accept(new CEOVisitor());
        element.accept(new CTOVisitor());
    }
}
