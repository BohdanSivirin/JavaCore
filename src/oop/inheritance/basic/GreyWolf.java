package oop.inheritance.basic;

public final class GreyWolf extends Wolf {
    private final String type = "Grey Wolf";
    private String name;

    public GreyWolf(double weight, int age, int sleepingTime, boolean isPredator, boolean isFluffy, String name) {
        super(weight, age, sleepingTime, isPredator, isFluffy);
        this.name = name;
    }

    public void bite() {
        System.out.println(" Grey wolf is biting you ");
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public void info() {
        super.info();
        System.out.println(" wolf type : " + type);
        System.out.println(" wolf name : " + name);
    }

    public void voice() {
        System.out.println(" wolf is rrrrrr ");
    }
}
