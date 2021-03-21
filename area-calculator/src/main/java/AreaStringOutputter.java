public class AreaStringOutputter {
    private final AreaAggregator aggregator;
    public AreaStringOutputter(AreaAggregator aggregator) {
        this.aggregator = aggregator;
    }
    public String output() {
        return "Sum of areas: " + aggregator.sum();
    }
}
