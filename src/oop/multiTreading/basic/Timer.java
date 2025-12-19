package oop.multiTreading.basic;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Timer implements Runnable {

    @Override
    public void run() {
        SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");
        for (int i = 0; i < 10; i++) {
            Date date = new Date();
            System.out.println(format.format(date));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
