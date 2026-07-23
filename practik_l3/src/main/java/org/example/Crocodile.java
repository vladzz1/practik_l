package org.example;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Crocodile extends Animal {
    private int numberOfScars;

    public Crocodile() { super(); }

    public Crocodile(String name, float weight, int age, int numberOfScars) {
        super(name, weight, age);
        this.numberOfScars = numberOfScars;
    }

    @Override
    public String toString() {
        return "Crocodile(name=" + this.getName() + ", weight=" + this.getWeight() + ", age=" + this.getAge() + ", numberOfScars=" + this.getNumberOfScars() + ")";
    }
}