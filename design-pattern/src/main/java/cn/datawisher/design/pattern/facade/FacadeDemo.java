package cn.datawisher.design.pattern.facade;

/**
 * @author h407644
 * @date 2022-01-27
 */
public class FacadeDemo {

    public static void main(String[] args) {
        Starter starter = new Starter();
        starter.startup();
        System.err.println("***************");
        starter.shutdown();
    }
}
