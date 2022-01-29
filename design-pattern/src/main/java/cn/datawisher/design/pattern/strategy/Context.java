package cn.datawisher.design.pattern.strategy;

/**
 * @author h407644
 * @date 2022-01-29
 */
public class Context {

    private TravelStrategy travelStrategy;

    public TravelStrategy getTravelStrategy() {
        return travelStrategy;
    }

    public void setTravelStrategy(TravelStrategy travelStrategy) {
        this.travelStrategy = travelStrategy;
    }

    public void travelMode() {
        this.travelStrategy.travelMode();
    }
}
