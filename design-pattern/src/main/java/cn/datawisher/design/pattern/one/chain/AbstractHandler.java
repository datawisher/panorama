package cn.datawisher.design.pattern.one.chain;

/**
 * @author h407644
 * @date 2022-02-27
 */
public abstract class AbstractHandler {

    private Handler handler;

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }
}
