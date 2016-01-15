package com.twu.biblioteca.book;

import com.twu.biblioteca.account.AccountController;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookControllerTest {

    BookController bookController;
    AccountController accountController;

    @Before
    public void init() {
        accountController = new AccountController();
        bookController = new BookController(accountController);
    }

    @Test
    public void should_return_true_when_book_name_is_exist() {
        assertEquals(true, bookController.bookIsExist("BOOK1"));
    }

    @Test
    public void should_return_false_when_book_name_is_not_exist() {
        assertEquals(false, bookController.bookIsExist("BOOK"));
    }

    @Test
    public void should_return_success_when_checkout_book_is_in_current_book_list() {
        accountController.login("111-1111", "password1");
        String result = bookController.checkout("BOOK1");
        assertEquals(result, "SUCCESS");
    }

    @Test
    public void should_return_error_when_checkout_book_is_not_in_current_book_list() {
        accountController.login("111-1111", "password1");
        String result = bookController.checkout("BOOK");
        assertEquals(result, "ERROR");
    }

    @Test
    public void book_list_size_should_be_9_when_checkout_one_book() {
        accountController.login("111-1111", "password1");
        bookController.checkout("BOOK1");
        assertEquals(9, bookController.getCurrentBookList().size());
    }

    @Test
    public void should_return_success_when_return_book_is_in_book_list() {
        accountController.login("111-1111", "password1");
        String result = bookController.returning("BOOK1");
        assertEquals(result, "SUCCESS");
    }

    @Test
    public void should_return_error_when_return_book_is_not_in_book_list() {
        accountController.login("111-1111", "password1");
        String result = bookController.checkout("BOOK");
        assertEquals(result, "ERROR");
    }

    @Test
    public void book_list_size_should_be_10_when_return_one_book() {
        bookController.returning("BOOK1");
        assertEquals(11, bookController.getCurrentBookList().size());
    }

}