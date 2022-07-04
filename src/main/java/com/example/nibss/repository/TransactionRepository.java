package com.example.nibss.repository;

import com.example.nibss.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransactionRepository
        extends JpaRepository<Transaction, Long> {

    @Query("SELECT t FROM Transaction t WHERE t.commissionWorthy " +
            "= ?1 OR t.transactionReference = ?2 OR t.status = ?3")
    List<Transaction> findByParams(boolean commissionWorthiness, String transactionReference,
                                   String status);

    @Query(value = "SELECT * FROM Transaction t WHERE commission_worthy = ?1 OR status = ?3 OR " +
            "transaction_reference = ?2 OR DATE(created_date) = ?4", nativeQuery = true)
    List<Transaction> findByDetails(boolean commissionWorthiness, String transactionReference,
                                    String status, LocalDateTime startDate, LocalDateTime endDate);

    /**
     * Finds all transactions made between the given dates.
     *
     * @param startDate The start date of the range.
     * @return A list of transactions.
     */
    @Query(value = "SELECT * FROM Transaction t WHERE DATE(created_date) <= ?1", nativeQuery = true)
    List<Transaction> findByDateCreated(LocalDateTime startDate);

}
