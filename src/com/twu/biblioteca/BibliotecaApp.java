package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {

    {
        createBooks();
    }

    private List<Book> bookList;

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.printWelcomeMessage();

        bibliotecaApp.printBookListTitle();

        bibliotecaApp.bookList.forEach(book -> {
            printBookInfo(book);
        });

        bibliotecaApp.printSelectOptions();
    }

    private void printWelcomeMessage() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("*********************************************\n");
        stringBuilder.append("*                                           *\n");
        stringBuilder.append("*            Welcome Biblioteca!            *\n");
        stringBuilder.append("*                                           *\n");
        stringBuilder.append("*********************************************\n");
        System.out.println(stringBuilder);
    }

    private void printBookListTitle() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n");
        stringBuilder.append("=============================================\n");
        stringBuilder.append("                    Books                    \n");
        stringBuilder.append("=============================================\n");
        System.out.println(stringBuilder);
    }

    private void printSelectOptions() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n");
        stringBuilder.append("1. If you want list books,please enter `LIST-BOOKS`!\n");
        stringBuilder.append("2. If you want check out a book,please enter `CHECK-OUT`!\n");
        stringBuilder.append("3. If you want return book,please enter `RETURN`!\n");
        stringBuilder.append("4. If you want quit,please enter `QUIT`!\n");
        stringBuilder.append("\n");
        System.out.println(stringBuilder);
    }

    private void createBooks() {
        bookList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            bookList.add(
                    BookBuilder.aBook()
                            .withName("BOOK" + i)
                            .withAuthor("AUTHOR" + i)
                            .withYearPublished("2015.09")
                            .build());
        }
    }

    private static void printBookInfo(Book book) {
        System.out.println(String.format("     %s   %s   %s", book.getName(), book.getAuthor(), book.getYearPublished()));
    }
}
