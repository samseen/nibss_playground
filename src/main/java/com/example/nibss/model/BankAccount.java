package com.example.nibss.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class BankAccount {

    private Long id;
    private String firstName;
    private String lastName;
    private String bankCode;
    private Double accountBalance;
    private String accountNumber;

    public BankAccount(Long id, String firstName, String lastName, String bankCode, Double accountBalance, String accountNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.bankCode = bankCode;
        this.accountBalance = accountBalance;
        this.accountNumber = accountNumber;
    }

    public BankAccount(String firstName, String lastName, String bankCode, Double accountBalance, String accountNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.bankCode = bankCode;
        this.accountBalance = accountBalance;
        this.accountNumber = accountNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Double accountBalance) {
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
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", bankCode='" + bankCode + '\'' +
                ", accountBalance='" + accountBalance + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                '}';
    }
}
