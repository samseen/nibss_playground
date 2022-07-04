package com.example.nibss.utility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Locale;
import java.util.UUID;

public class TransactionOperation {

    public static double calculateTransactionFee(double amount){
        double transactionFee = (0.5 / 100) * amount;
        return Math.min(transactionFee, 100);
    }

    public static double calculateCommission(double transactionFee) {
        return (20.0 / 100.0) * transactionFee;
    }

    public static double calculateAmountToBeTransferred(double amount, double transactionFee) {
        return amount + transactionFee;
    }

    public static boolean checkIfSourceAccountHasEnoughMoney(double amountToBeTransferred, double sourceAccountBalance) {
        return amountToBeTransferred <= sourceAccountBalance;
    }

    /*
     * This method is used to check if a transaction is commission worthy.
     * 10 (which is arbitrarily chosen) is the minimum amount for a transaction to be commission worthy.
     */
    public static boolean checkIfTransactionIsCommissionWorthy(double transactionFee) {
        return transactionFee >= 10;
    }

    public static String getTransactionReference() {

        UUID uuid = UUID.randomUUID();
        String uuidAsString = uuid.toString().substring(0, 10);
        return "trxn" + uuidAsString;
    }

    /**
     * This method will convert a string to a LocalDateTime object.
     */
    public static LocalDateTime convertStringToLocalDateTime(String dateTime) {
//        return LocalDateTime.parse(dateTime);
        String str = dateTime;
        System.out.println("str: " + str);
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                // case insensitive to parse JAN and FEB
                .parseCaseInsensitive()
                // add pattern
                .appendPattern("yyyy-MM-dd[ [HH][:mm][:ss][.SSS]]")
                .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
                .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
                .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0)
                // create formatter (use English Locale to parse month names)
                .toFormatter(Locale.ENGLISH);
        return LocalDateTime.parse(str, formatter);
    }
}
