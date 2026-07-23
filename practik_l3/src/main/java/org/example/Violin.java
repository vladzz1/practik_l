package org.example;

public class Violin extends MusicalInstrument {
    public Violin() {
        super("просто скрипка", "іііііііі", "цей інструмент створює музику", "None");
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

    public void history() {
        System.out.println(this.getHistory());
    }
}