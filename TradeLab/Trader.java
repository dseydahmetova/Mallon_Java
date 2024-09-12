package TradeLab;

import java.text.DecimalFormat;

public class Trader {
    private String traderName;
    private Account account;

    public Trader(String traderName) {
        this.traderName = traderName;
        this.account = new Account(0);
    }

    void addTrade(Trade trade) {
        DecimalFormat df = new DecimalFormat("0.00");

        double newValue = trade.getPrice() * trade.getQuantity();
        this.account.setValue(account.getValue() + newValue);
        System.out.println(traderName + "'s account value after adding " + trade.getSymbol() + " is " + df.format(account.getValue()));
    }
}
