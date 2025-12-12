package com.potencial.teste_api.controller;

import com.potencial.teste_api.config.TokenConfig;
import com.potencial.teste_api.dto.request.LoginRequest;
import com.potencial.teste_api.dto.request.RegisterUserRequest;
import com.potencial.teste_api.dto.response.LoginResponse;
import com.potencial.teste_api.dto.response.RegisterUserResponse;
import com.potencial.teste_api.entity.User;
import com.potencial.teste_api.repository.UserRepository;
import com.potencial.teste_api.service.TransactionService;
import com.potencial.teste_api.service.UserService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;

    private final AuthenticationManager authenticationManager;
    private final TokenConfig tokenConfig;
    private final UserService userService;
    private static final Logger logger = LoggerFactory.getLogger(TransactionService.class);

    public UserController(UserRepository userRepository, AuthenticationManager authenticationManager, TokenConfig tokenConfig, UserService userService){
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.tokenConfig = tokenConfig;
        this.userService = userService;
    }

    @PostMapping("/login")
    //Recebe e valida o JSON do login
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest loginRequest){
        //Cria o token de autenticação interno do Spring
        //Spring Security só aceita login no formato UsernamePasswordAuthenticationToken
        UsernamePasswordAuthenticationToken userAndPass = new UsernamePasswordAuthenticationToken(loginRequest.email(), loginRequest.password());
        //Autentica no Spring Security:
        //Busca o usuário no banco (UserDetailsService)
        //Compara a senha com BCrypt (PasswordEncoder)
        //se estiver certo: retorna um objeto Authentication
        //se estiver errado: lança BadCredentialsException
        Authentication authentication = authenticationManager.authenticate(userAndPass);

        //Recupera o usuário autenticado do banco de dados
        User user = (User) authentication.getPrincipal();
        //Gera o JWT para o usuário logado
        String token = tokenConfig.generateToken(user);

        logger.info("Usuário: {}, Endpoint: /auth/login, Data: {}, Payload: {}",
                loginRequest.email(),
                LocalDateTime.now(),
                loginRequest);
        //
        //Retorna o token no body
        //retorna uma resposta HTTP 200 (OK) contendo um objeto JSON com o token dentro
        return ResponseEntity.ok(new LoginResponse(token));
    }

    @PostMapping("/register")
    //Recebe uma requisição HTTP POST com um JSON no corpo (@RequestBody).
    //O JSON é convertido para o objeto RegisterUserRequest.
    public ResponseEntity<RegisterUserResponse> register(@Valid @RequestBody RegisterUserRequest userRequest){


        User newUser = userService.createUser(userRequest);


        RegisterUserResponse response = new RegisterUserResponse(
                newUser.getName(),
                newUser.getEmail(),
                newUser.getCpf()
        );


        //Salva no banco de dados
        //userRepository.save(newUser);


        //Retorna uma resposta HTTP 201 (Created)
        //Responde 201 CREATED, dizendo que o usuário foi criado.
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
