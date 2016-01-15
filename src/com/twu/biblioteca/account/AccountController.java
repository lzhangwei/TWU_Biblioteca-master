package com.twu.biblioteca.account;

import com.twu.biblioteca.Constant;
import com.twu.biblioteca.Controller;
import com.twu.biblioteca.book.Book;
import com.twu.biblioteca.movie.Movie;

import java.util.ArrayList;
import java.util.List;

public class AccountController {
    {
        createRegistedAccount();
    }

    private List<Account> registeredAccountList;

    private Account loginAccount;

    private void createRegistedAccount() {
        registeredAccountList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            registeredAccountList.add(
                    new Account(new User("111-111" + i, "USER" + i, "EMAIL" + i, "PHONE" + i), "password" + i
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
                return Constant.SUCCESS;
            }
        }
        return Constant.ERROR;
    }

    public void addCheckoutBook(Book book) {
        loginAccount.addCheckoutBook(book);
    }

    public void addCheckoutMovie(Movie movie) {
        loginAccount.addCheckoutMovie(movie);
    }
}
