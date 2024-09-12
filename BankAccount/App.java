package relationships;

import java.util.Arrays;
import java.util.Scanner;

public class App {
    static Holder[] holders = new Holder[0];
    static Bank[] banks = new Bank[0];
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Do what?\n" +
                    "1. Add holder\n" +
                    "2. Add bank\n" +
                    "3. Add account\n" +
                    "4. List holders\n" +
                    "5. List banks\n" +
                    "6. List accounts\n" +
                    "7. Credit\n" +
                    "8. Debit\n" + 
                    "9. Transfer\n" +
                    "10. Close account\n" + 
                    "11. Shut bank");
            System.out.println("");

            String input = scanner.nextLine();
            System.out.println("----------------------------------------\n\n\n");
            if (input.equals("1")) { // Add Holder
                System.out.println("Name");
                String name = scanner.nextLine();
                System.out.println("Address");
                String address = scanner.nextLine();

                Holder holder = new Holder(name, address);
                addHolder(holder);
            } else if (input.equals("2")) { // Add Bank
                System.out.println("Name");
                String name = scanner.nextLine();
                Bank bank = new Bank(name);
                addBank(bank);
            } else if (input.equals("3")) { // Add Account
                System.out.println("What holder");
                String holderName = scanner.nextLine();
                Holder holder = getHolder(holderName);

                System.out.println("What bank");
                String bankName = scanner.nextLine();
                Bank bank = getBank(bankName);

                if (bank != null && holder != null) {
                    bank.openAccount(holder);
                }

            } else if (input.equals("4")) { // List Holders
                for (Holder holder : holders) {
                    System.out.println(holder);
                }
            } else if (input.equals("5")) { // List Banks
                for (Bank bank : banks) {
                    System.out.println(bank);
                }
            } else if (input.equals("6")) { // List Accounts
                System.out.println("What bank");
                String bankName = scanner.nextLine();
                Bank bank = getBank(bankName);
                for(CurrentAccount account : bank.getAccounts()) {
                    System.out.println(account);
                }
            } else if(input.equals("7")) {
                System.out.println("What holder");
                String holderName = scanner.nextLine();
                Holder holder = getHolder(holderName);

                System.out.println("What bank");
                String bankName = scanner.nextLine();
                Bank bank = getBank(bankName);

                System.out.println("How much");
                int amount = Integer.parseInt(scanner.nextLine());

                CurrentAccount account = bank.getAccount(holder);
                account.credit(amount);
            } else if(input.equals("8")) {
                System.out.println("What holder");
                String holderName = scanner.nextLine();
                Holder holder = getHolder(holderName);

                System.out.println("What bank");
                String bankName = scanner.nextLine();
                Bank bank = getBank(bankName);

                System.out.println("How much");
                int amount = Integer.parseInt(scanner.nextLine());

                CurrentAccount account = bank.getAccount(holder);
                account.debit(amount);
            }
            else if (input.equals("9")) { // Transfer
                System.out.println("What first holder");
                String firstHolderName = scanner.nextLine();
                Holder firstHolder = getHolder(firstHolderName);

                System.out.println("What bank");
                String firstBankName = scanner.nextLine();
                Bank firstBank = getBank(firstBankName);

                System.out.println("What second holder");
                String secondHolderName = scanner.nextLine();
                Holder secondHolder = getHolder(secondHolderName);

                System.out.println("What bank");
                String secondBankName = scanner.nextLine();
                Bank secondBank = getBank(secondBankName);

                System.out.println("How much");
                int amount = Integer.parseInt(scanner.nextLine());

                CurrentAccount firstAccount = firstBank.getAccount(firstHolder);
                CurrentAccount secondAccount = secondBank.getAccount(secondHolder);
                if(firstAccount != null && secondAccount != null) {
                    firstAccount.transfer(secondAccount, amount);
                }
            }else if(input.equals("10")){
                System.out.println("What holder");
                String holderName = scanner.nextLine();
                Holder holder = getHolder(holderName);

                System.out.println("What bank");
                String bankName = scanner.nextLine();
                Bank bank = getBank(bankName);
               

                CurrentAccount account = bank.getAccount(holder);
                bank.closeAccount(account);
            }else if(input.equals("11")){
                System.out.println("What bank");
                String bankName = scanner.nextLine();
                Bank bank = getBank(bankName);
                closeBank(bank);
            }
            System.out.println("\n\n\n----------------------------------------");
        }
    }
    static void addHolder(Holder holder) {
        Holder[] tempHolders = 
        holders.length > 0 ?
        Arrays.copyOf(holders, holders.length + 1) : new Holder[1];
        tempHolders[holders.length] = holder;
        holders = tempHolders;
    }
    static void addBank(Bank bank) {
        Bank[] tempBanks = 
        banks.length > 0 ?
        Arrays.copyOf(banks, banks.length + 1) : new Bank[1];
        tempBanks[banks.length] = bank;
        banks = tempBanks;
    }
    static Holder getHolder(String holderName) {
        Holder holder = null;
        for (Holder h : holders) {
            if (h.getName().equals(holderName)) {
                holder = h;
            }
        }
        return holder;
    }
    static Bank getBank(String bankName) {
        Bank bank = null;
        for (Bank b : banks) {
            if (b.getName().equals(bankName)) {
                bank = b;
            }
        }
        return bank;
    }
    static void closeBank(Bank bank) {
        bank.shutBank();
        Bank[] tempBanks = new Bank[banks.length - 1];
        int j = 0;
        for(int i = 0; i < banks.length; i++) {
            if(banks[i] != bank) {
                tempBanks[j] = banks[i];
                j++;
            }
        }
        banks = tempBanks;
    }
}
