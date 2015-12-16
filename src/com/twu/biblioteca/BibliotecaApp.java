package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.printWelcomeMessage();
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
