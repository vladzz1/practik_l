package org.example;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Human {
    private String firstName;
    private String lastName;
    private int age;
    private LocalDateTime dateOfBirth;
}
