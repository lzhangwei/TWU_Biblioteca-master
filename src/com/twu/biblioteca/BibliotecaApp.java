package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {

    {
        createBooks();
    }

    private List<Book> libraryBookList;
    private List<Book> currentBookList;

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.printWelcomeMessage();

        bibliotecaApp.printBookListTitle();

        bibliotecaApp.libraryBookList.forEach(BibliotecaApp::printBookInfo);

        bibliotecaApp.printSelectOptions();

        Scanner in = new Scanner(System.in);
        String input = "";
        do {
            input = in.next();
            switch (input) {
                case "LIST-BOOKS":
                    bibliotecaApp.currentBookList.forEach(BibliotecaApp::printBookInfo);
                    break;
                case "CHECK-OUT":
                    System.out.print("Please input the book name:");
                    String checkoutBookName = in.next();
                    if(bibliotecaApp.currentBookIsExist(checkoutBookName)) {
                        bibliotecaApp.checkoutBook(checkoutBookName);
                    } else {
                        System.out.println("That book is not bailable.");
                    }
                    break;
                case "RETURN":
                    System.out.print("Please input the book name:");
                    String returnBookName = in.next();
                    if(bibliotecaApp.bookIsExist(returnBookName)) {
                        bibliotecaApp.returnBook(returnBookName);
                    } else {
                        System.out.println("That book is not bailable.");
                    }
                    break;
                case "QUIT":
                    return;
                default:
                    System.out.println("Select a valid option!");
            }
        } while (!"QUIT".equals(input));
    }

    private boolean bookIsExist(String returnBookName) {
        for (Book book : libraryBookList) {
            if(book.getName().equals(returnBookName)) {
                return true;
            }
        }
        return false;
    }

    private boolean currentBookIsExist(String bookName) {
        for (Book book : currentBookList) {
            if(book.getName().equals(bookName)) {
                return true;
            }
        }
        return false;
    }

    private void checkoutBook(String checkoutBookName) {
        for (int i = 0; i < currentBookList.size(); i++) {
            if(checkoutBookName.equals(currentBookList.get(i).getName())) {
                currentBookList.remove(i);
                return;
            }
        }
    }

    private void returnBook(String returnBookName) {
        for (Book book : libraryBookList) {
            if(returnBookName.equals(book.getName())) {
                currentBookList.add(book);
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
        libraryBookList = new ArrayList<>();
        currentBookList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            libraryBookList.add(
                    BookBuilder.aBook()
                            .withName("BOOK" + i)
                            .withAuthor("AUTHOR" + i)
                            .withYearPublished("2015.09")
                            .build());
            currentBookList.add(
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
