package cn.datawisher.design.pattern.facade;

/**
 * @author h407644
 * @date 2022-01-27
 */
public class Starter {

    private Dashborad dashborad;
    private Engine engine;
    private SelfCheck selfCheck;

    public Starter() {
        this.dashborad = new Dashborad();
        this.engine = new Engine();
        this.selfCheck = new SelfCheck();
    }

    public void startup() {
        System.err.println("car begin startup");
        engine.startup();
        dashborad.startup();
        selfCheck.startupCheck();
        System.err.println("car startup finished");
    }

    public void shutdown() {
        System.err.println("car begin shutdown");
        selfCheck.shudownCheck();
        engine.shutdown();
        dashborad.shutdown();
        System.err.println("car shutdown finished");
    }
}
