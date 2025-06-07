package oop.interfaces.basic;

public class Main {
    public static void main(String[] args) {
        Person person = new Person(99, "Pol");
        Musician barber = new Barber(33, "Bob", true, 5, Musician.INSTRUMENT_1);
        Student student = new PartTimeStudent(25, "Freddy", "Cambridge", Sportsman.SPORT_TYPE_3, Musician.INSTRUMENT_3);
        Tractorist partTimeStudent = new PartTimeStudent(19, "Jack", "Oxford", Sportsman.SPORT_TYPE_1, Musician.INSTRUMENT_3);
        FullTimeStudent fullTimeStudent = new FullTimeStudent(27, "Lauren", "DGY", Sportsman.SPORT_TYPE_2, Musician.INSTRUMENT_2);
        MusicBand musicBand = new MusicBand();
        Gym gym = new Gym();
        gym.addSportsman(fullTimeStudent);
        gym.addSportsman((Sportsman) partTimeStudent);
        gym.addSportsman(student);
        musicBand.addMusician(fullTimeStudent);
        musicBand.addMusician((Musician) partTimeStudent);
        musicBand.addMusician(student);
        musicBand.addMusician(barber);
        Sportsman sportsman = (Sportsman) new Barber(33, "Bob", true, 5, Musician.INSTRUMENT_1);
        gym.addSportsman(sportsman);
        gym.doSport();
        musicBand.perform();

    }
}
