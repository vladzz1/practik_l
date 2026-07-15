package org.example;
import lombok.Data;

@Data
public class Cat extends Animal {
    private  boolean indorOnly; //де живе котик
    //встановлюю дефолт значення для кота
    public Cat() {
        super("Кіт", 2);
        this.indorOnly = false;
    }
    public Cat(String name, int age, boolean indorOnly)
    {
        super(name, age);
        this.indorOnly = indorOnly;
    }
    @Override
    public String toString()
    {
        String str = super.toString();
        str += "\t Живе в хаті" + indorOnly;
        return str;
    }
}
