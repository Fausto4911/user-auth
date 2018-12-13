package com.userauthentication.userauth.domain.quote;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuoteService {


    @Autowired
    QuoteRepository quoteRepository;


    public void save(Quote quote){
        quoteRepository.save(quote);
    }

    public void deleteById(Long id) {
        quoteRepository.deleteById(id);

    }

    public Iterable<Quote> getAllQuotes() {
        return quoteRepository.findAll();
    }

}
