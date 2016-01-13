package com.twu.biblioteca.book;

public class Book {
    private String name;
    private String author;
    private String yearPublished;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(String yearPublished) {
        this.yearPublished = yearPublished;
    }

    public static class BookBuilder {
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
}
