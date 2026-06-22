package oop.multiTreading.basicSynhroTwo;

public class Main {
    public static void main(String[] args) {
        Synhro s = new Synhro();
        MyThread bmw = new MyThread("bmw", s, 3);
        MyThread audi = new MyThread("audi", s, 4);
        MyThread volkswagen = new MyThread("volkswagen", s, 2);

        bmw.start();
        audi.start();
        volkswagen.start();

        try {
            bmw.join();
            audi.join();
            volkswagen.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        s.close();
    }
}
