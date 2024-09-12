package Recipe.org.example;

public class Ingredient {
    private Unit unit;
    private String name;
    private double price;
    private double quantity;
    private String supplierName;

    public Ingredient(String name, double price, double quantity, Unit unit, String supplierName) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.unit = unit;
        this.supplierName = supplierName;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getQuantity() {
        return quantity;
    }

    public Unit getUnit() {
        return unit;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setPrice(double price) throws NegativeNumException {
        if (price < 0) {
            throw new NegativeNumException ("Negative number entered");
        }
        this.price = price;
    }

//    @Override
//    public String toString() {
//        return "name = " + name;
//    }
}

