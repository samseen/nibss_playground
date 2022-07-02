package com.example.nibss;

import com.example.nibss.model.Transfer;
import com.example.nibss.repository.TransferRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class TransferConfig {

//    @Bean
//    CommandLineRunner commandLineRunner(TransferRepository repository) {
//        return args -> {
//            Transfer transfer1 = new Transfer("57b2a6bc60d14e45ac81bb6b8205da0f",
//                    1500.00,
//                    0.75,
//                    1550.00,
//                    "transaction fee",
//                    LocalDate.of(2022, Month.MAY, 5),
//                    "Successful",
//                    true,
//                    50.00
//            );
//
//            Transfer transfer2 = new Transfer("57b2a6bc60d14e45ac81bb6b7456aj0f",
//                    2000.00,
//                    0.75,
//                    2050.00,
//                    "transaction fee",
//                    LocalDate.of(2022, Month.MAY, 5),
//                    "Successful",
//                    true,
//                    50.00
//            );
//
//            repository.saveAll(List.of(transfer1, transfer2));
//
//
//
////            BankAccount bankAccountFolake = new BankAccount("Folake",
////                    "Ajibade",
////                    "44",
////                    20300.00,
////                    "0124789963");
////
////            BankAccount bankAccountJoseph = new BankAccount("Joseph",
////                    "Odumosu",
////                    "44",
////                    25800.00,
////                    "0124789459");
////
////            BankAccount bankAccountFikayo = new BankAccount("Fikayo",
////                    "Ajayi",
////                    "47",
////                    15400.00,
////                    "4718789459");
////
////            bankAccountRepository.saveAll(List.of(bankAccountFolake, bankAccountJoseph, bankAccountFikayo));
//
//        };
//    }
}
