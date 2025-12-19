package oop.multiTreading.basic;

public class PrintingThread extends Thread {
    private String name;
    private int amount;

    public PrintingThread(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    @Override
    public void run() {
        for (int i = 0; i < amount; i++) {
            System.out.println("#: " + (i+1) + " thread name: " + name);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
