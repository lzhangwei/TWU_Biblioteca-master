package com.twu.biblioteca.account;

import com.twu.biblioteca.book.Book;
import com.twu.biblioteca.movie.Movie;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private User user;
    private String password;
    private List<Book> checkoutBooks = new ArrayList<>();
    private List<Movie> checkoutMovies = new ArrayList<>();

    public Account(User user, String password) {
        this.user = user;
        this.password = password;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Book> getCheckoutBooks() {
        return checkoutBooks;
    }

    public void setCheckoutBooks(List<Book> checkoutBooks) {
        this.checkoutBooks = checkoutBooks;
    }

    public List<Movie> getCheckoutMovies() {
        return checkoutMovies;
    }

    public void setCheckoutMovies(List<Movie> checkoutMovies) {
        this.checkoutMovies = checkoutMovies;
    }

    public void addCheckoutBook(Book book) {
        checkoutBooks.add(book);
    }

    public void addCheckoutMovie(Movie movie) {
        checkoutMovies.add(movie);
    }
}
