package ru.vyacheslav.javacoreprof.l1.ex1;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String[] array = {"a", "b", "c", "d", "e"};
        elementsReplace(array, 0, 4);

    }

    private static <T> void elementsReplace(T[] array, int elementFirst, int elementSecond) {
        T temporary = array[elementSecond];
        array[elementSecond] = array[elementFirst];
        array[elementFirst] = temporary;
        System.out.println(Arrays.toString(array));
    }
}