package oop.statics.enums;

enum Type {
    TIP_TRONIC, DSG, VARIATOR, MANUAL
}

public enum Transmition {
    SPORT(8, Type.TIP_TRONIC),
    STANDART(6, Type.DSG),
    STANDART_PLUS(5, Type.VARIATOR),
    OPTIMAL(5, Type.MANUAL);

    private int speedAmount;
    private Type type;

    private Transmition(int speedAmount, Type type) {
        this.speedAmount = speedAmount;
        this.type = type;
    }

    void info(){
        System.out.println(" speed amount : " + speedAmount);
        System.out.println(" type : " + type);
    }

}
