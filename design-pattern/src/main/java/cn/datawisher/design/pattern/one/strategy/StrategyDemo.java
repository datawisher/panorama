package cn.datawisher.design.pattern.one.strategy;

/**
 * @author h407644
 * @date 2022-01-29
 */
public class StrategyDemo {

    public static void main(String[] args) {
        Context context = new Context();
        TravelStrategy travelByAirStrategy = new TravelByAirStrategy();
        context.setTravelStrategy(travelByAirStrategy);
        context.travelMode();
        System.err.println("change TravelStrategy to travelByCarStrategy......");
        TravelByCarStrategy travelByCarStrategy = new TravelByCarStrategy();
        context.setTravelStrategy(travelByCarStrategy);
        context.travelMode();
    }
}
