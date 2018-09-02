package ru.vyacheslav.javacoreprof.l4.task3;

public class Main {
    public static void main(String[] args) {
        MFP mfp = new MFP();

        for (int i = 1; i < 51; i++) {
            mfp.print(Integer.toString(i));
            mfp.scan(Integer.toString(i));
        }
        mfp.shutdown();
    }
}
