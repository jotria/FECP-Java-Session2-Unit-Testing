package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static BankAccount findBankAccountByNumber(String accountNumber, ArrayList<BankAccount> bankAccounts) {
        if (accountNumber == null || accountNumber.isEmpty()) {
            return null;
        }

        for (BankAccount bankAccount : bankAccounts) {
            if (bankAccount.getAccountNumber() != null && bankAccount.getAccountNumber().equalsIgnoreCase(accountNumber)) {
                return bankAccount;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        ArrayList<BankAccount> bankAccounts = new ArrayList<>();

        int choice;
        String returnChoice = "";
        String accountNumber = "";
        String bankAccountHolderName = "";
        String initialDeposit = "";
        float addAmount = 0;
        float deductAmount = 0;
        Scanner scanner = new Scanner(System.in);

        do{
            System.out.println("\n === Bank Menu ===");
            System.out.println("1. Create Account");
            System.out.println("2. View All Accounts");
            System.out.println("3. Check Balance");
            System.out.println("4. Deposit");
            System.out.println("5. Withdraw");
            System.out.println("6. Exit");

            System.out.print("Enter choice (1-6): ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice){
                case 1:
                    System.out.print("Enter Account Number: ");
                    accountNumber = scanner.nextLine();

                    System.out.print("Enter Holder Name: ");
                    bankAccountHolderName = scanner.nextLine();

                    System.out.print("Initial deposit? (yes/no): ");
                    initialDeposit = scanner.nextLine();

                    if(initialDeposit.equals("yes")){
                        System.out.print("Enter initial deposit amount: ");
                        float initialDepositAmount = scanner.nextFloat();
                        scanner.nextLine();

                        bankAccounts.add(new BankAccount(accountNumber, bankAccountHolderName, initialDepositAmount));

                    } else{
                        bankAccounts.add(new BankAccount(accountNumber, bankAccountHolderName));
                        break;
                    }

                    System.out.println("Account created successfully!");
                    break;

                case 2:
                    for(BankAccount bankAccount : bankAccounts){
                        bankAccount.displayInformation();
                    }
                    break;
                case 3:
                    System.out.print("Enter Account Number: ");
                    accountNumber = scanner.nextLine();

                    BankAccount accountBalance = findBankAccountByNumber(accountNumber, bankAccounts);
                    try{
                        System.out.println("Current balance of " + accountBalance.getBankAccountHolderName() + " is " + accountBalance.getAvailableBalance());
                    } catch (NullPointerException e){
                        System.out.println("Account not found!");
                    }

                    break;
                case 4:
                    System.out.print("Enter Account Number: ");
                    accountNumber = scanner.nextLine();

                    BankAccount account = findBankAccountByNumber(accountNumber, bankAccounts);

                    System.out.print("How much would you like to deposit?: ");
                    addAmount = scanner.nextFloat();
                    scanner.nextLine();

                    account.deposit(addAmount);
                    break;
                case 5:
                    System.out.print("Enter Account Number: ");
                    accountNumber = scanner.nextLine();

                    BankAccount accountToWithdraw = findBankAccountByNumber(accountNumber, bankAccounts);

                    System.out.print("How much would you like to withdraw?: ");
                    deductAmount = scanner.nextFloat();
                    scanner.nextLine();

                    accountToWithdraw.withdraw(deductAmount);
                    break;
                case 6:
                    System.out.println("-----Thank you for banking with us!-----");
                    break;
            }
            if (choice != 6) {
                System.out.print("\nWould you like to return to the menu? (yes/no): ");
                returnChoice = scanner.nextLine();
            } else{
                break;
            }

        } while(returnChoice.equals("yes"));
    }
}