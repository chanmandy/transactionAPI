package io.pismo.transactionAPI.repository;

import io.pismo.transactionAPI.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
