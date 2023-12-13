package com.developers.kameleoon.restapi.service;

import com.developers.kameleoon.restapi.dto.QuoteDTO;
import com.developers.kameleoon.restapi.models.Quote;
import com.developers.kameleoon.restapi.repositories.QuoteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class QuoteService {
    private final QuoteRepository quoteRepository;
    private final UserService userService;

    public Quote create(QuoteDTO dto) {
        Date currentDate = new Date();

        Quote quote = Quote.builder()
                .content(dto.getContent())
                .creationDate(currentDate)
                .author(userService.readById(dto.getAuthor()))
                .build();
        return quoteRepository.save(quote);
    }

    public List<Quote> readAll() {
        return quoteRepository.findAll();
    }

    public Quote readById(Long id) {
        return quoteRepository.findQuoteById(id);
    }

    public Quote update(QuoteDTO dto) {
        Date currentDate = new Date();
        Quote quote = readById(dto.getId());

        quote.setContent(dto.getContent());
        quote.setCreationDate(currentDate);

        return quoteRepository.save(quote);
    }

    public void delete(Long id) {
        quoteRepository.deleteById(id);
    }

    public Quote getRandomQuote() {
        return quoteRepository.readRandomQuote();
    }

    public void votePlus(Long id) {
        quoteRepository.incrementVotesById(id);
    }

    public void voteMinus(Long id) {
        quoteRepository.decrementVotesById(id);
    }

    public List<Quote> readTopTen() {
        return quoteRepository.readTopTenVotes();
    }

    public List<Quote> readWorseTen() {
        return quoteRepository.readWorseTenVotes();
    }

//    public List<Quote> readByAuthorId(_User user) {
//        return quoteRepository.findByAuthorId(user);
//    }
}
