package Collections;

import java.util.*;

public class App {

    public static void main(String[] args) {
        Map<String, SortedSet<Order>> orderList = new HashMap<>();


        System.out.println("\n----------------MENU-------------------------");
        Scanner scanner = new Scanner(System.in);


        do {
            printMenu();
            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    switchUser();
                    break;
                case "2":
                    createOrder(orderList);
                    break;
                default:
                    break;
            }
        } while (true);
    }

    private static void switchUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name:");
        String userName = scanner.nextLine();
    }


    private static void printMenu() {
        System.out.println(
                "1. Switch the user\n" +
                        "2. Enter order details\n");
    }

    private static void createOrder(Map<String, SortedSet<Order>> orderList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the symbol");
        String symbol = scanner.nextLine();
        System.out.println("Enter the quantity");
        int quantity = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the price");
        double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Side: Buy or Sell");
        String side = scanner.nextLine();

        Order order = new Order(symbol, quantity, Order.Side.valueOf(side) , price);
        System.out.println(order);
        SortedSet<Order> orders = orderList.get("1Z");
        if(orders == null){
            orders = new TreeSet<Order>();
            orderList.put("1Z", orders);
        }
        orders.add(order);
        System.out.println("set" + orderList);

    }
}
