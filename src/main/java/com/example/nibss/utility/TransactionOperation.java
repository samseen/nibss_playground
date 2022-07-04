package com.example.nibss.utility;

import java.util.UUID;

public class TransactionOperation {

    public static double calculateTransactionFee(double amount){
        double transactionFee = (0.5 / 100) * amount;
        return Math.min(transactionFee, 100);
    }

    public static double calculateCommission(double transactionFee) {
        return (20 / 100) * transactionFee;
    }

    public static double calculateAmountToBeTransferred(double amount, double transactionFee) {
        return amount + transactionFee;
    }

    public static boolean checkIfSourceAccountHasEnoughMoney(double amountToBeTransferred, double sourceAccountBalance) {
        return amountToBeTransferred <= sourceAccountBalance;
    }

    public static boolean checkIfTransactionIsCommissionWorthy(double transactionFee) {
        return transactionFee >= 0;
    }

    public static String getTransactionReference() {

        UUID uuid = UUID.randomUUID();
        String uuidAsString = uuid.toString().substring(0, 8);
        return "trxn" + uuidAsString;
    }
}
