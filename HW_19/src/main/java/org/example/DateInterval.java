package org.example;

public class DateInterval {
    private final MyDate start;
    private MyDate end;

    public DateInterval(MyDate start, MyDate end) {
        if (compare(start, end) > 0) {
            throw new IllegalArgumentException("Start date must be before end date");
        }
        this.start = start;
        this.end = end;
    }

    // проверка, входит ли дата в интервал
    public boolean contains(MyDate date) {
        return compare(start, date) <= 0 && compare(date, end) <= 0;
    }

    // вспомогательный метод для сравнения дат: возвращает отрицательное, если d1 < d2, 0 если равны, положительное если d1 > d2
    private int compare(MyDate d1, MyDate d2) {
        if (d1.year != d2.year) return d1.year - d2.year;
        if (d1.month.ordinal() != d2.month.ordinal()) return d1.month.ordinal() - d2.month.ordinal();
        return d1.day - d2.day;
    }
}
