package HotelBookingSystem;

public class Services {
    private String type;
    private double price;
    //constructors
    public Services (String type, double price){
        this.type = type;
        this.price = price;
    }
    //setters
    public void setType(String type) {
        this.type = type;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    //getters
    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }
}
