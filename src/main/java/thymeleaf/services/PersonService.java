package thymeleaf.services;

public class PersonService {
    Person person;

    public void createPerson(String name, int age) {
        this.person = new Person(name, age);
    }

    public Person getPerson() {
        return this.person;
    }
    /*public static Person findPerson() {
        //find person
        Person
        return
    }

     */
}
