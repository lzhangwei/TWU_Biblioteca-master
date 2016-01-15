package com.twu.biblioteca;

import java.util.Scanner;

public class ReturnProcessor implements KeyProcessor {
    @Override
    public void process(Controller controller) {
        Scanner in = new Scanner(System.in);
        System.out.print("Please input the book name:");
        String returnName = in.next();
        String response = controller.returning(returnName);
        if(response.equals(Constant.ERROR)) {
            System.out.println("That book is not bailable.");
        }
    }
}
