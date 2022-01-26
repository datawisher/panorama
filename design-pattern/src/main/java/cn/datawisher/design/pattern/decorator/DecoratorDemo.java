package cn.datawisher.design.pattern.decorator;

/**
 * @author h407644
 * @date 2022-01-26
 */
public class DecoratorDemo {

    public static void main(String[] args) {
        Sourceable source = new Source();
        Sourceable obj = new Decorator(source);
        obj.createComputer();
    }
}
