package org.example;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class LongestLineFinder {
    public void start(String filePath) {
        try {
            List<String> lines = Files.readAllLines(Path.of(filePath));

            String longestLine = "";
            int longestLineIndex = -1;

            for (int i = 0; i < lines.size(); i++) {
                String currentLine = lines.get(i);
                if (currentLine.length() > longestLine.length()) {
                    longestLine = currentLine;
                    longestLineIndex = i;
                }
            }

            System.out.println("---Пошук найдовшого рядка---");
            if (longestLineIndex != -1) {
                System.out.printf("%d символів%n", longestLine.length());
                System.out.printf("|%s|%n", longestLine);
            }
            else {
                System.out.println("Файл порожній.");
            }
            System.out.println("----------------------------");

        }
        catch (IOException x) {
            System.err.println("Помилка зчитування файлу: " + x.getMessage());
        }
    }
}
