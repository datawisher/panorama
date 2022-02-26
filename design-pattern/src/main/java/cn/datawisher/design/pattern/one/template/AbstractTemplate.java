package cn.datawisher.design.pattern.one.template;

/**
 * @author h407644
 * @date 2022-01-29
 */
public abstract class AbstractTemplate {

    public void templateMethod() {
        checkNumber();
        queueUp();
        handleBusiness();
        serviceEvaluation();
    }
    public void checkNumber() {
        System.err.println("checkNumber......");
    }
    public void queueUp() {
        System.err.println("queue up......");
    }
    public abstract void handleBusiness();
    public void serviceEvaluation() {
        System.err.println("business finished, service evaluation......");
    }
}
