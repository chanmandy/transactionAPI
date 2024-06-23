package io.pismo.transactionAPI.controller;

import io.pismo.transactionAPI.bean.AccountRequestDto;
import io.pismo.transactionAPI.bean.AccountResponseDto;
import io.pismo.transactionAPI.bean.ErrorDto;
import io.pismo.transactionAPI.service.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
@Tag(name = "Account Management APIs")
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping("/{id}")
    @Operation(summary = "Find Account by ID", description = "Searches for an account using id.")
    @Parameters(value = {
            @Parameter(name = "id",  description = "A positive number that identifies an account.", required = true, example = "1")
    })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = AccountResponseDto.class))),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(schema = @Schema(implementation = ErrorDto.class))),
            @ApiResponse(responseCode = "404", description = "Not found", content = @Content(schema = @Schema(implementation = ErrorDto.class)))
    })
    public ResponseEntity<AccountResponseDto> getById(@Positive @PathVariable Long id){
        return new ResponseEntity<>(accountService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "Create Account", description = "Creates an account using provided input.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created", content = @Content(schema = @Schema(implementation = AccountResponseDto.class))),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(schema = @Schema(implementation = ErrorDto.class)))
    })
    public ResponseEntity<AccountResponseDto> create(@Valid @RequestBody AccountRequestDto account){
        return new ResponseEntity<>(accountService.createAccount(account),HttpStatus.CREATED);
    }
}
