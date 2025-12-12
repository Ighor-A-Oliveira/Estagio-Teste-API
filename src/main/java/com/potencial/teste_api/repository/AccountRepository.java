package com.potencial.teste_api.repository;

import com.potencial.teste_api.entity.Account;
import com.potencial.teste_api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByAccountNumber(Long accountNumber);

    Optional<Account> findById(Long AccountId);

    Optional<Account> findByOwner(User user);

}
