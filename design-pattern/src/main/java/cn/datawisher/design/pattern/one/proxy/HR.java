package cn.datawisher.design.pattern.one.proxy;

/**
 * @author h407644
 * @date 2022-01-27
 */
public class HR implements Company {

    @Override
    public void findWorker(String title) {
        System.err.println("i need find a worker, title is:" + title);
    }
}
