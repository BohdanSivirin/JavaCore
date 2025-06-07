package oop.statics.singleton;

public enum Earth {
    EARTH(10000);
    private int size;

    Earth(int size) {
        this.size = size;
    }

    int changeSize(int value){
        this.size=size+value;
        return size;
    }
}
