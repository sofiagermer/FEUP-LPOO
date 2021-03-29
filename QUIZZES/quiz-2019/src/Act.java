public abstract class Act {
    private final String band;
    private final String land;
    public Act(String band, String land) {
        this.band = band;
        this.land = land;
    }
    public String getName(){
        return this.band;
    }

    public String getCountry() {
        return this.land;
    }
}
