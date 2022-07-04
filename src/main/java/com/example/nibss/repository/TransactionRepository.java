package com.example.nibss.repository;

import com.example.nibss.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository
        extends JpaRepository<Transaction, Long> {

    @Query("SELECT t FROM Transaction t WHERE t.commissionWorthy " +
            "= ?1 OR t.transactionReference = ?2 OR t.status = ?3")
    List<Transaction> findByParams(boolean commissionWorthiness, String transactionReference, String status);

}
