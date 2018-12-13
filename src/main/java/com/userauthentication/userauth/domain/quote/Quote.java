package com.userauthentication.userauth.domain.quote;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Quote {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String author;

    private String quote;

    private String source;

    private String category;


    public Quote(String author, String quote, String source, String category) {
        this.author = author;
        this.quote = quote;
        this.source = source;
        this.category = category;
    }

    public Quote() {

    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
