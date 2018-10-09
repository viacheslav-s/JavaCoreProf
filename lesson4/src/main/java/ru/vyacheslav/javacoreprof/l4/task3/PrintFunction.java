package ru.vyacheslav.javacoreprof.l4.task3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PrintFunction {
    private final ExecutorService queue;

    PrintFunction() {
        queue = Executors.newSingleThreadExecutor();
        System.out.println("МФУ готов к печати");
    }

    void print(String page) {
        queue.submit(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (InterruptedException e) {
                System.out.println("Ошибка печати");
            }
            System.out.println("Страница " + page +  " отпечатана");
        });
    }

    void shutdown() {
        queue.shutdown();
        try {
            queue.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.out.println("Ошибка печати");
        } finally {
            if (!queue.isTerminated()) {
                System.out.println("Отмена печати");
            }
            queue.shutdownNow();
        }
    }
}
