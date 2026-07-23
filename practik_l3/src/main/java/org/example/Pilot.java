package org.example;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
public class Pilot extends Human {
    private int numberOfFlights;

    public Pilot() { super(); }

    public Pilot(String firstName, String lastName, int age, LocalDateTime dateOfBirth, int numberOfFlights) {
        super(firstName, lastName, age, dateOfBirth);
        this.numberOfFlights = numberOfFlights;
    }

    @Override
    public String toString() {
        return "Pilot(firstName=" + this.getFirstName() + ", lastName=" + this.getLastName() + ", age=" + this.getAge() + ", dateOfBirth=" + this.getDateOfBirth() + ", numberOfFlights=" + this.getNumberOfFlights() + ")";
    }
}
