package org.example;

public class Steamship extends Device {
    public Steamship() {
        super("просто пароплав", "ууууууууу!!!", "цей пристрій вміє плавати");
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
