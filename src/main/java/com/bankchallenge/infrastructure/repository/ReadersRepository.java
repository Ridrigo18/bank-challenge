package com.bankchallenge.infrastructure.repository;

import com.bankchallenge.infrastructure.entity.Readers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ReadersRepository extends JpaRepository<Readers, Long> {

    @Query("SELECT u FROM Readers u WHERE UPPER(u.name) = UPPER(:name)")
    Optional<Readers> getReaderByName(final String name);

    @Query("SELECT u FROM Readers u WHERE UPPER(u.name) = UPPER(:name) AND u.id NOT IN (:id)")
    Optional<Readers> getReadersByNameWithoutId(final String name, final Long id);


}
