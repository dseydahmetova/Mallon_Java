package InheritanceAbstract;

import java.text.DecimalFormat;
import java.awt.*;

public class BankAccount implements Drawable{
    double balance;
    int accountNumber;

    public BankAccount(double balance, int accountNumber) {
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    // Override the toString() method
    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");

        return "Account balance: " + df.format(getBalance());
    }

    public void draw(Graphics g) {
        g.drawRect(150, 150, 200, 90); // Draw a rectangle
        g.drawString("Account Number: " + accountNumber, 160, 180); // Draw account number
        g.drawString("Balance: $" + balance, 160, 200); // Draw balance
    }

}
