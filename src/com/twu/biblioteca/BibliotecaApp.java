package com.twu.biblioteca;

import com.twu.biblioteca.account.AccountController;
import com.twu.biblioteca.book.BookController;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        AccountController accountController = new AccountController();
        BookController bookController = new BookController(accountController);
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.printWelcomeMessage();

        Scanner in = new Scanner(System.in);

        System.out.println("Please login!");
        System.out.print("Please input the library number & password:");
        String loginResult = accountController.login(in.nextLine(), in.nextLine());
        while (loginResult.equals(Constant.ERROR)) {
            System.out.println("The library number or password is error,please input again!");
            loginResult = accountController.login(in.nextLine(), in.nextLine());
        }

        System.out.println("Login success!");

        bookController.printBookListTitle();
        bookController.getLibraryBookList().forEach(bookController::printBookInfo);
        bookController.printBookSelectOptions();

        Map<String, KeyProcessor> processorMap = createProcessorMap();

        String input = in.next();
        while (!"QUIT".equals(input)) {
            processorMap.get(input).process(bookController);
            input = in.next();
        }
    }

    private static Map<String, KeyProcessor> createProcessorMap() {
        Map<String, KeyProcessor> processorMap = new HashMap<>();
        processorMap.put("LIST", new ListProcessor());
        processorMap.put("CHECK-OUT", new CheckoutProcessor());
        processorMap.put("RETURN", new ReturnProcessor());
        return processorMap;
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
