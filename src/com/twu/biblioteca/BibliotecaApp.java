package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

        Scanner in = new Scanner(System.in);
        String input = "";
        do {
            input = in.next();
            switch (input) {
                case "LIST-BOOKS":
                    bibliotecaApp.bookList.forEach(book -> {
                        printBookInfo(book);
                    });
                    break;
                case "CHECK-OUT":
                    System.out.print("Please input the book name:");
                    String bookName = in.next();
                    if(bibliotecaApp.bookIsExist(bookName)) {
                        bibliotecaApp.checkoutBook(bookName);
                    } else {
                        System.out.println("That book is not bailable.");
                    }
                    break;
                case "RETURN":
                    break;
                case "QUIT":
                    return;
            }
        } while (!"QUIT".equals(input));
    }

    private boolean bookIsExist(String bookName) {
        for (Book book : bookList) {
            if(book.getName().equals(bookName)) {
                return true;
            }
        }
        return false;
    }

    private void checkoutBook(String bookName) {
        for (int i = 0; i < bookList.size(); i++) {
            if(bookName.equals(bookList.get(i).getName())) {
                bookList.remove(i);
                return;
            }
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
