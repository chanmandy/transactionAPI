package io.pismo.transactionAPI.repository;

import io.pismo.transactionAPI.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
