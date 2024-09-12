package Shop;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Gui {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Shop shop = new Shop();

        while (true) {
            System.out.println(
                    "----------------------\n" +
                            "1. Add product\n" +
                            "2. Show product\n" +
                            "3. Remove product\n"
            );
            String input = scanner.nextLine();

            // add the new product to the existing txt file
            if (input.equals("1")) {
                System.out.println("Product name");
                String name = scanner.nextLine();
                System.out.println("Product price");
                double price = Double.parseDouble(scanner.nextLine());
                shop.addProduct(name, price);
                displayProducts(shop.getProductsOnShow());

                // Pull the product list from txt file, if the user types 2
            } else if (input.equals("2")) {
                System.out.println("Current inventory items:");
                shop.loadProducts();
                System.out.println("----------------------");
                displayProducts(shop.getProductsOnShow());
            }

            // remove the product from txt file, if the user types 3
            else if (input.equals("3")) {
                System.out.println("Product name you want to remove:");
                String productName = scanner.nextLine();
                shop.removeProducts(productName);
                System.out.println("----------------------");
            }

        }
    }

    // show the product list
    static void displayProducts(ArrayList<Product> products) {
        for (Product p : products) {
            System.out.println(p.getName() + " " + p.getPrice());
        }
    }
}
