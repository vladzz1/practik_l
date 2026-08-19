package org.example;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class ArrayFileReader {
    public void start(String filePath) {
        long totalSumOfAllArrays = 0;
        int rowNumber = 1;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) { continue; }

                int[] array = Arrays.stream(line.split("[,\\s]+")).mapToInt(Integer::parseInt).toArray();

                int min = Arrays.stream(array).min().orElseThrow();
                int max = Arrays.stream(array).max().orElseThrow();
                long currentArraySum = Arrays.stream(array).sum();

                totalSumOfAllArrays += currentArraySum;

                System.out.println("---Рядок №" + rowNumber + "---");
                System.out.println("Масив: " + Arrays.toString(array));
                System.out.println("Мінімальне число: " + min);
                System.out.println("Максимальне число: " + max);
                System.out.println("Сума масиву: " + currentArraySum);
                System.out.println();

                rowNumber++;
            }

            System.out.println("=================================");
            System.out.println("загальна сума всіх масивів: " + totalSumOfAllArrays);
            System.out.println("=================================");
        }
        catch (IOException x) {
            System.err.println("Помилка читання файлу: " + x.getMessage());
        }
        catch (NumberFormatException x) {
            System.err.println("Помилка формату чисел у файлі: " + x.getMessage());
        }
    }
}
