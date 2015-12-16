package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {

    private List<Book> bookList = new ArrayList<>();

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.printWelcomeMessage();

        bibliotecaApp.printBookListTitle();

        bibliotecaApp.createBooks();
        bibliotecaApp.bookList.forEach(book -> {
            printBookInfo(book);
        });
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

    private void createBooks() {
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
