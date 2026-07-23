package org.example;

public class Microwave extends Device {
    public Microwave() {
        super("просто мікрохвильовка", "ууууууууууу", "цим пристроєм можна розігріти їжу");
    }

    public void sound() {
        System.out.println(this.getSound());
    }

    public void show() {
        System.out.println(this.getName());
    }

    public void desc() {
        System.out.println(this.getDescription());
    }
}