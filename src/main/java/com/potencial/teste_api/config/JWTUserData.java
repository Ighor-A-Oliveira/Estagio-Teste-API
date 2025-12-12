package com.potencial.teste_api.config;

import lombok.Builder;

@Builder
public record JWTUserData(Long userId, String email) {
}