package oop.statics.singleton;


public class Accounter {
    private String name;
    public static final Accounter[] accounter = new Accounter[2];

    private Accounter(String name) {
        this.name = name;
        System.out.println(" Accounter " + name + " created ");
    }

    public static Accounter createAccounter(String name) {
        for (int i = 0; i < accounter.length; i++) {
            if (accounter[i] == null) {
                accounter[i] = new Accounter(name);
                return accounter[i];
            } else if (accounter[i].name.equals(name)) {
                System.out.println(" Accounter " + accounter[i].name + " already exist ");
                return accounter[i];
            }
        }
        System.out.println(" Cannot create more than 2 accounters ");
        return null;
    }


}
