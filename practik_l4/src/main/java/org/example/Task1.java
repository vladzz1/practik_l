package org.example;
import java.util.Random;
import java.util.Scanner;

public class Task1 {
    public void run(Scanner scanner) {
        System.out.print("Введіть середній час між появою пасажирів: ");
        float avgPassengerTime = scanner.nextFloat();
        System.out.print("Введіть середній час між появою катерів: ");
        float avgBoatTime = scanner.nextFloat();
        System.out.print("Введіть тип зупинки (кінцева чи ні, true/false): ");
        boolean isTerminal = scanner.nextBoolean();
        System.out.print("Введіть максимальну кількість людей на зупинці: ");
        int max = scanner.nextInt();

        Random random = new Random();
        double avgStayTime = avgPassengerTime * 1.5;
        double intervalForN = avgBoatTime * (max / 5.0 + 0.5);
        int freeSeats = random.nextInt(20) + 1;

        System.out.println("---моделювання---");
        System.out.println("Середній час перебування: " + avgStayTime + " хв.");
        System.out.println("Достатній інтервал часу для максимуму людей: " + intervalForN + " хв.");
        System.out.println("Вільних місць: " + freeSeats);
    }
}
