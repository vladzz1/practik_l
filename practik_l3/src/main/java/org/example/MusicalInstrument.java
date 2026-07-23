package org.example;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MusicalInstrument {
    private String name;
    private String sound;
    private String description;
    private String history;
}