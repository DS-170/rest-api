package com.developers.kameleoon.restapi.repositories;

import com.developers.kameleoon.restapi.models.Quote;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuoteRepository extends JpaRepository<Quote, Long> {

    @Query(value = "SELECT * FROM QUOTES ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Quote readRandomQuote();

    @Query(value = "SELECT * FROM QUOTES WHERE id = :id", nativeQuery = true)
    Quote findQuoteById(@Param("id") Long id);

    @Query(value = "SELECT * FROM QUOTES ORDER BY votes DESC LIMIT 10", nativeQuery = true)
    List<Quote> readTopTenVotes();

    @Query(value = "SELECT * FROM QUOTES ORDER BY votes ASC LIMIT 10", nativeQuery = true)
    List<Quote> readWorseTenVotes();

    @Modifying
    @Transactional
    @Query(value = "UPDATE QUOTES SET votes = votes + 1 WHERE id = :id", nativeQuery = true)
    void incrementVotesById(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE QUOTES SET votes = votes - 1 WHERE id = :id", nativeQuery = true)
    void decrementVotesById(@Param("id") Long id);
}
