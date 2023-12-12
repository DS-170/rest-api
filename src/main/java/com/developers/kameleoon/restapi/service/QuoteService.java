package com.developers.kameleoon.restapi.service;

import com.developers.kameleoon.restapi.dto.QuoteDTO;
import com.developers.kameleoon.restapi.models.Quote;
import com.developers.kameleoon.restapi.repositories.QuoteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Random;

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
                .authorId(userService.readById(dto.getAuthorId()))
                .build();
        return quoteRepository.save(quote);
    }

    public List<Quote> readAll() {
        return quoteRepository.findAll();
    }

    public Quote readById(Long id) {
        return quoteRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Quote not found - ID: " + id));
    }

    public Quote update(Quote quote) {
        Date currentDate = new Date();

        quote.setCreationDate(currentDate);
        return quoteRepository.save(quote);
    }

    public void delete(Long id) {
        quoteRepository.deleteById(id);
    }

    public Quote getRandomQuote() {
        Random random = new Random();

        return quoteRepository.findById(random.nextLong(readAll().size()) + 1).orElseThrow(() ->
                new RuntimeException("Have no Quote in List"));
    }

    public void votePlus(Long id) {
        Quote votedQuote = readById(id);
        votedQuote.setVotes(votedQuote.getVotes() + 1);
        quoteRepository.save(votedQuote);
    }

    public void voteMinus(Long id) {
        Quote votedQuote = readById(id);
        votedQuote.setVotes(votedQuote.getVotes() - 1);
        quoteRepository.save(votedQuote);
    }

    public List<Quote> readTopTen() {
        List<Quote> sortedList = readAll();
        sortedList.sort(Comparator.comparingInt(Quote::getVotes).reversed());

        if (10 < sortedList.size()) {
            sortedList.subList(10, sortedList.size()).clear();
        }

        return sortedList;
    }

    public List<Quote> readWorseTen() {
        List<Quote> sortedList = readAll();
        sortedList.sort(Comparator.comparingInt(Quote::getVotes));

        if (10 < sortedList.size()) {
            sortedList.subList(10, sortedList.size()).clear();
        }

        return sortedList;
    }

//    public List<Quote> readByAuthorId(_User user) {
//        return quoteRepository.findByAuthorId(user);
//    }
}
