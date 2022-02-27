package cn.datawisher.design.pattern.one.chain;

/**
 * @author h407644
 * @date 2022-02-27
 */
public class AuthHandler extends AbstractHandler implements Handler {

    private String name;

    public AuthHandler(String name) {
        this.name = name;
    }

    @Override
    public void operator() {
        System.err.println("user auth...");
        if (getHandler() != null) {
            // 执行责任链的下一个流程
            getHandler().operator();
        }
    }
}
