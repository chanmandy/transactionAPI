package io.pismo.transactionAPI.bean;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = PRIVATE)
public class AccountRequestDto {

    @NotNull
    @JsonProperty("document_number")
    private String documentNumber;
}
