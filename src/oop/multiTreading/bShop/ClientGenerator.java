package oop.multiTreading.bShop;

import java.io.BufferedWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class ClientGenerator extends Thread {
    private final String name;
    private final BufferedWriter writer;
    private final BarberShop barberShop;
    //    private volatile static int allGeneratedClientsAmount;
    private static final AtomicInteger allGeneratedClientsAmount = new AtomicInteger(0);

    public ClientGenerator(BufferedWriter writer, BarberShop barberShop, String name) {
        this.writer = writer;
        this.barberShop = barberShop;
        this.name = name;
    }

    public void getStatistics() {
        try {
            System.out.println(LocalDateTime.now() + " " + Thread.currentThread().getName() + " Statistics >> all generated clients: " + allGeneratedClientsAmount.get() + "\n");
            writer.append("Statistics >> all generated clients: " + allGeneratedClientsAmount.get() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    @Override
//    public void run() {
//        while (true) {
//            try {
//                System.out.println("Generator # " + currentThread().getName() + " started working\n");
//                List<Client> clients = new ArrayList<>();
//                //System.out.println(Thread.currentThread().getName() + " Check clients.size before generating" + clients.size());
//                int generatedClients = new Random().nextInt(1, 4);
//                System.out.println(LocalDateTime.now() + " " + Thread.currentThread().getName() + "Generator # " + currentThread().getName() + " generate number of clients: " + generatedClients + "\n");
//
//                for (int i = 0; i < generatedClients; i++) {
//                    clients.add(new Client(new Random().nextLong(Long.MIN_VALUE, Long.MAX_VALUE)));
//                }
//                //System.out.println(Thread.currentThread().getName() + "Check clients.size after added generated clients -> " + clients.size() + "\n");
//
//                System.out.println(LocalDateTime.now() + " " + Thread.currentThread().getName() + "Value >> allGeneratedClientsAmount [before addAndGet(generatedClients)] : " + allGeneratedClientsAmount + "\n");
//                allGeneratedClientsAmount.addAndGet(generatedClients);
//                System.out.println(LocalDateTime.now() + " " + Thread.currentThread().getName() + "Value >> allGeneratedClientsAmount [after addAndGet(generatedClients)] : " + allGeneratedClientsAmount + "\n");
//
//                barberShop.add(clients);
//                System.out.println("Generator # " + currentThread().getName() + " finished working\n");
//                //System.out.println("Generator # " + currentThread().getName() + " add clients to Barber Shop\n ");
//                System.out.println("Generator # " + currentThread().getName() + " sleep\n ");
//                sleep(new Random().nextInt(1000, 3001));
//
//
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            //System.out.println(" -----------------------------------------------\n ");
//        }
//    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Generator # " + currentThread().getName() + " started working\n");
                List<Client> clients = new ArrayList<>();
                //System.out.println(Thread.currentThread().getName() + " Check clients.size before generating" + clients.size());
                int generatedClients = new Random().nextInt(1, 4);
                System.out.println(LocalDateTime.now() + " " + Thread.currentThread().getName() + "Generator # " + currentThread().getName() + " generate number of clients: " + generatedClients + "\n");

                for (int i = 0; i < generatedClients; i++) {
                    clients.add(new Client(new Random().nextLong(Long.MIN_VALUE, Long.MAX_VALUE)));
                }
                //System.out.println(Thread.currentThread().getName() + "Check clients.size after added generated clients -> " + clients.size() + "\n");

                System.out.println(LocalDateTime.now() + " " + Thread.currentThread().getName() + "Value >> allGeneratedClientsAmount [before addAndGet(generatedClients)] : " + allGeneratedClientsAmount + "\n");

                System.out.println(LocalDateTime.now() + " " + Thread.currentThread().getName() + "Value >> allGeneratedClientsAmount [after addAndGet(generatedClients)] : " + allGeneratedClientsAmount + "\n");

                int addedClients = barberShop.add(clients);
                allGeneratedClientsAmount.addAndGet(addedClients);
                System.out.println("Generator # " + currentThread().getName() + " finished working\n");
                //System.out.println("Generator # " + currentThread().getName() + " add clients to Barber Shop\n ");
                System.out.println("Generator # " + currentThread().getName() + " sleep\n ");
                sleep(new Random().nextInt(1000, 3001));


            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //System.out.println(" -----------------------------------------------\n ");
        }
    }
}
