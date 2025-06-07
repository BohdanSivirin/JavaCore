package oop.statics.singleton;

public class Sun {
    private final int size = 7845;
    private final String name = "Sun";
    private final String colour = "Yellow";
    private static Sun sun;

    private Sun() {
    }

    public static Sun getInstance() {
        if (sun == null) {
            sun = new Sun();
        }
        return sun;
    }

    void shine() {
        System.out.println(" Should be Sun if exist : " + sun);
        System.out.println(" The Sun " + colour + " is shining ");
    }


}
