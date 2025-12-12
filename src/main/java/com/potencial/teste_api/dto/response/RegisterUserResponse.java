package com.potencial.teste_api.dto.response;

//Oq eu quero mandar de volta ao usuario
public record RegisterUserResponse(
        String name,
        String email,
        String cpf) {

}