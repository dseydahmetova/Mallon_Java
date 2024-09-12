package relationships;

import java.util.Arrays;

public class Bank {
    private String name;
    private CurrentAccount[] accounts;
    public Bank(String name) {
        this.name = name;
        accounts = new CurrentAccount[0];
    }
    public CurrentAccount openAccount(Holder holder) {
        CurrentAccount[] tempAccounts = accounts.length > 0 ?
        Arrays.copyOf(accounts, accounts.length + 1) : new CurrentAccount[1];
        
        CurrentAccount account = new CurrentAccount(holder);

        tempAccounts[accounts.length] = account;
        accounts = tempAccounts;
        return account;
    }
    public CurrentAccount[] getAccounts() {
        return this.accounts;
    }
    public CurrentAccount getAccount(Holder holder) {
        for(CurrentAccount account : accounts) {
            if(account.getHolder().getName().equals(holder.getName())) {
                return account;
            }
        }
        return null;
    }
    public void closeAccount(CurrentAccount account) {
        CurrentAccount[] tempAccounts = new CurrentAccount[accounts.length - 1];
        int j = 0;
        for(int i = 0; i < accounts.length; i++) {
            if(accounts[i] != account) {
                tempAccounts[j] = accounts[i];
                j++;
            } else {            
                accounts[i].getHolder().addCash(accounts[i].getBalance());
                accounts[i].debit(accounts[i].getBalance());                
            }
        }
        accounts = tempAccounts;
    }
    public void shutBank() {
        for(CurrentAccount account : accounts){
            account.getHolder().addCash(account.getBalance());
            account.debit(account.getBalance());
        }
    }
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
