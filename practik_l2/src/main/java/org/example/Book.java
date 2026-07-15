package org.example;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private String bookTitle;
    private String authorFullName;
    private int yearOfManufacture;
    private String publisherName;
    private String bookGenre;
    private int numberOfPages;
}
