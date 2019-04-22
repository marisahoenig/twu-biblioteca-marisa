package com.twu.biblioteca;

import org.junit.Test;

public class MenuTests {

    // 1.4
//    @Test
//    public void ShouldReturnValidMenuInput() {
//        String inputString = "3";
//        Menu menu = new Menu();
//        menu.validateInput(inputString);
//    }

    @Test(expected = IllegalArgumentException.class)
    public void ShouldThrowIllegalArgWhenInvalidNumberEntered() {
        String inputString = "10000";
        Menu.validateInput(inputString);
    }
}
