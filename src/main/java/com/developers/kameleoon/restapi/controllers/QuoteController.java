package com.developers.kameleoon.restapi.controllers;

import com.developers.kameleoon.restapi.dto.QuoteDTO;
import com.developers.kameleoon.restapi.models.Quote;
import com.developers.kameleoon.restapi.service.QuoteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/quotes")
public class QuoteController {
    private final QuoteService quoteService;

    @PostMapping
    public Quote create(@RequestBody QuoteDTO dto) {
        return quoteService.create(dto);
    }

    @GetMapping
    public List<Quote> readAll() {
        return quoteService.readAll();
    }

    @GetMapping("/{id}")
    public Quote readById(@PathVariable Long id) {
        return quoteService.readById(id);
    }

    @PutMapping
    public Quote update(@RequestBody QuoteDTO dto) {
        return quoteService.update(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        quoteService.delete(id);
    }

    @GetMapping("/rnd")
    public Quote getRandomQuote() {
        return quoteService.getRandomQuote();
    }

    @GetMapping("/{id}/like")
    public void votePlus(@PathVariable Long id) {
        quoteService.votePlus(id);
    }

    @GetMapping("/{id}/dislike")
    public void voteMinus(@PathVariable Long id) {
        quoteService.voteMinus(id);
    }

    @GetMapping("/topten")
    public List<Quote> readTopTen() {
        return quoteService.readTopTen();
    }

    @GetMapping("/worseten")
    public List<Quote> readWorseTen() {
        return quoteService.readWorseTen();
    }
}
