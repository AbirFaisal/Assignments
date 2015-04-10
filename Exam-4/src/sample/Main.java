package sample;

import java.text.NumberFormat;

public class Main {



    public static void main(String[] args) {


        Runtime runtime = Runtime.getRuntime();

        NumberFormat format = NumberFormat.getInstance();

        StringBuilder sb = new StringBuilder();
        long maxMemory = runtime.maxMemory();
        long allocatedMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        int availableProcessors = runtime.availableProcessors();
        long totalMemory = runtime.totalMemory();



        System.out.println(availableProcessors);
        System.out.println(totalMemory/1024/1024);
        System.out.println(maxMemory/1024/1024);
        System.out.println(allocatedMemory/1024/1024);
        System.out.println(freeMemory/1024/1024);



    }
}
