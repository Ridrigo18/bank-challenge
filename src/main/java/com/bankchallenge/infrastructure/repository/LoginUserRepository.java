package com.bankchallenge.infrastructure.repository;

import com.bankchallenge.infrastructure.entity.LoginUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface LoginUserRepository extends CrudRepository<LoginUser, Long> {

    @Query("SELECT u FROM LoginUser u WHERE u.email =:email")
    Optional<LoginUser> getUserByEmail(final String email);


}
