package io.pismo.transactionAPI.model;

import io.pismo.transactionAPI.enums.LedgerEntry;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static io.pismo.transactionAPI.enums.LedgerEntry.CREDIT;
import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PRIVATE;

@Entity
@NoArgsConstructor
@AllArgsConstructor(access = PRIVATE)
@Table(name = "operation")
@Data
public class OperationType {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(length = 120, nullable = false)
    private String description;

    @Enumerated(STRING)
    @Column(nullable = false, updatable = false, columnDefinition = "ledger_entry")
    private LedgerEntry entry;

    public boolean isCredit() {
        return entry == CREDIT;
    }
}
