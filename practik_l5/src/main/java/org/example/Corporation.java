package org.example;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Corporation {
    private static final String FILE_PATH = "employees.txt";
    private static final List<Employee> employees = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public void start() {
        loadFromFileSilent();

        boolean running = true;
        while (running) {
            printMenu();
            System.out.print("Виберіть пункт меню: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> addEmployee();
                case "2" -> editEmployee();
                case "3" -> deleteEmployee();
                case "4" -> searchByLastName();
                case "5" -> printAllEmployees();
                case "6" -> printByAge();
                case "7" -> printByFirstLetterOfLastName();
                case "8" -> loadFromFileManual();
                case "9" -> saveToFileManual();
                case "10" -> {
                    autoSaveAndExit();
                    running = false;
                }
                default -> System.out.println("❌ Некоректний вибір. Спробуйте ще раз.");
            }
            System.out.println();
        }
    }

    private static void printMenu() {
        System.out.println("\n===== МЕНЮ КОРПОРАЦІЇ =====");
        System.out.println("1. Додати співробітника");
        System.out.println("2. Редагування даних співробітника");
        System.out.println("3. Видалення співробітника");
        System.out.println("4. Пошук співробітника по прізвищу");
        System.out.println("5. Вивід інформації про всіх співробітників");
        System.out.println("6. Вивід інформації по віку");
        System.out.println("7. Вивід інформації по першій букві прізвища");
        System.out.println("8. Завантажити співробітників з файлу");
        System.out.println("9. Зберегти співробітників в файл");
        System.out.println("10. Вихід (з автозбереженням)");
    }

    private static void addEmployee() {
        System.out.print("Введіть прізвище: ");
        String lastName = scanner.nextLine().trim();
        System.out.print("Введіть ім'я: ");
        String firstName = scanner.nextLine().trim();
        System.out.print("Введіть вік: ");
        int age = readInt();

        String id = UUID.randomUUID().toString().substring(0, 5);
        employees.add(new Employee(id, lastName, firstName, age));
        System.out.println("✅ Співробітника успішно додано! Наданий ID: " + id);
    }

    private static void editEmployee() {
        System.out.print("Введіть ID співробітника для редагування: ");
        String id = scanner.nextLine().trim();
        Employee emp = findById(id);

        if (emp == null) {
            System.out.println("❌ Співробітника з таким ID не знайдено.");
            return;
        }

        System.out.print("Нове прізвище (натисніть Enter, щоб залишити " + emp.getLastName() + "): ");
        String lastName = scanner.nextLine().trim();
        if (!lastName.isEmpty()) emp.setLastName(lastName);

        System.out.print("Нове ім'я (натисніть Enter, щоб залишити " + emp.getFirstName() + "): ");
        String firstName = scanner.nextLine().trim();
        if (!firstName.isEmpty()) emp.setFirstName(firstName);

        System.out.print("Новий вік (введіть 0, щоб залишити " + emp.getAge() + "): ");
        int age = readInt();
        if (age > 0) emp.setAge(age);

        System.out.println("✅ Дані успішно оновлено!");
    }

    private static void deleteEmployee() {
        System.out.print("Введіть ID співробітника для видалення: ");
        String id = scanner.nextLine().trim();
        Employee emp = findById(id);

        if (emp != null) {
            employees.remove(emp);
            System.out.println("✅ Співробітника " + emp.getLastName() + " видалено.");
        }
        else {
            System.out.println("❌ Співробітника з таким ID не знайдено.");
        }
    }

    private static void searchByLastName() {
        System.out.print("Введіть прізвище (або його частину) для пошуку: ");
        String search = scanner.nextLine().trim().toLowerCase();
        boolean found = false;

        for (Employee emp : employees) {
            if (emp.getLastName().toLowerCase().contains(search)) {
                System.out.println(emp);
                found = true;
            }
        }
        if (!found) System.out.println("ℹ️ Нікого не знайдено.");
    }

    private static void printAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("ℹ️ Список співробітників порожній.");
            return;
        }
        System.out.println("--- Список всіх співробітників ---");
        employees.forEach(System.out::println);
    }

    private static void printByAge() {
        System.out.print("Введіть шуканий вік: ");
        int targetAge = readInt();
        boolean found = false;

        for (Employee emp : employees) {
            if (emp.getAge() == targetAge) {
                System.out.println(emp);
                found = true;
            }
        }
        if (!found) System.out.println("ℹ️ Співробітників такого віку немає.");
    }

    private static void printByFirstLetterOfLastName() {
        System.out.print("Введіть першу літеру прізвища: ");
        String input = scanner.nextLine().trim();
        if (input.isEmpty()) return;

        char letter = Character.toLowerCase(input.charAt(0));
        boolean found = false;

        for (Employee emp : employees) {
            if (!emp.getLastName().isEmpty() && Character.toLowerCase(emp.getLastName().charAt(0)) == letter) {
                System.out.println(emp);
                found = true;
            }
        }
        if (!found) System.out.println("ℹ️ Немає співробітників на цю літеру.");
    }

    private static void loadFromFileManual() {
        if (loadFromFile()) {
            System.out.println("✅ Дані успішно завантажені з файлу " + FILE_PATH);
        }
    }

    private static void saveToFileManual() {
        saveToFile();
        System.out.println("✅ Дані успішно збережені у файл " + FILE_PATH);
    }

    private static void autoSaveAndExit() {
        saveToFile();
        System.out.println("💾 Дані автоматично збережено. До побачення!");
    }


    private static Employee findById(String id) {
        return employees.stream()
                .filter(e -> e.getId().equalsIgnoreCase(id))
                .findFirst()
                .orElse(null);
    }

    private static int readInt() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("❌ Помилка! Введіть коректне ціле число: ");
            }
        }
    }

    private static void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Employee emp : employees) {
                writer.write(emp.toFileString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Помилка збереження у файл: " + e.getMessage());
        }
    }

    private static boolean loadFromFile() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            System.out.println("⚠️ Файл " + FILE_PATH + " ще не створено.");
            return false;
        }

        employees.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    Employee emp = Employee.fromFileString(line);
                    if (emp != null) employees.add(emp);
                }
            }
            return true;
        }
        catch (IOException e) {
            System.err.println("Помилка читання файлу: " + e.getMessage());
            return false;
        }
    }

    private static void loadFromFileSilent() {
        File file = new File(FILE_PATH);
        if (file.exists()) {
            loadFromFile();
            System.out.println("🤖 Знайдено файл бази даних. Автоматично завантажено " + employees.size() + " співробітників.");
        }
    }
}
