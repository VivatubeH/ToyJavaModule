package util;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

public class CalendarCreator {
    private Scanner in;

    public CalendarCreator() {
        this.in = new Scanner(System.in);
    }

    public void printCalendar() {
        System.out.print("년도를 입력하세요: ");
        int year = this.in.nextInt();
        System.out.print("월을 입력하세요: ");
        int month = this.in.nextInt();
        this.printCalendar(year, month);
    }

    private void printCalendar(int year, int month) {
        LocalDate firstdate = LocalDate.of(year, month, 1);
        LocalDate lastDate = firstdate.plusMonths(1L);
        System.out.println("Su Mo Tu We Th Fr Sa");
        int firstDayOffset = firstdate.getDayOfWeek().getValue() % 7;

        for(int i = 0; i < firstDayOffset; ++i) {
            System.out.print("   ");
        }

        for(LocalDate dayIterator = firstdate; dayIterator.isBefore(lastDate); dayIterator = dayIterator.plusDays(1L)) {
            System.out.printf("%2d ", dayIterator.getDayOfMonth());
            if (dayIterator.getDayOfWeek() == DayOfWeek.SATURDAY) {
                System.out.println();
            }
        }

    }
}