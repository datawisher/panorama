package cn.datawisher.design.pattern.one.mediator;

/**
 * @author h407644
 * @date 2022-04-04
 */
public class MediatorDemo {

    public static void main(String[] args) {
        Colleague colleagueTenant = new ColleagueTenant();
        Colleague colleagueLandlord = new ColleagueLandlord();
        ConcreteMediator concreteMediator = new ConcreteMediator(colleagueTenant, colleagueLandlord);
        boolean result = concreteMediator.notifyColleagueTenant("想租2室1厅的吗？");
        if (result) {
            concreteMediator.notifyColleagueLandlord("租客对面积满意");
        } else {
            concreteMediator.notifyColleagueTenant("租客对面积不满意");
        }

    }
}
