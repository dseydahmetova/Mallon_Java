package TradeLab;

public class TraderTest {
    public static void main(String[] args) {
        Trader trader1 = new Trader("Mark Bash");
        Trade product1 = new Trade(1245, "AAPL", 4, 10.56);
        Trade product2 = new Trade(1246, "IBM", 2, 29.72);

        trader1.addTrade(product1);
        trader1.addTrade(product2);

    }
}
