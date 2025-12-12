package com.potencial.teste_api.dto.response;

import com.potencial.teste_api.entity.TransactionType;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

//Oq vou mandar de volta
public record TransactionResponse(
        Long id,
        TransactionType type,
        BigDecimal amount,
        Long sourceAccountId,
        Long destinationAccountId,
        OffsetDateTime timestamp,
        BigDecimal balanceAfterOperation
) {}
