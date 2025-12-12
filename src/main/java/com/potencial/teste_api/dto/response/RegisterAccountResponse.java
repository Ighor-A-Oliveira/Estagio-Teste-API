package com.potencial.teste_api.dto.response;

import com.potencial.teste_api.entity.Account;

import java.math.BigDecimal;
import java.time.OffsetDateTime;


//Oq eu quero mandar de volta ao usuario
public record RegisterAccountResponse(
        String accountNumber,
        BigDecimal balance,
        Account.AccountStatus status,
        OffsetDateTime createdAt
) {

}
