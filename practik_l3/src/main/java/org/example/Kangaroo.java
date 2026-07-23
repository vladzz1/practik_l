package org.example;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Kangaroo extends Animal {
    private float jumpHeight;

    public Kangaroo() { super(); }

    public Kangaroo(String name, float weight, int age, float jumpHeight) {
        super(name, weight, age);
        this.jumpHeight = jumpHeight;
    }

    @Override
    public String toString() {
        return "Kangaroo(name=" + this.getName() + ", weight=" + this.getWeight() + ", age=" + this.getAge() + ", jumpHeight=" + this.getJumpHeight() + ")";
    }
}
