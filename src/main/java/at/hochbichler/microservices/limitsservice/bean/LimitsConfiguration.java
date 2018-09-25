package at.hochbichler.microservices.limitsservice.bean;

public class LimitsConfiguration {
    private int minimum;
    private int maximum;

    protected LimitsConfiguration() {
    }

    public LimitsConfiguration(int minimum, int maximum) {
        this.minimum = minimum;
        this.maximum = maximum;
    }

    public int getMinimum() {
        return minimum;
    }

    public int getMaximum() {
        return maximum;
    }
}
