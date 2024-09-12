package hellojava;

public class Shop {
    public static void main(String[] args) {

        InventoryItems product1 = new InventoryItems("Chair", 52.00);

        //creating a record
        Sale sale1 = new Sale(product1, 2);
        double profit = sale1.totalCost();
        double saleWithDiscount = profit - sale1.totalCostWithDiscount();

        // checking for plural items
        if (sale1.quantity() <= 0) {
            System.out.println("Error!");
        } else if (sale1.quantity() == 1) {
            System.out.println(sale1.quantity() + " " + sale1.item().itemName() + " was sold for: " + profit);
        } else {
            System.out.println(sale1.quantity() + " " + sale1.item().itemName() + " were sold for: " + saleWithDiscount);
        }

    }
}


//InventoryItems are stocked and sold.
record InventoryItems(String itemName, double price) {
}

//A Sale record is created whenever an item is sold, containing the item and its price
record Sale(InventoryItems item, int quantity) {
    public double totalCost() {
        return item.price() * quantity;
    }

    public double totalCostWithDiscount() {
        double discount = 0;
        double profit = item.price() * quantity;

        // if the quantity is over 10, a 20% discount is applied.
        if (quantity > 10) {
            discount = profit * 0.2;

            // if the quantity is over 5, a 10% discount is applied.
        } else if (quantity > 5) {
            discount = profit * 0.1;
        }
        return discount;
    }
}

