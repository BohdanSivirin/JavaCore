package oop.complex.phone;

public class Main {
    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.onOff();
        phone.chooseDefaultSimCard();
        phone.addSimCard("+380664330306", 4.66, 100.10);
        phone.call(25,"0938188312");
        phone.topUpBalance(78.10, "+380664330306");
        phone.call(10, "4778989");
        phone.addSimCard("+380634255021", 13.66, 106.7);
        phone.addSimCard("0664330306", 55.12, 56.7);
        phone.chooseDefaultSimCard();
        phone.charge();

    }
}
