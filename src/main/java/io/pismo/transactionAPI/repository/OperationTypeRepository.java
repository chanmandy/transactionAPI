package io.pismo.transactionAPI.repository;

import io.pismo.transactionAPI.model.OperationType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationTypeRepository extends JpaRepository<OperationType, Long> {
}
