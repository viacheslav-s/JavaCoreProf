package ru.vyacheslav.javacoreprof.l1.ex1;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String[] array = {"a", "b", "c", "d", "e"};
        try {
            elementsReplace(array, 0, 4);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Введенные значения выходят за пределы массива");
        }


    }

    private static <T> void elementsReplace(T[] array, int elementFirst, int elementSecond) {
        T temporary = array[elementSecond];
        array[elementSecond] = array[elementFirst];
        array[elementFirst] = temporary;
        System.out.println(Arrays.toString(array));
    }
}