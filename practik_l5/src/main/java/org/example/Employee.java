package org.example;
import lombok.Getter;
import lombok.Setter;

@Getter
public class Employee {
    private final String id;
    @Setter
    private String lastName;
    @Setter
    private String firstName;
    @Setter
    private int age;

    public Employee(String id, String lastName, String firstName, int age) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("ID: %s | Прізвище: %s | Ім'я: %s | Вік: %d", id, lastName, firstName, age);
    }

    public String toFileString() {
        return id + "|" + lastName + "|" + firstName + "|" + age;
    }

    public static Employee fromFileString(String line) {
        String[] parts = line.split("\\|");
        if (parts.length == 4) {
            return new Employee(parts[0], parts[1], parts[2], Integer.parseInt(parts[3]));
        }
        return null;
    }
}
