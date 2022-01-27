package cn.datawisher.design.pattern.facade;

/**
 * @author h407644
 * @date 2022-01-27
 */
public class SelfCheck {

    public void startupCheck() {
        System.err.println("startup check finished");
    }

    public void shudownCheck() {
        System.err.println("shutdown check finished");
    }
}
