package sample;

import sun.plugin2.gluegen.runtime.CPU;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryType;
import java.lang.management.OperatingSystemMXBean;
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


        OperatingSystemMXBean beans = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);



        System.out.println(beans.getArch());
        System.out.println(beans.getAvailableProcessors());
        System.out.println(beans.getName());
        System.out.println(beans.getSystemLoadAverage());
        System.out.println(beans.getVersion() + "\n");

        System.out.println(beans.getName() + " " + beans.getVersion());
        System.out.println(beans.getAvailableProcessors() + " CPUs");







        System.out.println(memory[1]);



    }
}
