package org.example;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    private String carName;
    private String manufacturerName;
    private int yearOfManufacture;
    private float engineDisplacement;
}
