package relationships;

public class Holder {
    private double cash;
    private String name;
    private String address;
    public Holder(String name, String address) {
        this.name = name;
        this.address = address;
        this.cash = 0;
    }
    public String getName() {
        return this.name;
    }
    public String getAddress() {
        return this.address;
    }
    public void addCash(double cash) {
        this.cash += cash;
    }
    @Override
    public String toString() {
        return this.name + ", holds cash " + this.cash;
    }
}
