package io.pismo.transactionAPI.repository;

import io.pismo.transactionAPI.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query(value = "select t from Transaction t where account.id=?1 and balance < 0.0")
    List<Transaction> findIncompleteTransactions(Long accountId);
}
