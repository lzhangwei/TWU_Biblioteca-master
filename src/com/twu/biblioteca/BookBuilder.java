package com.twu.biblioteca;

public class BookBuilder {
    private String name;
    private String author;
    private String yearPublished;

    private BookBuilder() {
    }

    public static BookBuilder aBook() {
        return new BookBuilder();
    }

    public BookBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public BookBuilder withAuthor(String author) {
        this.author = author;
        return this;
    }

    public BookBuilder withYearPublished(String yearPublished) {
        this.yearPublished = yearPublished;
        return this;
    }

    public BookBuilder but() {
        return aBook().withName(name).withAuthor(author).withYearPublished(yearPublished);
    }

    public Book build() {
        Book book = new Book();
        book.setName(name);
        book.setAuthor(author);
        book.setYearPublished(yearPublished);
        return book;
    }
}
