package io.pismo.transactionAPI.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import static lombok.AccessLevel.PRIVATE;

@Data
@AllArgsConstructor(access = PRIVATE)
@Builder
public class AccountResponseDto {

    @NotNull
    @JsonProperty("account_id")
    private Long id;

    @NotNull
    @JsonProperty("document_number")
    private String documentNumber;
}
