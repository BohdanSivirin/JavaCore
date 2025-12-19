package oop.multiTreading.basicSynhroTwo;

public class MyThread extends Thread {
    private final String name;
    private final int amount;
    private final Synhro s;

    public MyThread(String name, Synhro synhro, int amount) {
        this.name = name;
        this.amount = amount;
        this.s = synhro;
    }

    @Override
    public void run() {
        for (int i = 0; i < amount; i++) {
            s.print(name);
            try{
                sleep(500);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
