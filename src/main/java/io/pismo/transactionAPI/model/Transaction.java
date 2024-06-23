package io.pismo.transactionAPI.model;

import io.pismo.transactionAPI.bean.AccountResponseDto;
import io.pismo.transactionAPI.bean.TransactionResponseDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PRIVATE;

@Entity
@NoArgsConstructor
@AllArgsConstructor(access = PRIVATE)
@Table(name = "transaction")
@Builder
public class Transaction {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Account account;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private OperationType operationType;

    @Column(nullable = false, updatable = false)
    private BigDecimal amount;

    @Column(nullable = false, updatable = false)
    private LocalDateTime eventDate;

    public TransactionResponseDto toResponseDto() {
        return TransactionResponseDto.builder().transactionId(id).accountId(account.getId())
                .operationTypeId(operationType.getId()).amount(amount).eventDate(eventDate).build();
    }
}
