package com.datawisher.spring.boot.drools;

import java.math.BigDecimal;
import org.kie.api.KieBase;
import org.kie.api.definition.type.FactType;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.io.ResourceFactory;

/**
 * @author h407644
 * @date 2021-06-18
 */
public class MainApplication {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        // 创建Builder对象
        KnowledgeBuilder builder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        // 添加drl资源文件
        builder.add(ResourceFactory.newClassPathResource("/rule/LoanRequestRules.drl", MainApplication.class),
                ResourceType.DRL);
        // 若builder结果有错误，则打印并退出
        if (builder.hasErrors()) {
            System.out.println(builder.getErrors().toString());
            System.exit(0);
        }

        // 创建Base对象
        KieBase kieBase = builder.newKieBase();

        // 创建Session对象
        KieSession kieSession = kieBase.newKieSession();

        // 添加事实对象实例（从java代码中找对象）
        LoanApplicant loanApplicant = new LoanApplicant();
        loanApplicant.setIncome(1000);
        loanApplicant.setLoanAmount(400);
        loanApplicant.setName("车贷");
        kieSession.insert(loanApplicant);

        // 添加事实对象实例（从资源文件中找对象）
        FactType factType = kieBase
                .getFactType("com.datawisher.spring.boot.drools", "Programmer");
        Object programmer = factType.newInstance();
        factType.set(programmer, "name", "Jim Han");
        factType.set(programmer,"age", 39);
        factType.set(programmer, "weight", new BigDecimal(75));
        factType.set(programmer, "company", "Honeywell");
        kieSession.insert(programmer);

        // 匹配规则
        kieSession.fireAllRules();
        // 关闭session资源
        kieSession.dispose();
    }

}
