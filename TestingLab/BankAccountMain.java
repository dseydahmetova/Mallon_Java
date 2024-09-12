package TestingLab;

public class BankAccountMain {
    public static void main(String[] args) {
        depositTest();
        depositNegativeTest();
        transferTest();
        transferOutOfBalanceTest();
    }

    public static void depositTest() {
        BankAccount b = new BankAccount(100, "Alice");
        b.deposit(100);
        assert b.getBalance() == 200;
    }

    public static void depositNegativeTest() {
        BankAccount b = new BankAccount(100, "Alice");
        b.deposit(-100);
        assert b.getBalance() == 100;
    }

    public static void transferTest() {
        BankAccount a = new BankAccount(100, "Alice");
        BankAccount b = new BankAccount(50, "Tom");

        a.transfer(b, 50);
        assert b.getBalance() == 100;
    }

    public static void transferOutOfBalanceTest() {
        BankAccount a = new BankAccount(100, "Alice");
        BankAccount b = new BankAccount(50, "Tom");

        a.transfer(b, 150);
        assert b.getBalance() == 50;
    }
}
