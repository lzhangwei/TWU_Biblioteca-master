package com.twu.biblioteca;

import java.util.Scanner;

public class CheckoutProcessor implements KeyProcessor {
    @Override
    public void process(Controller controller) {
        System.out.print("Please input the book name:");
        Scanner in = new Scanner(System.in);
        String checkoutBookName = in.next();
        String response = controller.checkout(checkoutBookName);
        if (response.equals(Constant.ERROR)) {
            System.out.println("That book is not bailable.");
        }
    }
}
