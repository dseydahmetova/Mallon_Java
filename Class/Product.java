package Class;

public class Product {
   String name;
   double price;
   int quantity;

    public Product (String productName, double productPrice, int productQuantity) {
        name = productName;
        price = productPrice;
        quantity = productQuantity;
    }

    // Getter
    public double getPrice() {
        return price;
    }

    // Setter
    public void setPrice(double newPrice) {
        this.price = newPrice;
    }

    void print() {
        System.out.println("name: " + name + ", price: " + price + ", quantuty: " + quantity);
    }

    void calculateValue() {
        double value = quantity * price;
        System.out.println("name: " + name + " value: " + value);
        System.out.println("------------------------------------------");

    }
}

