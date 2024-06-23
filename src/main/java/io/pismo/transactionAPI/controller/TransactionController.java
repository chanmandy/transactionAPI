package io.pismo.transactionAPI.controller;

import io.pismo.transactionAPI.bean.ErrorDto;
import io.pismo.transactionAPI.bean.TransactionRequestDto;
import io.pismo.transactionAPI.bean.TransactionResponseDto;
import io.pismo.transactionAPI.service.TransactionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Transaction Management APIs")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/transactions")
    @Operation(summary = "Create Transaction", description = "Creates a transaction using provided input.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created", content = @Content(schema = @Schema(implementation = TransactionResponseDto.class))),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(schema = @Schema(implementation = ErrorDto.class))),
            @ApiResponse(responseCode = "404", description = "Not found", content = @Content(schema = @Schema(implementation = ErrorDto.class)))
    })
    public ResponseEntity<TransactionResponseDto> create(@Valid @RequestBody TransactionRequestDto requestDto){
        return new ResponseEntity<>(transactionService.create(requestDto), HttpStatus.CREATED);
    }

}
