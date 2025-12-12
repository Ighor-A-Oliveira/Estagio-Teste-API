package com.potencial.teste_api.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record WithdrawRequest(
        @NotNull(message = "Id da conta é obrigatório!") Long toAccountId,
        @NotNull @Positive(message = "Valor deve ser maior que 0!") BigDecimal amount
) {
}
