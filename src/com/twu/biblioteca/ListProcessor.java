package com.twu.biblioteca;

public class ListProcessor implements KeyProcessor {
    @Override
    public void process(Controller controller) {
        controller.list();
    }
}
