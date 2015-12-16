package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {

    private List<Book> bookList = new ArrayList<Book>();

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.printWelcomeMessage();

        bibliotecaApp.printBookListTitle();

        bibliotecaApp.createBooks();
        bibliotecaApp.bookList.forEach(book -> System.out.println(book.getName()));
    }

    private void createBooks() {
        for (int i = 0; i < 10; i++) {
            bookList.add(
                    BookBuilder.aBook()
                            .withName("BOOK" + i)
                            .build());
        }
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
}
