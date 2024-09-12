package relationships;

public class CurrentAccount {
    private Holder holder;
    private double balance;

    public CurrentAccount(Holder holder) {
        this.holder = holder;
        this.balance = 0.0;
    }
    public void debit(double amount) {
        this.balance -= amount;
    }
    public void credit(double amount) {
        this.balance += amount;
    }
    public Holder getHolder() {
        return this.holder;
    }
    public double getBalance() {
        return this.balance;
    }
    public boolean transfer(CurrentAccount other, double amount) {
        if(this.balance >= amount) {
            this.balance -= amount;
            other.credit(amount);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Account holder " + holder.getName() + ", balance " + balance;
    }
}
