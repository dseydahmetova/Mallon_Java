package TradeLab;

public class Trade {
    private int ID;
    private String symbol;
    private int quantity;
    private double price;

    // First constructor with all attributes
    public Trade(int ID, String symbol, int quantity, double price) {
        this.ID = ID;
        this.symbol = symbol;
        this.quantity = quantity;
        this.price = price;
    }

    // Second constructor without price
    public Trade(int ID, String symbol, int quantity) {
        this.ID = ID;
        this.symbol = symbol;
        this.quantity = quantity;
        this.price = 0;
    }

    // Getter price
    public double getPrice() {
        return price;
    }

    // Getter symbol


    public String getSymbol() {
        return symbol;
    }

    // Getter quantity
    public int getQuantity() {
        return quantity;
    }

    // Setter
    public void setPrice(double newPrice) {
        if (newPrice > 0) {
            this.price = newPrice;
        }
        System.out.println("Please enter positive number");
    }


    // Override the toString() method
    @Override
    public String toString() {
        return "symbol: " + symbol + ", price: " + price + ", quantity: " + quantity;
    }
}

