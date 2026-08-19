package org.example;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ArrayFileWriter {
    public void start(String filePath, int[] array) {
        if (array == null || array.length == 0) {
            System.out.println("Масив порожній, нічого записувати.");
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            String firstLine = Arrays.stream(array).mapToObj(String::valueOf).collect(Collectors.joining(" "));
            writer.write(firstLine);
            writer.newLine();

            String secondLine = Arrays.stream(array).filter(n -> n % 2 == 0).mapToObj(String::valueOf).collect(Collectors.joining(" "));
            writer.write(secondLine);
            writer.newLine();

            String thirdLine = Arrays.stream(array).filter(n -> n % 2 != 0).mapToObj(String::valueOf).collect(Collectors.joining(" "));
            writer.write(thirdLine);
            writer.newLine();

            int[] reversedArray = new int[array.length];
            for (int i = 0; i < array.length; i++) {
                reversedArray[i] = array[array.length - 1 - i];
            }
            String fourthLine = Arrays.stream(reversedArray).mapToObj(String::valueOf).collect(Collectors.joining(" "));
            writer.write(fourthLine);

            System.out.println("Масив успішно записано у файл: " + filePath);

        }
        catch (IOException e) {
            System.err.println("Помилка запису у файл: " + e.getMessage());
        }
    }
}
