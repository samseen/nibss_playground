package com.example.nibss.repository;

import com.example.nibss.model.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferRepository
        extends JpaRepository<Transfer, Long> {

}
