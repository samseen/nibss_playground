package com.example.nibss.utility;

public class TransactionOperation {

    public static double calculateTransactionFee(double amount){
        double transactionFee = (0.5 / 100) * amount;
        return Math.min(amount, 100);
    }

    public static double calculateCommission(double transactionFee) {
        return (20 / 100) * transactionFee;
    }
}
