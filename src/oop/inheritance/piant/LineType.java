package oop.inheritance.piant;

public enum LineType {
    THIN(1),
    FAT(3),
    VERY_FAT(7);

    private int fat;

    LineType(int fat) {
        this.fat = fat;
    }
}
