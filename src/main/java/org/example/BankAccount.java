package org.example;

public class BankAccount {
    private String accountNumber;
    private String bankAccountHolderName;
    private float availableBalance;

    public BankAccount(String accountNumber, String bankAccountHolderName){
        this.accountNumber = accountNumber;
        this.bankAccountHolderName = bankAccountHolderName;
    }

    public BankAccount(String accountNumber, String bankAccountHolderName, float initialDeposit){
        this.accountNumber = accountNumber;
        this.bankAccountHolderName = bankAccountHolderName;
        if(initialDeposit < 0){
            System.out.println("Invalid amount.");
        } else {
            this.availableBalance = initialDeposit;
        }
    }

    public float getAvailableBalance() {
        return availableBalance;
    }

    public String getAccountNumber(){
        return accountNumber;
    }

    public String getBankAccountHolderName(){
        return bankAccountHolderName;
    }

    public void deposit(float depositAmount){
        if(depositAmount <= 0){
            System.out.println("Invalid amount.");
        } else{
            availableBalance += depositAmount;
            System.out.println("Total balance: " + availableBalance);
        }
    }

    public void withdraw(float withdrawAmount){
        if(availableBalance < withdrawAmount || withdrawAmount <= 0){
            System.out.println("Invalid amount.");
        } else{
            availableBalance -= withdrawAmount;
            System.out.println("Current balance: " + availableBalance);
        }
    }

    public void displayInformation(){
        System.out.println("Account Number: " + this.getAccountNumber());
        System.out.println("Bank Account Holder Name: " + this.getBankAccountHolderName());
        System.out.println("Available: " + this.getAvailableBalance());
    }
}
