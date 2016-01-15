package com.twu.biblioteca;

public interface Controller {
    void list();
    String checkout(String checkoutName);
    String returning(String returnName);
}
