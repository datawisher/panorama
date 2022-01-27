package cn.datawisher.design.pattern.proxy;

/**
 * @author h407644
 * @date 2022-01-27
 */
public class ProxyDemo {

    public static void main(String[] args) {
        Company company = new Proxy();
        company.findWorker("Java");
    }
}
