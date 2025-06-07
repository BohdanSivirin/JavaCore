package oop.inheritance.basic;

public final class OstrichChild extends Ostrich {
    private String name;

    public OstrichChild(boolean iBuryHeadInTheSand, String name) {
        super(iBuryHeadInTheSand);
        this.name = name;
    }

    public void hide() {
        System.out.println(" Ostrich hide ");
    }

    public String getName() {
        return name;
    }

    public void info() {
        super.info();
        System.out.println(" Ostrich child name : " + name);
    }

    @Override
    public void voice() {
        System.out.println(" Ostrich child shout  ");
    }

}
