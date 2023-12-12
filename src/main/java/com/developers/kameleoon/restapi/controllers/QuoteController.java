package com.developers.kameleoon.restapi.controllers;

import com.developers.kameleoon.restapi.dto.QuoteDTO;
import com.developers.kameleoon.restapi.models.Quote;
import com.developers.kameleoon.restapi.service.QuoteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/quotes")
public class QuoteController {
    private final QuoteService quoteService;

    @PostMapping
    public ResponseEntity<Quote> create(@RequestBody QuoteDTO dto) {
        return mappingResponseQuote(quoteService.create(dto));
    }

    @GetMapping("/rnd")
    public ResponseEntity<Quote> getRandomQuote() {
        return mappingResponseQuote(quoteService.getRandomQuote());
    }

    @GetMapping
    public ResponseEntity<List<Quote>> readAll() {
        return mappingResponseListQuote(quoteService.readAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Quote> readById(@PathVariable Long id) {
        return mappingResponseQuote(quoteService.readById(id));
    }

    @PutMapping
    public ResponseEntity<Quote> update(@RequestBody Quote quote) {
        return mappingResponseQuote(quoteService.update(quote));
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        quoteService.delete(id);
        return HttpStatus.OK;
    }

    @GetMapping("/{id}/like")
    public HttpStatus votePlus(@PathVariable Long id) {
        quoteService.votePlus(id);
        return HttpStatus.OK;
    }

    @GetMapping("/{id}/dislike")
    public HttpStatus voteMinus(@PathVariable Long id) {
        quoteService.voteMinus(id);
        return HttpStatus.OK;
    }

    @GetMapping("/topten")
    public ResponseEntity<List<Quote>> readTopTen() {
        return mappingResponseListQuote(quoteService.readTopTen());
    }

    @GetMapping("/worseten")
    public ResponseEntity<List<Quote>> readWorseTen() {
        return mappingResponseListQuote(quoteService.readWorseTen());
    }

    private ResponseEntity<Quote> mappingResponseQuote(Quote quote) {
        return new ResponseEntity<>(quote, HttpStatus.OK);
    }

    private ResponseEntity<List<Quote>> mappingResponseListQuote(List<Quote> quoteList) {
        return new ResponseEntity<>(quoteList, HttpStatus.OK);
    }
}
