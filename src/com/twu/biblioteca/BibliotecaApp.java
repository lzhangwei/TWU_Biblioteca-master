package com.twu.biblioteca;

import com.twu.biblioteca.account.AccountController;
import com.twu.biblioteca.book.BookController;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        AccountController accountController = new AccountController();
        BookController bookController = new BookController(accountController);
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.printWelcomeMessage();

        bookController.printBookListTitle();
        bookController.getLibraryBookList().forEach(bookController::printBookInfo);
        bookController.printBookSelectOptions();

        Scanner in = new Scanner(System.in);
        String input = "";
        do {
            input = in.next();
            switch (input) {
                case "LIST-BOOKS":
                    bookController.getCurrentBookList().forEach(bookController::printBookInfo);
                    break;
                case "CHECK-OUT":
                    System.out.print("Please input the book name:");
                    String checkoutBookName = in.next();
                    if (bookController.currentBookIsExist(checkoutBookName)) {
                        bookController.checkoutBook(checkoutBookName);
                    } else {
                        System.out.println("That book is not bailable.");
                    }
                    break;
                case "RETURN":
                    System.out.print("Please input the book name:");
                    String returnBookName = in.next();
                    if (bookController.bookIsExist(returnBookName)) {
                        bookController.returnBook(returnBookName);
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

    private void printWelcomeMessage() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("*********************************************\n");
        stringBuilder.append("*                                           *\n");
        stringBuilder.append("*            Welcome Biblioteca!            *\n");
        stringBuilder.append("*                                           *\n");
        stringBuilder.append("*********************************************\n");
        System.out.println(stringBuilder);
    }
}
