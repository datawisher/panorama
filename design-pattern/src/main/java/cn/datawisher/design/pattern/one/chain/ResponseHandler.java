package cn.datawisher.design.pattern.one.chain;

/**
 * @author h407644
 * @date 2022-02-27
 */
public class ResponseHandler extends AbstractHandler implements Handler {

    private String name;

    public ResponseHandler(String name) {
        this.name = name;
    }

    @Override
    public void operator() {
        System.err.println("message response...");
        if (getHandler() != null) {
            getHandler().operator();
        }
    }
}
