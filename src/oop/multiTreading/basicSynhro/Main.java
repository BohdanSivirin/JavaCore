package oop.multiTreading.basicSynhro;

public class Main {
    public static void main(String[] args) {
        Synhro synhro = new Synhro();
        MyThread vassal = new MyThread("vassal", 10, synhro);
        MyThread ivan = new MyThread("ivan", 11, synhro);
        MyThread petr = new MyThread("petr", 9, synhro);
        vassal.start();
        ivan.start();
        petr.start();
        try {
            vassal.join();
            ivan.join();
            petr.join();
        } catch (InterruptedException e){
           e.printStackTrace();
        }
        synhro.close();
    }
}
