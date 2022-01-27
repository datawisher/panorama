package cn.datawisher.design.pattern.proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author h407644
 * @date 2022-01-27
 */
public class Proxy implements Company {

    private HR hr;

    public Proxy() {
        super();
        this.hr = new HR();
    }

    @Override
    public void findWorker(String title) {
        hr.findWorker(title);
        String worker = getWorker(title);
        System.err.println("find a work by proxy, worker name is: " + worker);
    }

    private String getWorker(String title) {
        Map<String, String> workList = new HashMap<String, String>() {
            {put("Java","张三"); put("Python", "李四"); put("PHP", "王五");}
        };
        return workList.get(title);
    }
}
