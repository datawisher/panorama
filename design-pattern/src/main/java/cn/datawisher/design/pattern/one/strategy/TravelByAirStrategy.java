package cn.datawisher.design.pattern.one.strategy;

/**
 * @author h407644
 * @date 2022-01-29
 */
public class TravelByAirStrategy implements TravelStrategy {

    @Override
    public void travelMode() {
        System.err.println("travel by air");
    }
}
