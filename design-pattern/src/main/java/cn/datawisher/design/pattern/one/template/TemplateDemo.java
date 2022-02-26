package cn.datawisher.design.pattern.one.template;

/**
 * @author h407644
 * @date 2022-01-29
 */
public class TemplateDemo {

    public static void main(String[] args) {
        AbstractTemplate template1 = new TakeMoney();
        template1.templateMethod();

        AbstractTemplate template2 = new SaveMoney();
        template2.templateMethod();
    }
}
