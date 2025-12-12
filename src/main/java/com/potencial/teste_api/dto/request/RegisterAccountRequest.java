package com.potencial.teste_api.dto.request;

import jakarta.validation.constraints.NotEmpty;

public record RegisterAccountRequest(
                @NotEmpty(message = "Cpf é obrigatorio!") String cpf

) {

}
