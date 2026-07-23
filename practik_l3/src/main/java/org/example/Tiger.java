package org.example;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Tiger extends Animal {
    private int howManyAnimalsHeHunted;

    public Tiger() { super(); }

    public Tiger(String name, float weight, int age, int howManyAnimalsHeHunted) {
        super(name, weight, age);
        this.howManyAnimalsHeHunted = howManyAnimalsHeHunted;
    }

    @Override
    public String toString() {
        return "Tiger(name=" + this.getName() + ", weight=" + this.getWeight() + ", age=" + this.getAge() + ", howManyAnimalsHeHunted=" + this.getHowManyAnimalsHeHunted() + ")";
    }
}