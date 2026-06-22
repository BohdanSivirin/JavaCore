package oop.complex.phone;

import java.util.Scanner;

public class Phone {
    private boolean isOn;
    private SimCard[] simCards = new SimCard[2];
    private Display display;
    private Accumulator accumulator;
    private int activeSim = -1;
    private Scanner scanner = new Scanner(System.in);

    public Phone() {
        display = new Display();
        accumulator = new Accumulator(45);
    }

    public void addSimCard(String number, double tarifSame, double balance) {
        boolean isAdded = false;
        for (int i = 0; i < simCards.length; i++) {
            if (simCards[i] == null) {
                simCards[i] = new SimCard(number, tarifSame, balance);
                display.printPhoneInfo(" New Card is created. My provider " + simCards[i].getProvider());
                isAdded = true;
                activeSim = i;
                if (simCards[0] != null && simCards[1] != null) {
                    activeSim = -1;
                }
                return;
            }
        }
        if (!isAdded) display.printPhoneInfo(" Phone doesn't have a slot for Sim Card");
    }

    public void chooseDefaultSimCard() {
        if (!isOn || (simCards[0] == null && simCards[1] == null)) {
            return;
        }
        for (int i = 0; i < simCards.length; i++) {
            display.printPhoneInfo(" index " + i + 1 + " Sim Card provider " + simCards[i].getProvider());
        }
        display.printPhoneInfo(" Choose default Sim Card for calls by index : 1 or 2 ");
        if (scanner.nextInt() == 1) {
            activeSim = 1;
        } else activeSim = 2;
        display.printPhoneInfo(" Active Sim Card is chosen : " + activeSim);
    }

    public void onOff() {
        if (isOn = !isOn) {
            display.printPhoneInfo(" Battery charge " + accumulator.getCurrentBatteryLevel() + " % ");
            for (SimCard simCard : simCards) {
                if (simCard != null) {
                    display.printPhoneInfo(" Sim card : " + simCard.info());
                }
            }
            display.printPhoneInfo(" Create a SimCard for being able to make a call ");
        }
    }

    public void charge() {
        while (accumulator.getCurrentBatteryLevel() < 100) {
            accumulator.chargeAccumulator();
        }
        display.printPhoneInfo(" Battery is charged " + accumulator.getCurrentBatteryLevel() + " % ");
    }

    public void topUpBalance(double someMoney, String phoneNumber) {
        for (int i = 0; i < simCards.length; i++) {
            if (simCards[i] != null && simCards[i].getNumber().equals(phoneNumber)) {
                simCards[i].setBalance(simCards[i].getBalance() + someMoney);
                display.printPhoneInfo(" Sim Card : " + simCards[i].info());
                return;
            }

        }
        display.printPhoneInfo(" Sim Card doesn't have a such phone number ");
    }

    public void call(int second, String destinationPhoneNumber) {
        if (!isOn || (simCards[0] == null && simCards[1] == null)) {
            return;
        }
        int currentSimCard;
        if (activeSim == -1) {
            display.printPhoneInfo(" Choose simcard for call : 1 or 2 ");
            if (scanner.nextInt() == 1) {
                currentSimCard = 1;
            } else currentSimCard = 2;
            display.printPhoneInfo(" Sim Card is chosen ");
        } else currentSimCard = activeSim;

        String myProvider = simCards[currentSimCard].getProvider();
        String destinationProvider = simCards[currentSimCard].identifyProvider(destinationPhoneNumber);
        double currentTarif;
        if (myProvider.equals(destinationProvider)) {
            currentTarif = simCards[currentSimCard].getTarifSame();
        } else if (destinationProvider.equals("Rouming")) {
            currentTarif = simCards[currentSimCard].getTarifRouming();
        } else currentTarif = simCards[currentSimCard].getTarifOther();

        if (simCards[currentSimCard].getBalance() < currentTarif) {
            display.printPhoneInfo(" Top up your balance before the call ");
            return;
        }
        display.printPhoneInfo("***  ");
        display.printPhoneInfo(" Current tarif " + currentTarif);
        display.printPhoneInfo(" my number " + myProvider);
        display.printPhoneInfo(" number to call " + destinationProvider);
        for (int i = 0; i < second; i++) {
            accumulator.dischargeAccumulator(0.1);
            simCards[currentSimCard].reduceBalance(currentTarif / 60);
            if (accumulator.getCurrentBatteryLevel() <= 0) {
                display.printPhoneInfo(" Phone is discharge ");
                display.printPhoneInfo(" Your call lasted " + second / 60 + " min " + second % 60 + " seconds ");
                isOn = false;
                return;
            }
            if (simCards[currentSimCard].getBalance() <= 0) {
                display.printPhoneInfo(" You run out of money. The call is finished");
                display.printPhoneInfo(" Your call lasted " + second / 60 + " min " + second % 60 + " seconds ");
                return;
            }
        }
        display.printPhoneInfo(" Your call lasted " + second / 60 + " min " + second % 60 + " seconds ");
        display.printPhoneInfo(" Battery state " + accumulator.getCurrentBatteryLevel() + " % ");
        display.printPhoneInfo(" Sim Card balance " + simCards[currentSimCard].getBalance() + " $ ");
    }


}
