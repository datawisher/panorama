package cn.datawisher.design.pattern.one.chain;

/**
 * @author h407644
 * @date 2022-02-27
 */
public class ChainDemo {
    public static void main(String[] args) {
        AuthHandler authHandler = new AuthHandler("auth");
        BusinessHandler businessHandler = new BusinessHandler("business");
        ResponseHandler responseHandler = new ResponseHandler("response");

        authHandler.setHandler(businessHandler);
        businessHandler.setHandler(responseHandler);

        authHandler.operator();
    }
}
