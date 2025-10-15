package org.example;

public class MyDate {
    public int day;
    public Month month;
    public int year;

    public MyDate(int day, Month month, int year) {
        // minimal check
        if (day < 1 || day > 31) {
            throw new IllegalArgumentException("Wrong day");
        }
        if (year < 2020 || year > 2100) {
            throw new IllegalArgumentException("Wrong year");
        }
        this.day = day;
        this.month = month;
        this.year = year;
    }
}
