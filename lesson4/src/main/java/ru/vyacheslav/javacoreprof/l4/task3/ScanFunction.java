package ru.vyacheslav.javacoreprof.l4.task3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ScanFunction {
    private final ExecutorService queue;

    public ScanFunction() {
        queue = Executors.newSingleThreadExecutor();
        System.out.println("МФУ ожидает сканирования");
    }

    void scanPage(String page) {
        queue.submit(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (InterruptedException e) {
                System.out.println("Ошибка сканирования");
            }
            System.out.println("Страница " + page +  " отсканирована");
        });
    }

    void shutdown() {
        queue.shutdown();
        try {
            queue.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.out.println("Ошибка сканирования");
        } finally {
            if (!queue.isTerminated()) {
                System.out.println("Отмена сканирования");
            }
            queue.shutdownNow();
        }
    }
}
