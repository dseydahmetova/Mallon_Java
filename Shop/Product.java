package Shop;

import java.io.Serializable;

public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // override the existing tostring method to show the name and price of the product
    @Override
    public String toString() {
        return name + ", " + price;
    }

    // txt file saves the data in String lines, we will need to separate them into array and print each element of the arr
    public static Product fromString(String str) {
        String[] parts = str.split(",");
        if (parts.length != 2) {
            System.out.println("Invalid product data: " + str);
        }
        String name = parts[0];
        double price = Double.parseDouble(parts[1]);
        return new Product(name, price);
    }
}
