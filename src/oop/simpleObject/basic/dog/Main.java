package oop.simpleObject.basic.dog;

public class Main {
    public static void main(String[] args) {
        Dog sharik;
//        int a;
//        System.out.println(a);

        new Dog();
        System.out.println(new Dog());
        //System.out.println(a);
        sharik = new Dog();
        System.out.println("sharik = "+sharik);

        Dog bobik = new Dog();
        System.out.println("bobik = " + bobik);
        Dog tuzik = new Dog();
        System.out.println("tuzik = " + tuzik);
        tuzik = bobik;

        System.out.println();
        System.out.println("bobik = " + bobik);
        System.out.println("tuzik = " + tuzik);
        bobik = null;
       // tuzik = null;
        System.out.println();
        System.out.println("bobik = " + bobik);
        System.out.println("tuzik = " + tuzik);
        System.out.println("***** = " );

//        bobik.run(15);
        sharik.run(15);
        sharik.eat("pork", 1.240);
        sharik.info();

        bobik = new Dog();
        bobik.info();

        Dog polkan = new Dog(true, 3.500, "buldog", 1);
        System.out.println("polkan" + polkan);
         bobik = new Dog(false, 2.25, "tibet", 1);
        System.out.println("bobik" + bobik);
        System.out.println(" [[[ ");
//        polkan.info();
//        System.out.println(" ");
//        bobik.info();
//        Dog dog = new Dog()
        Dog murzik = new Dog(6.780, 8);
        murzik.info();
        System.out.println();
        Dog irina = new Dog();
        irina.info();
        double irinaWeight = irina.getWeight();
        System.out.println(irinaWeight);
        irina.setWeight(5.500);
        System.out.println();
        irina.info();
        irina.setBreed("american");
        irina.info();


    }
}
