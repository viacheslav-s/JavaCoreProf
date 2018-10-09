package ru.vyacheslav.javacoreprof.l4.task2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try (BufferedWriter bf = new BufferedWriter(new FileWriter("task2.txt"))) {
            Thread firstThread = new Thread(() -> {
                try {
                    fileWriter(bf,"First thread\n");
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            });
            Thread secondThread = new Thread(() -> {
                try {
                    fileWriter(bf,"Second thread\n");
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            });
            Thread thirdThread = new Thread(() -> {
                try {
                    fileWriter(bf,"Third thread\n");
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            });

            firstThread.start();
            secondThread.start();
            thirdThread.start();
            firstThread.join();
            secondThread.join();
            thirdThread.join();
            bf.flush();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void fileWriter(BufferedWriter stream, String string) throws IOException, InterruptedException {
        for (int i = 0; i < 10; i++) {
            stream.write(string);
            Thread.sleep(20);
        }
    }
}
