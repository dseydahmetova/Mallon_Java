package Collections;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Order implements Comparable<Order> {
    private String symbol;
    private int quantity;
    private Side side;
    private LocalDateTime dateTime;
    private Status status;
    private double price;


    public Order(String symbol, int quantity, Side side, double price) {
        this.symbol = symbol;
        this.quantity = quantity;
        this.side = side;
        this.price = price;
        this.status = Status.Placed;
        this.dateTime = LocalDateTime.now();
    }

    public double getPrice() {
        return price;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getQuantity() {
        return quantity;
    }

    public Side getSide() {
        return side;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Status getStatus() {
        return status;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setSide(Side side) {
        this.side = side;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int compareTo(Order o) {
        return this.dateTime.compareTo(o.dateTime);
    }

    @Override
    public String toString() {
        return "Order{" +
                "symbol='" + symbol + '\'' +
                ", quantity=" + quantity +
                ", side=" + side +
                ", status=" + status +
                ", dateTime=" + dateTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return quantity == order.quantity && Double.compare(price, order.price) == 0 && Objects.equals(symbol, order.symbol) && side == order.side && Objects.equals(dateTime, order.dateTime) && status == order.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol, quantity, side, dateTime, status, price);
    }

    enum Side {Buy, Sell}
    enum Status {Placed, PartiallyFilled, Filled, Cancelled}

}
