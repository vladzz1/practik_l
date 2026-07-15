package org.example;
import lombok.Data;

@Data
public class Dog extends Animal {
    private int trainingCommandsCount;

    public Dog() {
        super("Собака", 2);
        this.trainingCommandsCount = 3;
    }
    @Override
    public String toString()
    {
        String str = super.toString();
        str += "\t Живе в хаті" + trainingCommandsCount;
        return str;
    }
}
