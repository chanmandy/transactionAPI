package io.pismo.transactionAPI.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PRIVATE;

@Entity
@NoArgsConstructor
@AllArgsConstructor(access = PRIVATE)
@Table(name = "transaction")
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

}
