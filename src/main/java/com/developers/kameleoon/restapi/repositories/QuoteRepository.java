package com.developers.kameleoon.restapi.repositories;

import com.developers.kameleoon.restapi.models.Quote;
import com.developers.kameleoon.restapi.models._User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, Long> {

    List<Quote> findByAuthorId(_User authorId);
}
