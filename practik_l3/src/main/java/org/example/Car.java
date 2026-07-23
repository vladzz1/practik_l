package org.example;

public class Car extends Device {
    public Car() {
        super("просто автомобіль", "ррррррррррр", "цей пристрій вміє їздити");
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
