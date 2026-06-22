package oop.io.bytes.objects.person;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Address address = new Address("Dnipro", "Nezalezhnosti", 56);
        Address address1 = new Address("Kyev", "ProspectSvobody", 32);
        Person person = new Person("Oleh", "Petrov", 110.25, true, 789456123,
                new Date(1970, 3, 21), address, PeopleController.getPhoto("15471.jpg"));
        Person person1 = new Person("Petro", "Kurochin", 97.25, false, 123456789,
                new Date(1969, 6, 12), address1, null);

        boolean isSaved = PeopleController.save(person);
        boolean isSaved1 = PeopleController.save(person1);

        System.out.println("isSaved" + isSaved);
        System.out.println("isSaved1" + isSaved1);

        Person findedPerson = PeopleController.findByInn(person.getInn());
        System.out.println("findedPerson" + findedPerson);
        System.out.println("person.getInn() " + person.getInn());
        assert findedPerson != null;
        System.out.println("findedPerson.getInn() " + findedPerson.getInn());


        boolean isUpdated = PeopleController.update(person1);
        System.out.println("isUpdated " + isUpdated);
        boolean isDeleted = PeopleController.delete(person1);
        System.out.println("isDeleted " + isDeleted);


    }
}
