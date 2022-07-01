package com.example.nibss.model;

public class BankAccount {
    private String firstName;
    private String lastName;
    private String bankCode;
    private String accountBalance;
    private String accountNumber;

    public BankAccount(String firstName, String lastName, String bankCode, String accountBalance, String accountNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.bankCode = bankCode;
        this.accountBalance = accountBalance;
        this.accountNumber = accountNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(String accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", bankCode='" + bankCode + '\'' +
                ", accountBalance='" + accountBalance + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                '}';
    }
}
