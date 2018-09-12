package ru.vyacheslav.javacoreprof.l7.lesson7;

import ru.vyacheslav.javacoreprof.l7.lesson7.annotations.AfterSuite;
import ru.vyacheslav.javacoreprof.l7.lesson7.annotations.BeforeSuite;
import ru.vyacheslav.javacoreprof.l7.lesson7.annotations.Test;

public class Testing {
    @BeforeSuite
    public void prepare() {
        System.out.println("BEFORE");
    }

    @Test(priority = Test.Priority.LOWEST)
    public void test1() {
        System.out.println("last test");
    }

    @Test(priority = Test.Priority.MAX_PRIORITY)
    public void test2() {
        System.out.println("first test");
    }

    @Test(priority = Test.Priority.LOW)
    public void test3() {
        System.out.println("test 5");
    }

    @Test(priority = Test.Priority.HIGHEST)
    public void test4() {
        System.out.println("test 2");
    }

    @Test
    public void test5() {
        System.out.println("test 4: without priority");
    }

    @Test(priority = Test.Priority.HIGH)
    public void test6() {
        System.out.println("test 3");
    }

    @AfterSuite
    public void cleanUp() {
        System.out.println("AFTER");
    }
}
