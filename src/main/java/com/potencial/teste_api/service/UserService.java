package com.potencial.teste_api.service;

import com.potencial.teste_api.dto.request.RegisterUserRequest;
import com.potencial.teste_api.entity.Role;
import com.potencial.teste_api.entity.User;
import com.potencial.teste_api.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Set;

@Service
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private static final Logger logger = LoggerFactory.getLogger(TransactionService.class);

    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository){
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }


    @Transactional
    public User createUser(RegisterUserRequest registerUserRequest){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth != null ? auth.getName() : "ANÔNIMO";

        //Cria um novo usuário
        User newUser = new User();
        //Copia os dados da requisição para o usuário
        //passwordEncoder.encode() esta criptografando a senha
        newUser.setName(registerUserRequest.name());
        newUser.setEmail(registerUserRequest.email());
        newUser.setCpf(registerUserRequest.cpf());
        newUser.setPassword(passwordEncoder.encode(registerUserRequest.password()));
        newUser.setRoles(Set.of(Role.USER));

        logger.info("Usuário: {}, Endpoint: {}, Data: {}, Payload: {}",
                username,
                "/user/register",
                LocalDateTime.now(),
                registerUserRequest
        );

        userRepository.save(newUser);

        return newUser;
    }
}
