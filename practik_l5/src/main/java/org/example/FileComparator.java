package org.example;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileComparator {
    public void start(String file1Path, String file2Path) {
        try {
            List<String> file1Lines = Files.readAllLines(Path.of(file1Path));
            List<String> file2Lines = Files.readAllLines(Path.of(file2Path));

            int maxLines = Math.max(file1Lines.size(), file2Lines.size());

            System.out.println("---порівняння---");
            for (int i = 0; i < maxLines; i++) {
                String line1 = (i < file1Lines.size()) ? file1Lines.get(i) : "";
                String line2 = (i < file2Lines.size()) ? file2Lines.get(i) : "";

                if (!line1.equals(line2)) {
                    System.out.printf("рядок %d |%s|%s|%n", (i + 1), line1, line2);
                }
            }
            System.out.println("----------------");
        }
        catch (IOException x) {
            System.err.println("Помилка зчитування файлів: " + x.getMessage());
        }
    }
}
