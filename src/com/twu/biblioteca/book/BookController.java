package com.twu.biblioteca.book;

import com.twu.biblioteca.account.AccountController;

import java.util.ArrayList;
import java.util.List;

public class BookController {

    {
        createBooks();
    }

    private List<Book> libraryBookList;
    private List<Book> currentBookList;
    private AccountController accountController;

    private void createBooks() {
        libraryBookList = new ArrayList<>();
        currentBookList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            libraryBookList.add(
                    Book.BookBuilder.aBook()
                            .withName("BOOK" + i)
                            .withAuthor("AUTHOR" + i)
                            .withYearPublished("2015.09")
                            .build());
            currentBookList.add(
                    Book.BookBuilder.aBook()
                            .withName("BOOK" + i)
                            .withAuthor("AUTHOR" + i)
                            .withYearPublished("2015.09")
                            .build());
        }
    }

    public BookController(AccountController accountController) {
        this.accountController = accountController;
    }

    public List<Book> getLibraryBookList() {
        return libraryBookList;
    }

    public List<Book> getCurrentBookList() {
        return currentBookList;
    }

    public void printBookListTitle() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n");
        stringBuilder.append("=============================================\n");
        stringBuilder.append("                    Books                    \n");
        stringBuilder.append("=============================================\n");
        System.out.println(stringBuilder);
    }

    public void printBookSelectOptions() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n");
        stringBuilder.append("1. If you want list books,please enter `LIST-BOOKS`!\n");
        stringBuilder.append("2. If you want check out a book,please enter `CHECK-OUT`!\n");
        stringBuilder.append("3. If you want return book,please enter `RETURN`!\n");
        stringBuilder.append("4. If you want quit,please enter `QUIT`!\n");
        stringBuilder.append("\n");
        System.out.println(stringBuilder);
    }

    public boolean bookIsExist(String returnBookName) {
        for (Book book : libraryBookList) {
            if (book.getName().equals(returnBookName)) {
                return true;
            }
        }
        return false;
    }

    public boolean currentBookIsExist(String bookName) {
        for (Book book : currentBookList) {
            if (book.getName().equals(bookName)) {
                return true;
            }
        }
        return false;
    }

    public void checkoutBook(String checkoutBookName) {
        for (int i = 0; i < currentBookList.size(); i++) {
            if (checkoutBookName.equals(currentBookList.get(i).getName())) {
                accountController.addCheckoutBook(currentBookList.get(i));
                currentBookList.remove(i);
                return;
            }
        }
    }

    public void returnBook(String returnBookName) {
        for (Book book : libraryBookList) {
            if (returnBookName.equals(book.getName())) {
                currentBookList.add(book);
                return;
            }
        }
    }

    public void printBookInfo(Book book) {
        System.out.println(String.format("     %s   %s   %s", book.getName(), book.getAuthor(), book.getYearPublished()));
    }
}
