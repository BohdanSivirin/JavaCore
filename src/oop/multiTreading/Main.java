package oop.multiTreading;

import oop.multiTreading.basic.PrintingThread;
import oop.multiTreading.basic.Timer;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Thread mainThread = Thread.currentThread();
        System.out.println(mainThread);
        mainThread.setName("vasya");
        mainThread.setPriority(3);
        System.out.println(mainThread);

        PrintingThread vasya = new PrintingThread("vasya", 10);
        PrintingThread ivan = new PrintingThread("ivan", 9);
        PrintingThread petr = new PrintingThread("petr", 10);
        vasya.start();
        ivan.start();
        petr.start();
        Timer timer = new Timer();
        Thread threadTimer = new Thread(timer);
        threadTimer.start();
        try {
            vasya.join();
            ivan.join();
            petr.join();
            threadTimer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main finished work");
    }
}
