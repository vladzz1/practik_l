package org.example;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
public class Sailor extends Human {
    private int numberOfKilometersSwum;

    public Sailor() { super(); }

    public Sailor(String firstName, String lastName, int age, LocalDateTime dateOfBirth, int numberOfKilometersSwum) {
        super(firstName, lastName, age, dateOfBirth);
        this.numberOfKilometersSwum = numberOfKilometersSwum;
    }

    @Override
    public String toString() {
        return "Sailor(firstName=" + this.getFirstName() + ", lastName=" + this.getLastName() + ", age=" + this.getAge() + ", dateOfBirth=" + this.getDateOfBirth() + ", numberOfKilometersSwum=" + this.getNumberOfKilometersSwum() + ")";
    }
}
