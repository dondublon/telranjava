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

    public static MyDate parse(String s) {
        if (s == null) throw new IllegalArgumentException("input is null");
        String[] parts = s.split("\\.");
        if (parts.length != 3) throw new IllegalArgumentException("expected format mm.dd.yyyy");
        int monthNum;
        int day;
        int year;
        try {
            monthNum = Integer.parseInt(parts[0]);
            day = Integer.parseInt(parts[1]);
            year = Integer.parseInt(parts[2]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("non-numeric date component", e);
        }
        if (monthNum < 1 || monthNum > 12) throw new IllegalArgumentException("month out of range: " + monthNum);
        Month month = Month.values()[monthNum - 1]; // использует порядок enum
        // минимальные проверки дня (упрощённо, без учёта високосного февраля)
        if (day < 1 || day > 31) throw new IllegalArgumentException("day out of range: " + day);
        return new MyDate(day, month, year);
    }


}
