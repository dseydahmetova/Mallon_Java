package TradeLab;

import java.text.DecimalFormat;

public class TradeTest {
    public static void main(String[] args) {
       Trade product1 = new Trade(1245, "AAPL", 4, 10.56);
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println(product1);

        double newPrice = -11.27;
        product1.setPrice(newPrice);
        System.out.println("Altered Price " + df.format(product1.getPrice()));
    }
}
