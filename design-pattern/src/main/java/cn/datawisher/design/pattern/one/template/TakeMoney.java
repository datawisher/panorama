package cn.datawisher.design.pattern.one.template;

/**
 * @author h407644
 * @date 2022-01-29
 */
public class TakeMoney extends AbstractTemplate {

    @Override
    public void handleBusiness() {
        System.err.println("take money from bank");
    }
}
