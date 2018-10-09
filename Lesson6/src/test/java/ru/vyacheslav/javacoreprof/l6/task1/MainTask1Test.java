package ru.vyacheslav.javacoreprof.l6.task1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MainTask1Test {

    private MainTask1 task1;

    @org.junit.jupiter.api.BeforeEach
    void setUp() { task1 = new MainTask1(); }

    @Test
    void number_4_array_starts() {
        final int[] array = {4, 2, 3, 1, 2, 3, 1};
        Assertions.assertArrayEquals(new int[] {2, 3, 1, 2, 3, 1}, task1.arrayTransform(array));
    }

    @Test
    void number_4_array_middle() {
        final int[] array = {1, 4, 1, 4, 1, 1, 1};
        Assertions.assertArrayEquals(new int[] {1, 1, 1}, task1.arrayTransform(array));
    }

    @Test
    void number_4_array_end() {
        final int[] array = {1, 4, 1, 4, 1, 1, 4};
        Assertions.assertArrayEquals(new int[] {}, task1.arrayTransform(array));
    }

    @Test
    void number_4_without() {
        final int[] array = {1, 1, 1, 2, 1, 1, 5};
        Assertions.assertThrows(RuntimeException.class, () -> {
            task1.arrayTransform(array);
        });
    }

    @Test
    void array_empty() {
        final int[] array = {};
        Assertions.assertThrows(RuntimeException.class, () -> {
            task1.arrayTransform(array);
        });
    }

}