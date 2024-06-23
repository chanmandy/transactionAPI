package io.pismo.transactionAPI.model;

import io.pismo.transactionAPI.enums.LedgerEntry;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static io.pismo.transactionAPI.enums.LedgerEntry.CREDIT;
import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PRIVATE;

@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor(access = PRIVATE)
@Table(name = "operationType")
@Data
public class OperationType {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(length = 120, nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, updatable = false, name = "ledger_entry")
    private LedgerEntry entry;

    public boolean isCredit() {
        return entry == CREDIT;
    }
}
