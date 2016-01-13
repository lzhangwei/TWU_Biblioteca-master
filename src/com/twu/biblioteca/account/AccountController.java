package com.twu.biblioteca.account;

import com.twu.biblioteca.book.Book;
import com.twu.biblioteca.movie.Movie;

import java.util.ArrayList;
import java.util.List;

public class AccountController {
    {
        createRegistedAccount();
    }

    private List<Account> registeredAccountList = new ArrayList<>();

    private Account loginAccount;

    private void createRegistedAccount() {
        for (int i = 0; i < 10; i++) {
            registeredAccountList.add(new Account(
                    User.UserBuilder.anUser().withName("USER" + i)
                            .withEmail("EMAIL" + i)
                            .withPhone("PHONE" + i)
                            .withLibraryNumber("111-111" + i)
                            .build(), "password" + i
            ));
        }
    }

    public Account getLoginAccount() {
        return loginAccount;
    }

    public String login(String libraryNumber, String password) {
        for (Account account : registeredAccountList) {
            if (libraryNumber.equals(account.getUser().getLibraryNumber()) && password.equals(account.getPassword())) {
                loginAccount = account;
                return "Login Success";
            }
        }
        return "Login Error";
    }

    public void addCheckoutBook(Book book) {
        loginAccount.addCheckoutBook(book);
    }

    public void addCheckoutMovie(Movie movie) {
        loginAccount.addCheckoutMovie(movie);
    }
}
