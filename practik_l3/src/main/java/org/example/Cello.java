package org.example;

public class Cello extends MusicalInstrument {
    public Cello() {
        super("просто віолончель", "ііііііііііііі", "цей інструмент створює музику", "None");
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