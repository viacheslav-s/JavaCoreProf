package ru.vyacheslav.javacoreprof.l6.task1;

import java.util.Arrays;

public class MainTask1 {

    public static int[] arrayTransform (int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == 4) {
                return Arrays.copyOfRange(array, i + 1, array.length);
            }
        }
        throw new RuntimeException("Неверный массив");
    }
}
