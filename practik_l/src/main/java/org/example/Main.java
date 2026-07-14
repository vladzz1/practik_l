package org.example;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void showLine(int length, String direction, char symbol) {
        if (length < 1)
        {
            System.out.println("параметри передані неправильно");
            return;
        }
        if (Objects.equals(direction, "vertical"))
        {
            for (int i = 0; i <= length; i++)
            {
                System.out.println(symbol);
            }
        }
        else if (Objects.equals(direction, "horizontal"))
        {
            for (int i = 0; i <= length; i++)
            {
                System.out.print(symbol);
            }
            System.out.println();
        }
        else
        {
            System.out.println("параметри передані неправильно");
        }
    }
    public static int[] sort(int[] array, boolean isDesc) {
        if (isDesc)
        {
            for (short i = 0; i < array.length - 1; i++)
            {
                for (short j = 0; j < array.length - i - 1; j++)
                {
                    if (array[j] < array[j + 1])
                    {
                        int temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
                }
            }
        }
        else
        {
            for (short i = 0; i < array.length - 1; i++)
            {
                for (short j = 0; j < array.length - i - 1; j++)
                {
                    if (array[j] > array[j + 1])
                    {
                        int temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
                }
            }
        }
        return array;
    }
    public static void main(String[] args) {
        //завдання 1
        System.out.print("\"Your time is limited,\n\t so don’t waste it\n\t\t living someone else’s life\"\n\t\t\tSteve Jobs\n");

        //завдання 2
        Scanner scanner = new Scanner(System.in);
        System.out.print("значення: ");
        float value = scanner.nextInt();
        System.out.print("відсоток: ");
        float interest = scanner.nextInt();
        if (interest != 0)
        {
            System.out.println("результат: " + (value * interest) / 100.0);
        }
        else
        {
            System.out.println("неможна ділити на нуль");
        }

        //завдання 3
        scanner.nextLine();
        System.out.print("перше число: ");
        String number1 = scanner.nextLine();
        System.out.print("друге число: ");
        String number2 = scanner.nextLine();
        System.out.print("третє число: ");
        String number3 = scanner.nextLine();
        System.out.println("результат: " + number1 + number2 + number3);

        //завдання 4
        System.out.print("введіть шестизначне число: ");
        int number = scanner.nextInt();
        char[] array = Integer.toString(number).toCharArray();
        if (array.length == 6)
        {
            char number1_2 = array[5];
            char number2_2 = array[4];
            char number5_2 = array[1];
            char number6_2 = array[0];
            System.out.println("" + number1_2 + number2_2 + array[2] + array[3] + number5_2 + number6_2);
        }
        else
        {
            System.out.println("я просив шестизначне");
        }

        //завдання 5
        System.out.print("введіть число в діапазоні від 1 до 12: ");
        int number_2 = scanner.nextInt();
        if (number_2 == 1 || number_2 == 2 || number_2 == 12)
        {
            System.out.println("Winter");
        }
        else if (number_2 == 3 || number_2 == 4 || number_2 == 5)
        {
            System.out.println("Spring");
        }
        else if (number_2 == 6 || number_2 == 7 || number_2 == 8)
        {
            System.out.println("Summer");
        }
        else if (number_2 == 9 || number_2 == 10 || number_2 == 11)
        {
            System.out.println("Autumn");
        }
        else
        {
            System.out.println("я просив в діапазоні від 1 до 12");
        }

        //завдання 6
        System.out.print("введіть кількість метрів: ");
        float number_3 = scanner.nextFloat();
        System.out.print("1. милі\n2. дюйми\n3. ярди\nвведіть одиницю вимірювання в яку треба перевести метри: ");
        while (true)
        {
            int unit = scanner.nextInt();
            if (unit == 1)
            {
                System.out.printf("результат: %.3f%n", number_3 / 1609.0);
                break;
            }
            else if (unit == 2)
            {
                System.out.printf("результат: %.3f%n", number_3 / 0.0254);
                break;
            }
            else if (unit == 3)
            {
                System.out.printf("результат: %.3f%n", number_3 / 0.914);
                break;
            }
            else
            {
                System.out.println("виберіть 1, 2 або 3");
            }
        }

        //завдання 7

        System.out.print("введіть перше число: ");
        int number1_4 = scanner.nextInt();
        System.out.print("введіть друге число: ");
        int number2_4 = scanner.nextInt();
        if (number1_4 > number2_4)
        {
            int temp = number1_4;
            number1_4 = number2_4;
            number2_4 = temp;
        }
        for (int i = number1_4; i <= number2_4; i++)
        {
            if (i % 2 == 0)
            {
                System.out.print(i + " ");
            }
        }
        System.out.println();

        //завдання 8
        System.out.print("введіть перше число: ");
        int number1_5 = scanner.nextInt();
        System.out.print("введіть друге число: ");
        int number2_5 = scanner.nextInt();
        if (number1_5 > number2_5)
        {
            int temp = number1_5;
            number1_5 = number2_5;
            number2_5 = temp;
        }
        for (int i = number1_5; i <= number2_5; i++)
        {
            for (int j = 1; j < 10; j++)
            {
                System.out.println(i + " * " + j + " = " + i * j);
            }
            System.out.println("-----------");
        }

        //завдання 9
        int[] array2 = new int[50];
        Random rand = new Random();
        for (int i = 0; i < 50; i++)
        {
            array2[i] = rand.nextInt(50 - -50 + 1) + -50;
        }
        int min = array2[0];
        int max = array2[0];
        int negative = 0;
        int positive = 0;
        int zeros = 0;
        for (int item : array2)
        {
            if (item < min)
            {
                min = item;
            }
            if (item > max)
            {
                max = item;
            }
            if (item < 0)
            {
                negative++;
            }
            if (item >= 0)
            {
                positive++;
            }
            if (item == 0)
            {
                zeros++;
            }
        }
        System.out.println("мінімальне: " + min + "\nмаксимальне: " + max + "\n" + "від'ємних: " + negative + "\nдодатніх: " + positive + "\nнулів: " + zeros);

        //завдання 10
        ArrayList<Integer> array_even_numbers = new ArrayList<Integer>();
        ArrayList<Integer> array_odd_numbers = new ArrayList<Integer>();
        ArrayList<Integer> array_negative = new ArrayList<Integer>();
        ArrayList<Integer> array_positive = new ArrayList<Integer>();
        for (int item : array2)
        {
            if (item % 2 == 0)
            {
                array_even_numbers.add(item);
            }
            if (item % 2 != 0)
            {
                array_odd_numbers.add((item));
            }
            if (item < 0)
            {
                array_negative.add(item);
            }
            if (item >= 0)
            {
                array_positive.add(item);
            }
        }
        System.out.print("парні: ");
        for (int item : array_even_numbers)
        {
            System.out.print(item + " ");
        }
        System.out.print("\nнепарні: ");
        for (int item : array_odd_numbers)
        {
            System.out.print(item + " ");
        }
        System.out.print("\nвід'ємні: ");
        for (int item : array_negative)
        {
            System.out.print(item + " ");
        }
        System.out.print("\nдодатні: ");
        for (int item : array_positive)
        {
            System.out.print(item + " ");
        }
        System.out.println();

        //завдання 11
        showLine(5, "vertical", '#');
        showLine(7, "horizontal", '$');

        //завдання 12
        int[] array3 = sort(array2, false);
        for (int item : array3)
        {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}