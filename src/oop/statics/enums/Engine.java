package oop.statics.enums;

enum EngineTypes {
    DIESEL, BENZIN, ELECTRO
}

public enum Engine {
    BMW_D_3_252(Brand.BMW, EngineTypes.DIESEL, 3.0, 252),
    BMW_B_5_652(Brand.BMW, EngineTypes.BENZIN, 5.0, 652),
    MINI_B_2_200(Brand.MINI, EngineTypes.BENZIN, 2.0, 200),
    LAND_ROVER_D_2_185(Brand.LAND_ROVER, EngineTypes.ELECTRO, 2.0, 185);

    private Brand brand;
    private EngineTypes engineTypes;
    private double volume;
    private int power;

    Engine(Brand brand, EngineTypes engineTypes, double volume, int power) {
        this.brand = brand;
        this.engineTypes = engineTypes;
        this.volume = volume;
        this.power = power;
    }

    public void info() {
        System.out.println(" brand: " + brand);
        System.out.println(" engine: " + engineTypes);
        System.out.println(" volume: " + volume);
        System.out.println(" power: " + power);
    }

}
