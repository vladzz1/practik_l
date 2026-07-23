package org.example;

public class Kettle extends Device {
    public Kettle() {
        super("просто чайник", "іііііііі", "цим пристроєм можна кип'ятити воду");
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