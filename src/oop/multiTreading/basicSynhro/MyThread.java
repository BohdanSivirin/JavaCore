package oop.multiTreading.basicSynhro;

public class MyThread extends Thread {
    private final String name;
    private final int amount;
    private final Synhro s;

    public MyThread(String name, int amount, Synhro synhro) {
        this.name = name;
        this.amount = amount;
        this.s = synhro;
    }

    @Override
    public void run() {
        synchronized (s){
            for (int i = 0; i < amount; i++) {
                s.print("#: " + (i + 1) + " name: " + name);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                s.print(" -> " + (i + 1) + " name: " + name + "\n");
            }
        }
    }



}
