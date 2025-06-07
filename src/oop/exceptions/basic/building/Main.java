package oop.exceptions.basic.building;

public class Main {
    public static void main(String[] args) {

        Building building = new Building(new int[]{4, 8, 7, 5, 6});
        building.info();
        Domophone domophone = new Domophone();
        building.connectDomophone(domophone);
        domophone.menu();


    }
}
