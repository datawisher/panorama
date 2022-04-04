package cn.datawisher.design.pattern.one.visitor;

import com.alibaba.fastjson.JSON;

import java.util.Date;

/**
 * @author h407644
 * @date 2022-04-04
 */
public class CEOVisitor implements Visitor {

    @Override
    public void visit(ProjectElement element) {
        System.err.println("CEO Visitor Element");
        element.signature("CEO", new Date());
        System.err.println(JSON.toJSONString(element));
    }
}
