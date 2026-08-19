package org.example;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.Console;
import java.util.Scanner;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        System.out.println("Привіт козаки :)");
        //SpringApplication.run(Main.class, args);
        //new Task1().run();
        //new Task2().run();
        //new Task3().run();
        //new Task4().run();

        //завдання 1

        new FileComparator().start("textFile1", "textFile2");

        //завдання 2

        new LongestLineFinder().start("textFile3");

        //завдання 3

        new ArrayFileReader().start("textFile4");

        //завдання 4

        Scanner scanner = new Scanner(System.in);
        System.out.print("введіть шлях куди записати файл: ");
        String path = scanner.nextLine();
        System.out.print("введіть перше число масиву: ");
        int number1 = scanner.nextInt();
        System.out.print("введіть друге число масиву: ");
        int number2 = scanner.nextInt();
        System.out.print("введіть третє число масиву: ");
        int number3 = scanner.nextInt();
        System.out.print("введіть четверте число масиву: ");
        int number4 = scanner.nextInt();
        System.out.print("введіть п'яте число масиву: ");
        int number5 = scanner.nextInt();
        System.out.print("введіть шосте число масиву: ");
        int number6 = scanner.nextInt();
        System.out.print("введіть сьоме число масиву: ");
        int number7 = scanner.nextInt();
        System.out.print("введіть восьме число масиву: ");
        int number8 = scanner.nextInt();
        System.out.print("введіть дев'яте число масиву: ");
        int number9 = scanner.nextInt();
        System.out.print("введіть десяте число масиву: ");
        int number10 = scanner.nextInt();
        int[] array = {number1, number2, number3, number4, number5, number6, number7, number8, number9, number10};
        new ArrayFileWriter().start(path, array);

        //завдання 5

        new Corporation().start();
    }
}