package ru.vyacheslav.javacoreprof.l4.task3;

public class MFP {
    private final PrintFunction printFunction;
    private final ScanFunction scanFunction;

    MFP() {
        printFunction = new PrintFunction();
        scanFunction = new ScanFunction();
    }

    void print(String page){
        printFunction.print(page);
    }

    void scan(String page) {
        scanFunction.scanPage(page);
    }

    void shutdown (){
        printFunction.shutdown();
        scanFunction.shutdown();
        System.out.println("МФУ выключен!");
    }

}
