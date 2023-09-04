package com.bankchallenge.infrastructure.repository;

import com.bankchallenge.infrastructure.entity.Blogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BlogsRepository extends JpaRepository<Blogs, Long> {

    @Query("SELECT u FROM Blogs u WHERE UPPER(u.title) = UPPER(:title)")
    Optional<Blogs> getReaderByTitle(final String title);

    @Query("SELECT u FROM Blogs u WHERE UPPER(u.title) = UPPER(:title) AND u.id NOT IN (:id)")
    Optional<Blogs> getByNameWithoutId(final String title, final Long id);

    @Query("SELECT b FROM Blogs b WHERE b.id NOT IN (SELECT br.blog.id FROM BlogsReaders br WHERE br.reader.id = :readerId)")
    List<Blogs> getBlogs(final Long readerId);
}
