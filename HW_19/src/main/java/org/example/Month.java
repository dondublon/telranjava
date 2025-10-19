package org.example;

public enum Month {
    JANUARY,
    FEBRUARY,
    MARCH,
    APRIL,
    MAY,
    JUNE,
    JULY,
    AUGUST,
    SEPTEMBER,
    OCTOBER,
    NOVEMBER,
    DECEMBER;

    public static Month fromInt(int m) {
        if (m < 1 || m > 12) throw new IllegalArgumentException("month out of range: " + m);
        return Month.values()[m - 1];
    }
}
