package com.bankchallenge.infrastructure.repository;

import com.bankchallenge.infrastructure.entity.BlogsReaders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogReadersRepository extends JpaRepository<BlogsReaders, Long> {


}
