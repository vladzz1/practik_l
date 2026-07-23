package org.example;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
public class Builder extends Human {
    private int theNumberOfConstructedBuildings;

    public Builder() { super(); }

    public Builder(String firstName, String lastName, int age, LocalDateTime dateOfBirth, int theNumberOfConstructedBuildings) {
        super(firstName, lastName, age, dateOfBirth);
        this.theNumberOfConstructedBuildings = theNumberOfConstructedBuildings;
    }

    @Override
    public String toString() {
        return "Builder(firstName=" + this.getFirstName() + ", lastName=" + this.getLastName() + ", age=" + this.getAge() + ", dateOfBirth=" + this.getDateOfBirth() + ", theNumberOfConstructedBuildings=" + this.getTheNumberOfConstructedBuildings() + ")";
    }
}
