package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Booking {
    // список бронирований
    private final Map<Integer, List<BookItem>> byRoomNumber;
    private final Map<Person, List<BookItem>> byPerson;

    public Booking() {
        this.byRoomNumber = new HashMap<Integer, List<BookItem>>();
        this.byPerson = new HashMap<Person, List<BookItem>>();
    }

    public List<BookItem> getByPerson(Person person) {
        return this.byPerson.get(person);
    }

    public List<BookItem> getByRoom(int roomNumber) {
        return this.byRoomNumber.get(roomNumber);
    }

    public List<BookItem> getByDate(MyDate date) {
        // all bookings by date
        var result = new ArrayList<BookItem>();
        for (var books: this.byRoomNumber.values()) {
            for (var book: books) {
                if (book.interval.contains(date)) {
                    result.add(book);
                }
            }
        }
        return result;
    }

    public boolean isRoomBooked(int roomNumber, MyDate date) {
        var roomBooks = this.byRoomNumber.get(roomNumber);
        if (roomBooks == null) {
            return false;
        }
        for (var book: roomBooks) {
            if (book.interval.contains(date)) {
                return true;
            }
        }
        return false;
    }

    public boolean book(Person person, BookItem bookItem) {
        if (this.isRoomBooked(bookItem.roomNumber, bookItem.interval.start) ||
                this.isRoomBooked(bookItem.roomNumber, bookItem.interval.end)
                ) {
            System.out.printf("The room %s is already booked for this dates.", bookItem.roomNumber);
            return false;
        };

        if (!this.byRoomNumber.containsKey(bookItem.roomNumber))
        {
            this.byRoomNumber.put(bookItem.roomNumber, new ArrayList<BookItem>());
        }

        this.byRoomNumber.get(bookItem.roomNumber).add(bookItem);
        if (!this.byPerson.containsKey(person)){
            this.byPerson.put(person, new ArrayList<BookItem>());
        }
        this.byPerson.get(person).add(bookItem);
        return true;
    }

    public boolean remove(BookItem bookItem) {
        // Для простоты сравниваем только ссылки. Можно переделать на equals.
        var room_number = bookItem.roomNumber;
        var book_items_for_room = this.byRoomNumber.get(room_number);
        if (book_items_for_room != null) {
            book_items_for_room.removeIf(by_room -> by_room == bookItem);
        }

        for (var pers_book: this.byPerson.values()) {
            if (pers_book != null) {
                pers_book.removeIf(by_room -> by_room == bookItem);
            }
        }
        return true;
    }


}
