package org.example;

public class BookItem {
    public int roomNumber;
    public DateInterval interval;

    public BookItem (int roomNumber, DateInterval interval) {
        this.roomNumber = roomNumber;
        this.interval = interval;
    }
    public String toString() {
        return String.format("{BookItem room %s: %s}", this.roomNumber, this.interval);
    }
}
