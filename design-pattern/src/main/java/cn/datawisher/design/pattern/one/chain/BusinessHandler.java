package cn.datawisher.design.pattern.one.chain;

/**
 * @author h407644
 * @date 2022-02-27
 */
public class BusinessHandler extends AbstractHandler implements Handler {

    private String name;

    public BusinessHandler(String name) {
        this.name = name;
    }

    @Override
    public void operator() {
        System.err.println("business info handler...");
        if (getHandler() != null) {
            getHandler().operator();
        }
    }
}
