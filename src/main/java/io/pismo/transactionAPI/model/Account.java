package io.pismo.transactionAPI.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PRIVATE;

@Entity
@NoArgsConstructor
@AllArgsConstructor(access = PRIVATE)
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false, updatable = false)
    private String documentNumber;
}
