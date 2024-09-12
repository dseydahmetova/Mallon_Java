package Collections;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Trade implements Comparable <Trade>{
    private String symbol;
    private int quantity;
    private double price;
    private LocalDateTime dateTime;


    public Trade(String symbol, int quantity, double price, LocalDateTime dateTime) {
        this.symbol = symbol;
        this.quantity = quantity;
        this.price = price;
        dateTime = LocalDateTime.now();
    }

    public String getSymbol() {
        return symbol;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trade trade = (Trade) o;
        return quantity == trade.quantity && Double.compare(price, trade.price) == 0 && Objects.equals(symbol, trade.symbol) && Objects.equals(dateTime, trade.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol, quantity, price, dateTime);
    }


    @Override
    public int compareTo(Trade o) {
        return this.dateTime.compareTo(o.dateTime);
    }

    @Override
    public String toString() {
        return "Trade{" +
                "symbol='" + symbol + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", dateTime=" + dateTime +
                '}';
    }
}
