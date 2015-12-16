package com.twu.biblioteca;

public class BookBuilder {
    private String name;

    private BookBuilder() {
    }

    public static BookBuilder aBook() {
        return new BookBuilder();
    }

    public BookBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public BookBuilder but() {
        return aBook().withName(name);
    }

    public Book build() {
        Book book = new Book();
        book.setName(name);
        return book;
    }
}
