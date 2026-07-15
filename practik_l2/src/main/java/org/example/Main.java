package org.example;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("-----обота з класами------");
        //Animal cat = new Animal();
        //cat.setName("Барсик рижик");
        //cat.setAge(4);
        //System.out.println(cat);
        //Animal mary = new Animal("Mary", 2);
        //System.out.println(mary);

        //Cat myCat = new Cat();
        //System.out.println(myCat);

        //Dog myDog = new Dog();
        //System.out.println(myDog);

        //ArrayList<Animal> list = new ArrayList<Animal>();
        //list.add(myCat);
        //list.add(myDog);

        //завдання 1
        Man man = new Man("Іван", 21, 1.90F, 56.0F);
        System.out.println(man);

        //завдання 2
        City city = new City("None", 1);
        System.out.println(city);

        //завдання 3
        Country country = new Country("None");
        System.out.println(country);

        //завдання 4
        Fractions fractions = new Fractions("None");
        System.out.println(fractions);

        //завдання 5
        Book book = new Book();
        book.setBookTitle("None");
        book.setAuthorFullName("None");
        book.setYearOfManufacture(2009);
        book.setPublisherName("Name");
        book.setBookGenre("fantasy");
        book.setNumberOfPages(230);
        System.out.println(book);

        //завдання 6
        Car car = new Car();
        car.setCarName("None");
        car.setManufacturerName("None");
        car.setYearOfManufacture(2014);
        car.setEngineDisplacement(6.5F);
        System.out.println(car);
    }
}