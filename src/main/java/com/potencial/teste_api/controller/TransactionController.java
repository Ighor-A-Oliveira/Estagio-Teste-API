package com.potencial.teste_api.controller;

import com.potencial.teste_api.dto.request.DepositRequest;
import com.potencial.teste_api.dto.request.ExternalTransferRequest;
import com.potencial.teste_api.dto.request.InternalTransferRequest;
import com.potencial.teste_api.dto.request.WithdrawRequest;
import com.potencial.teste_api.dto.response.TransactionResponse;
import com.potencial.teste_api.entity.Transaction;
import com.potencial.teste_api.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService){
        this.transactionService= transactionService;
    }

    @PostMapping("/deposit")
    public ResponseEntity<TransactionResponse> deposit(@Valid @RequestBody DepositRequest depositRequest){
        //Criamos uma Transacao e passamos a requisicao
        Transaction newTransaction = transactionService.makeDeposit(depositRequest);
        TransactionResponse transactionResponse = new TransactionResponse(
                newTransaction.getId(),
                newTransaction.getType(),
                newTransaction.getAmount(),
                newTransaction.getSourceAccount().getAccountId(),
                newTransaction.getDestinationAccount() != null ? newTransaction.getDestinationAccount().getAccountId() : null,
                newTransaction.getTimestamp(),
                newTransaction.getBalanceAfterOperation()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(transactionResponse);
    }

    @PostMapping("/withdraw")
    public ResponseEntity<TransactionResponse> withdraw(@Valid @RequestBody WithdrawRequest withdrawRequest){
        //Criamos uma Transacao e passamos a requisicao
        Transaction newTransaction = transactionService.makeWithdrawal(withdrawRequest);
        TransactionResponse transactionResponse = new TransactionResponse(
                newTransaction.getId(),
                newTransaction.getType(),
                newTransaction.getAmount(),
                newTransaction.getSourceAccount().getAccountId(),
                newTransaction.getDestinationAccount() != null ? newTransaction.getDestinationAccount().getAccountId() : null,
                newTransaction.getTimestamp(),
                newTransaction.getBalanceAfterOperation()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(transactionResponse);
    }

    @PostMapping("/internal-transfer")
    public ResponseEntity<TransactionResponse> internalTransfer(@Valid @RequestBody InternalTransferRequest internalTransferRequest){
        //Criamos uma Transacao e passamos a requisicao
        Transaction newTransaction = transactionService.makeInternalTransfer(internalTransferRequest);
        TransactionResponse transactionResponse = new TransactionResponse(
                newTransaction.getId(),
                newTransaction.getType(),
                newTransaction.getAmount(),
                newTransaction.getSourceAccount().getAccountId(),
                newTransaction.getDestinationAccount() != null ? newTransaction.getDestinationAccount().getAccountId() : null,
                newTransaction.getTimestamp(),
                newTransaction.getBalanceAfterOperation()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(transactionResponse);
    }

    @PostMapping("/external-transfer")
    public ResponseEntity<TransactionResponse> externalTransfer(@Valid @RequestBody ExternalTransferRequest externalTransferRequest){
        //Criamos uma Transacao e passamos a requisicao
        Transaction newTransaction = transactionService.makeExternalTransfer(externalTransferRequest);
        TransactionResponse transactionResponse = new TransactionResponse(
                newTransaction.getId(),
                newTransaction.getType(),
                newTransaction.getAmount(),
                newTransaction.getSourceAccount().getAccountId(),
                newTransaction.getDestinationAccount() != null ? newTransaction.getDestinationAccount().getAccountId() : null,
                newTransaction.getTimestamp(),
                newTransaction.getBalanceAfterOperation()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(transactionResponse);
    }
}
