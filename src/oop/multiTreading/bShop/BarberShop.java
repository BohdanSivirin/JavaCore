package oop.multiTreading.bShop;

import java.io.BufferedWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class BarberShop {
    private final Terminator terminator;
    private final Queue queue;
    private final ArrayList<Barber> barbers;
    private final BufferedWriter writer;
    //    private volatile static int clientsLeftDueToLackOfSpace;
//    private volatile static int clientsLeftDueToTimeOut; //3
//    private volatile static int clientsLeftDueToJobDone;
    private final AtomicInteger clientsLeftDueToLackOfSpace = new AtomicInteger(0);
    private final AtomicInteger clientsLeftDueToTimeOut = new AtomicInteger(0);
    private final AtomicInteger clientsLeftDueToJobDone = new AtomicInteger(0);

    public BarberShop(int barbersValue, BufferedWriter writer) {
        terminator = new Terminator();
        queue = new Queue();
        barbers = new ArrayList<>();
        this.writer = writer;
        while (barbersValue > 0) {
            barbers.add(new Barber());
            barbersValue--;
        }
//        int numberOfBarbers = 1;
//        while (numberOfBarbers > 0) {
//            barbers.add(new Barber());
//            numberOfBarbers--;
//        }
    }

    public void getStatistics() {
        try {
            System.out.println("All clients left -> [lack of space]: " + clientsLeftDueToLackOfSpace.get() + "\n");
            writer.append("All clients left -> [lack of space]: " + clientsLeftDueToLackOfSpace.get() + "\n");
            System.out.println("All clients left -> [time out]: " + clientsLeftDueToTimeOut.get() + "\n");
            writer.append("All clients left -> [time out]: " + clientsLeftDueToTimeOut.get() + "\n");
            System.out.println("All clients left -> [job done]: " + clientsLeftDueToJobDone.get() + "\n");
            writer.append("All clients left -> [job done]: " + clientsLeftDueToJobDone.get() + "\n");
            int all = clientsLeftDueToLackOfSpace.get() + clientsLeftDueToTimeOut.get() + clientsLeftDueToJobDone.get() + queue.queueSize();
            System.out.println("Clients in a queue " + queue.queueSize() + "\n");
            System.out.println("All: -> [[ " + all + " ]] \n");
//            Barber.statistics();
            for (Barber barber : barbers) {
                barber.getStatistic();
            }
        } catch (IOException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void work() {
        for (Barber barber : barbers) {
            barber.setDaemon(true);
            barber.start();
        }
        terminator.setDaemon(true);
        terminator.start();
    }

//    public void add(List<Client> clients) {
//        queue.add(clients);
//    }
public int add(List<Client> clients) {
    return queue.add(clients);
}

    private class Terminator extends Thread {
        public void run() {
            while (true) {
                try {
                    System.out.println("Terminator # " + currentThread().getName() + " started working\n");
                    queue.terminate();
                    System.out.println("Terminator # " + currentThread().getName() + " finished working\n");
                    System.out.println("Terminator # " + currentThread().getName() + " sleep \n");
                    sleep(2001);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

            }
        }
    }

    private class Queue {
        private final List<Client> queue = Collections.synchronizedList(new ArrayList<>());
        private final int size = 5;

        public int queueSize(){
            return queue.size();
        }

        public synchronized void terminate() {
            System.out.println(LocalDateTime.now() + " " + Thread.currentThread().getName() + "terminate method start : queue.size() is " + queue.size() + "\n");
            try {
                while (queue.isEmpty()) {
                    wait();
                }
                for (int i = queue.size() - 1; i >= 0; i--) {
                    long clientTimeDiff = System.currentTimeMillis() - queue.get(i).getStartTime();
                    System.out.println(LocalDateTime.now() + " " + Thread.currentThread().getName() + "Queue >> check current clientTimeDiff: " + clientTimeDiff + "\n");
                    if (clientTimeDiff >= 3000) {
                        Client c = queue.remove(i);
                        System.out.println(LocalDateTime.now() + " " + Thread.currentThread().getName() + "Queue >> remove this client due to clientTimeDiff: " + c + "\n");
                        System.out.println(LocalDateTime.now() + " " + Thread.currentThread().getName() + "queue.size() after removing client is - " + queue.size() + "\n");

                        System.out.println(LocalDateTime.now() + " " + Thread.currentThread().getName() + "Value >> clientsLeftDueToTimeOut [before incrementAndGet] : " + clientsLeftDueToTimeOut + "\n");
                        clientsLeftDueToTimeOut.incrementAndGet();
                        System.out.println(LocalDateTime.now() + " " + Thread.currentThread().getName() + "Value >> clientsLeftDueToTimeOut [after incrementAndGet] : " + clientsLeftDueToTimeOut + "\n");
                    }
                }
                System.out.println(LocalDateTime.now() + " " + Thread.currentThread().getName() + "terminate method end : queue.size() is " + queue.size() + "\n");
                notifyAll();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }


        }

//        private synchronized void add(List<Client> clients) {
//            //System.out.println(Thread.currentThread().getName() + "add method start : queue.size() is " + queue.size() + "\n");
//            //System.out.println(Thread.currentThread().getName() + "check input method value size >> List<Client> clients : " + clients.size() + "\n");
//            try {
////                while (queue.size() == size) {
////                    wait();
////                }
//                //System.out.println(Thread.currentThread().getName() + "encrypt == if (clients.size() <= size - queue.size()) >> \n ");
//                //System.out.println(Thread.currentThread().getName() + "decrypt == clients.size(): " + clients.size() + " <= size: " + size + " - " + " queue.size() " + queue.size() + "\n");
//                if (clients.size() <= size - queue.size()) {
//                    queue.addAll(clients);
//                }
//                else if (size - queue.size() > 0) {
//                    int emptySpace = size - queue.size();
//                    System.out.println(LocalDateTime.now() + " " + Thread.currentThread().getName() + " queue size " + queue.size() + "\n");
//                    System.out.println(LocalDateTime.now() + " " + Thread.currentThread().getName() + " empty space : " + emptySpace + "\n");
//                    for (int i = 0; i < emptySpace; i++) {
//                        if (clients.get(i) != null) {
//                            queue.add(clients.get(i));
//                        }
//                    }
//
//                    // System.out.println(Thread.currentThread().getName() + "Value >> clientsLeftDueToLackOfSpace [before addAndGet(clients.size() - emptySpace)] : " + clientsLeftDueToLackOfSpace + "\n");
//                    System.out.println(LocalDateTime.now() + " " + Thread.currentThread().getName() + " clientsLeftDueToLackOfSpace [before addAndGet(clients.size() - emptySpace)] : " + clientsLeftDueToLackOfSpace + "\n");
//                    //System.out.println(Thread.currentThread().getName() + "decrypt == clients.size(): " + clients.size() + " - empty space: " + emptySpace + "\n");
//                    clientsLeftDueToLackOfSpace.addAndGet(clients.size() - emptySpace);
//                    System.out.println(LocalDateTime.now() + " " + Thread.currentThread().getName() + " clientsLeftDueToLackOfSpace [after addAndGet(clients.size() - emptySpace)] : " + clientsLeftDueToLackOfSpace + "\n");
//                    // System.out.println(Thread.currentThread().getName() + "Value >> clientsLeftDueToLackOfSpace [after addAndGet(clients.size() - emptySpace)] : " + clientsLeftDueToLackOfSpace + "\n");
//
//                } else {
//                    System.out.println(LocalDateTime.now() + " " + Thread.currentThread().getName() + " clientsLeftDueToLackOfSpace [before addAndGet(clients.size())] : " + clientsLeftDueToLackOfSpace + "\n");
//                    clientsLeftDueToLackOfSpace.addAndGet(clients.size());
//                    System.out.println(LocalDateTime.now() + " " + Thread.currentThread().getName() + " clientsLeftDueToLackOfSpace [after addAndGet(clients.size())] : " + clientsLeftDueToLackOfSpace + "\n");
//
//                }
//                clients.clear();
//                notifyAll();
//                System.out.println(LocalDateTime.now() + " " + Thread.currentThread().getName() + "add method end : queue.size() is " + queue.size() + "\n");
//            } catch (Exception e) {
//                Thread.currentThread().interrupt();
//            }
//
//
//        }

        private synchronized int add(List<Client> clients) {
            //System.out.println(Thread.currentThread().getName() + "add method start : queue.size() is " + queue.size() + "\n");
            //System.out.println(Thread.currentThread().getName() + "check input method value size >> List<Client> clients : " + clients.size() + "\n");
            int clietnsSize = clients.size();
            try {
                while (queue.size() == size) {
                    wait();
                }
                //System.out.println(Thread.currentThread().getName() + "encrypt == if (clients.size() <= size - queue.size()) >> \n ");
                //System.out.println(Thread.currentThread().getName() + "decrypt == clients.size(): " + clients.size() + " <= size: " + size + " - " + " queue.size() " + queue.size() + "\n");
                if (clients.size() <= size - queue.size()) {
                    queue.addAll(clients);
                }
                else {
                    int emptySpace = size - queue.size();
                    System.out.println(LocalDateTime.now() + " " + Thread.currentThread().getName() + " queue size " + queue.size() + "\n");
                    System.out.println(LocalDateTime.now() + " " + Thread.currentThread().getName() + " empty space : " + emptySpace + "\n");
                    for (int i = 0; i < emptySpace; i++) {
                        if (clients.get(i) != null) {
                            queue.add(clients.get(i));
                        }
                    }

                    // System.out.println(Thread.currentThread().getName() + "Value >> clientsLeftDueToLackOfSpace [before addAndGet(clients.size() - emptySpace)] : " + clientsLeftDueToLackOfSpace + "\n");
                    System.out.println(LocalDateTime.now() + " " + Thread.currentThread().getName() + " clientsLeftDueToLackOfSpace [before addAndGet(clients.size() - emptySpace)] : " + clientsLeftDueToLackOfSpace + "\n");
                    //System.out.println(Thread.currentThread().getName() + "decrypt == clients.size(): " + clients.size() + " - empty space: " + emptySpace + "\n");
                    clientsLeftDueToLackOfSpace.addAndGet(clients.size() - emptySpace);
                    System.out.println(LocalDateTime.now() + " " + Thread.currentThread().getName() + " clientsLeftDueToLackOfSpace [after addAndGet(clients.size() - emptySpace)] : " + clientsLeftDueToLackOfSpace + "\n");
                    // System.out.println(Thread.currentThread().getName() + "Value >> clientsLeftDueToLackOfSpace [after addAndGet(clients.size() - emptySpace)] : " + clientsLeftDueToLackOfSpace + "\n");

                }
                clients.clear();
                notifyAll();
                System.out.println(LocalDateTime.now() + " " + Thread.currentThread().getName() + "add method end : queue.size() is " + queue.size() + "\n");
            } catch (Exception e) {
                Thread.currentThread().interrupt();
            }
            return clietnsSize;


        }

        private synchronized Client getClientFromTheQueueToBarber() {
            try {
                while (queue.isEmpty()) {
                    wait();
                }
                System.out.println(LocalDateTime.now() + " " + Thread.currentThread().getName() + " queue size before removing client to barber " + queue.size() + " \n");
                Client c = queue.remove(0);
                System.out.println(LocalDateTime.now() + " " + Thread.currentThread().getName() + " queue size after removing client to barber " + queue.size() + " \n");
                notifyAll();
                return c;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return null;
        }
    }

    private class Barber extends Thread {
        private String name;
        private static final AtomicInteger allTimes = new AtomicInteger(0);
        private static final AtomicInteger clientsServed = new AtomicInteger(0);
        private int clientsServedPerBarber = 0;

        static void statistics() {
            int avgVelocity = (clientsServed.get() > 0) ? allTimes.get() / clientsServed.get() : 0;
            System.out.println("Barber - " + currentThread().getName() + " average velocity is: " + avgVelocity + "\n");
            System.out.println("Barber - " + currentThread().getName() + " served clients " + clientsServed + "\n");
        }

        @Override
        public void run() {
            while (true) {
                try {
                    for (int i = 0; i < barbers.size(); i++) {
                        this.name = "Barber set name: " + i + "\n";
                    }
                    System.out.println("Barber # " + currentThread().getName() + " started working\n");

                    int velocity = new Random().nextInt(1, 5);
                    //System.out.println("Barber # " + currentThread().getName() + " working velocity " + velocity + "\n");

                    Client current = queue.getClientFromTheQueueToBarber();
                    System.out.println("Barber # " + currentThread().getName() + " current working client ID - " + current + "\n");

                    if (current != null) {
                        System.out.println(LocalDateTime.now() + " " + Thread.currentThread().getName() + "Value >> clientsLeftDueToJobDone [before incrementAndGet] : " + clientsLeftDueToJobDone + "\n");
                        clientsLeftDueToJobDone.incrementAndGet();
                        System.out.println(LocalDateTime.now() + " " + Thread.currentThread().getName() + "Value >> clientsLeftDueToJobDone [after incrementAndGet] : " + clientsLeftDueToJobDone + "\n");

                        System.out.println(LocalDateTime.now() + " " + Thread.currentThread().getName() + "Value >> clientsServed [before incrementAndGet] : " + clientsServed + "\n");
                        clientsServed.incrementAndGet();
                        System.out.println(LocalDateTime.now() + " " + Thread.currentThread().getName() + "Value >> clientsServed [after incrementAndGet] : " + clientsServed + "\n");

                        System.out.println(LocalDateTime.now() + " " + Thread.currentThread().getName() + "Value >> allTimes [before addAndGet(velocity)] : " + allTimes + "\n");
                        allTimes.addAndGet(velocity);
                        System.out.println(LocalDateTime.now() + " " + Thread.currentThread().getName() + "Value >> allTimes [after addAndGet(velocity)] : " + allTimes + "\n");
                        clientsServedPerBarber++;
                        System.out.println("Barber # " + currentThread().getName() + " finished working\n");
                        System.out.println("Barber # " + currentThread().getName() + " sleep time after working with client - " + velocity * 1000L + "\n");
                        sleep(velocity * 1000L);

                    } else System.out.println(LocalDateTime.now() + " " + Thread.currentThread().getName() + " Client null ");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                //System.out.println(" -----------------------------------------------\n ");
            }
        }

        public void getStatistic() {
            System.out.println(LocalDateTime.now() + " " + Thread.currentThread().getName() + " total time spend " + allTimes);
            System.out.println(LocalDateTime.now() + " " + Thread.currentThread().getName() + " total customers served " + clientsServed);
            System.out.println(LocalDateTime.now() + " " + Thread.currentThread().getName() + " total customers served per barber" + clientsServedPerBarber);
        }
    }
}
