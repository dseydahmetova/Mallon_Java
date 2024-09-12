package Class;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        ArrayList<Product2> products2 = new ArrayList<>();
        ArrayList<Product> products = new ArrayList<>();

//        //create objects
//        Product2 item1 = new Product2("vase", 20.99, 3);
//        Product2 item2 = new Product2("plate", 12.00, 23);
//        Product2 item3 = new Product2("cup", 8.39, 11);
//
//        //add to arraylist
//        products2.add(item1);
//        products2.add(item2);
//        products2.add(item3);
//
//        //print products
//        printProduct(products2);
//        //calculate value
//        calcValue(products2);


        Product product1 = new Product("vase", 20.99, 3);
        Product product2 = new Product("plate", 12.00, 23);
        Product product3 = new Product("cup", 8.39, 11);
        products.add(product1);
        products.add(product2);
        products.add(product3);

        for (Product p : products) {
            // Method for Class to print the object
            p.print();
            // Method for Class to calculate the value
            p.calculateValue();
        }

        Product product4 = new Product("kettle", 18.99, 11);
        DecimalFormat df = new DecimalFormat("0.00");

        // The method should alter the price of an item such that its value matches the desired value passed to the method.
        double desiredValue = 254.12;
        double newPrice = desiredValue / product4.quantity;
        product4.setPrice(newPrice);
        System.out.println("Altered price: " + df.format(product4.getPrice()));
    }


    // Method for Record to print the object
    public static void printProduct(ArrayList<Product2> products) {
        for (int i = 0; i < products.size(); i++) {
            System.out.println("Name: " + products.get(i).name() + " Quantity: " + products.get(i).quantity() + " Price: " + products.get(i).price());
        }
    }

    // Method for Record to calculate the value
    public static void calcValue(ArrayList<Product2> products) {
        for (int i = 0; i < products.size(); i++) {
            double value = products.get(i).quantity() * products.get(i).price();
            System.out.println("Name: " + products.get(i).name() + " Value: " + value);
            System.out.println("--------------------------------");
        }
    }
}
