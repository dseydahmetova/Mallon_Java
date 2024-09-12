package TestingLab;

public class BankAccount {
    public BankAccount(int balance, String name) {
        this.balance = balance;
        this.name = name;
    }

    private int balance;
    private String name;

    public int withdraw(int amount) {
        if (amount <= 0) {
            return 0;
        }
        balance -= amount;
        return amount;
    }

    public int deposit(int amount) {
        if (amount <= 0) {
            return 0;
        }
        balance += amount;
        return amount;
    }

    public boolean transfer(BankAccount receiver, int amount) {
        if (amount <= 0) {
            return false;
        } if (balance >= amount) {
            int toTransfer = this.withdraw(amount);
            receiver.deposit(toTransfer);
            return true;
        } else {
            return false;
        }
    }

    public int getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }
}
