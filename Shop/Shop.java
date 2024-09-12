package Shop;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Shop {
    private ArrayList<Product> products = new ArrayList<>();
    private String filePath = "C:/Users/DanaSeidakhmetova/Desktop/product.txt";

    public ArrayList<Product> getProductsOnShow() {
        return new ArrayList<>(products);
    }
    public void addProduct(String name, double price) {
        Product p = new Product(name, price);
        products.add(p);
        saveProducts();
    }

    public void saveProducts() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Product p : products) {
                writer.write(p.toString());
                writer.newLine();
            }
            System.out.println("ArrayList written to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadProducts() {
        File file = new File(filePath);
        if (!file.exists()) {
            return;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Product p = Product.fromString(line);
                products.add(p);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removeProducts(String removeProduct) throws IOException {
        Product productToDelete = null;
        for (Product p : products) {

            if (p.getName().equalsIgnoreCase(removeProduct)) {
                productToDelete = p;
                break;
            }
        }
        if (productToDelete != null) {
            products.remove(productToDelete);
            System.out.println("Product removed: " + removeProduct);
        } else {
            System.out.println("Product not found: " + removeProduct);
        }
        BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath));
        writer.write("");
        writer.flush();
        new FileOutputStream(filePath).close();
        saveProducts();
        }



    public void buyProduct(String name) {
        Product productToDelete = null;
        for (Product p : products) {
            if (!p.getName().equalsIgnoreCase(name)) {
                productToDelete = p;
            }
        }
        products.remove(productToDelete);
    }
}
