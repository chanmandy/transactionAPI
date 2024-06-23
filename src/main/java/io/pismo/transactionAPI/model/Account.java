package io.pismo.transactionAPI.model;

import io.pismo.transactionAPI.bean.AccountResponseDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PRIVATE;

@Entity
@NoArgsConstructor
@Builder
@Data
@AllArgsConstructor(access = PRIVATE)
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false, updatable = false)
    private String documentNumber;

    public AccountResponseDto toResponseDto() {
        return AccountResponseDto.builder().id(id).documentNumber(documentNumber).build();
    }
}
