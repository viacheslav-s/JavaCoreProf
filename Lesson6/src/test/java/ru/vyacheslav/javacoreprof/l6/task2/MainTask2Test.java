package ru.vyacheslav.javacoreprof.l6.task2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTask2Test {

    private MainTask2 task2;

    @BeforeEach
    void setUp() { task2 = new MainTask2(); }

    @Test
    void number_4_and_1_array() {
        final int[] array = {4, 1, 1, 1, 4};
        Assertions.assertTrue(task2.arrayCheck(array));
    }

    @Test
    void number_4_and_1_and_other_array() {
        final int[] array = {4, 1, 3, 5, 4, 8, 10};
        Assertions.assertTrue(task2.arrayCheck(array));
    }

    @Test
    void number_4_only_array() {
        final int[] array = {4, 4, 4, 4, 4};
        Assertions.assertFalse(task2.arrayCheck(array));
    }

    @Test
    void number_1_only_array() {
        final int[] array = {1, 1, 1, 1, 1};
        Assertions.assertFalse(task2.arrayCheck(array));
    }

    @Test
    void array_empty() {
        final int[] array = {};
        Assertions.assertFalse(task2.arrayCheck(array));
    }

}