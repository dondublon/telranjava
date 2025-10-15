package org.example;

public class MyDate implements Comparable<MyDate> {
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
    public String toString() {
        return String.format("%s.%s.%s", this.day, this.month, this.year);
    }

    @Override
    public int compareTo(MyDate other) {
        if (this.year != other.year) return this.year - other.year;
        if (this.month.ordinal() != other.month.ordinal()) return this.month.ordinal() - other.month.ordinal();
        return this.day - other.day;
    }
}
