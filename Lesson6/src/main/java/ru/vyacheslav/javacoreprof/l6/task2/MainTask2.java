package ru.vyacheslav.javacoreprof.l6.task2;

import java.util.Arrays;

public class MainTask2 {
    public static boolean arrayCheck (int[] array) {
        boolean checkNumberFour = false;
        boolean checkNumberOne = false;
        for (int i :
                array) {
            if (i == 4) {
                checkNumberFour = true;
            }
            if (i == 1) {
                checkNumberOne = true;
            }
        }
        return checkNumberFour && checkNumberOne;
    }
}
