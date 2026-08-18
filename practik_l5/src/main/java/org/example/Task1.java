package org.example;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class Task1 {
    public void run() {
        Predicate<LocalDate> isLeapYear = LocalDate::isLeapYear;
        BiFunction<LocalDate, LocalDate, Long> daysBetween = ChronoUnit.DAYS::between;
        BiFunction<LocalDate, LocalDate, Long> weeksBetween = ChronoUnit.WEEKS::between;
        Function<LocalDate, java.time.DayOfWeek> dayOfWeek = LocalDate::getDayOfWeek;

        System.out.println("чи є рік високосним: " + isLeapYear.test(LocalDate.of(2025, 6, 2)));
        System.out.println("кількість днів між двома датами: " + daysBetween.apply(LocalDate.of(2024, 2, 1), LocalDate.of(2024, 6, 3)));
        System.out.println("кількість повних неділь між двома датами: " + weeksBetween.apply(LocalDate.of(2026, 6, 5), LocalDate.of(2026, 7, 1)));
        System.out.println("день тижня: " + dayOfWeek.apply(LocalDate.of(1967, 3, 12)));
    }
}
